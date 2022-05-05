package edu.vassar.cmpu203.workoutapp.Controller;

import edu.vassar.cmpu203.workoutapp.Model.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import edu.vassar.cmpu203.workoutapp.Persistence.FirestoreFacade;
import edu.vassar.cmpu203.workoutapp.Persistence.IPersistenceFacade;
import edu.vassar.cmpu203.workoutapp.View.*;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ICreatePostView.Listener, IAddWorkout.Listener, ICreateProfileView.Listener, IFeedView.Listener, IWorkoutType.Listener, IFilterView.Listener, IHomeScreenView.Listener, IViewProfileView.Listener, IEditProfileView.Listener, IViewOtherProfileView.Listener, IFollowRequestView.Listener {

    private IMainView mainView;
    private Feed feed;
    private Feed filteredFeed = new Feed();
    private Profile curUser;

    private IPersistenceFacade persistenceFacade = new FirestoreFacade();



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getSupportFragmentManager().setFragmentFactory(new WorkoutAppFragFactory(this));

        super.onCreate(savedInstanceState);

        if(savedInstanceState == null) {
            this.feed = new Feed();
        }
        else {
            this.feed = (Feed) savedInstanceState.getSerializable("FEED");
            this.curUser = (Profile) savedInstanceState.getSerializable("CUR_USER");
        }

        this.persistenceFacade.retrieveFeed(new IPersistenceFacade.DataListener<Feed>() {
            @Override
            public void onDataReceived(@NonNull Feed feed) {
                MainActivity.this.feed = feed;
                Fragment curFrag = MainActivity.this.mainView.getCurrentFragment();
                if(curFrag instanceof IFeedView)
                    ((IFeedView) curFrag).onFeedUpdated(feed);
            }

            @Override
            public void onNoDataFound() {

            }
        });

//        this.persistenceFacade.addProfile(new IPersistenceFacade.DataListener<Profile>() {
//            @Override
//            public void onDataReceived(@NonNull Profile p) {
//                MainActivity.this.p = p;
//                Fragment curFrag = mainView.getCurrentFragment();
//                if(curFrag instanceof ICreateProfileView)
//                    ((ICreateProfileView) curFrag).onProfileUpdated(feed);
//            }
//
//            @Override
//            public void onNoDataFound() {
//
//            }
//        });

        this.mainView = new MainView(this);
        setContentView(this.mainView.getRootView());

        if(savedInstanceState == null || !savedInstanceState.getBoolean("IN_PROGRESS"))
        this.mainView.displayFragment(HomeScreenFragment.class, null, false);
    }

    @Override
    public void onAddedCaption(String caption, ICreatePostView createPostView, Post post) {
        post.addCaption(caption);
        createPostView.updateCaption(caption);
    }

    @Override
    public void onAddedWorkout(int length, int difficulty, String descr, int workoutType, boolean[] WorkoutAttributes, Post post, Workout workout, String sport) {
       if (workoutType == 1)
            workout = new Cardio(WorkoutAttributes);
      else if (workoutType == 2)
            workout = new Strength(WorkoutAttributes);
      else
          workout = new Mobility(WorkoutAttributes);
        workout.setDescription(descr);
        workout.setLength(length);
        workout.setType(workoutType);
        workout.setDifficulty(difficulty);
        workout.setSport(sport);
        post.setWorkout(workout);
        this.mainView.displayFragment(new Create_Post_Fragment(this, workout, post), true);
    }

    @Override
    public void onWorkoutButton(Workout workout, Post post) {

        Bundle fragArgs = AddWorkoutFragment.makeArgsBundle(workout, post);
        this.mainView.displayFragment(AddWorkoutFragment.class, fragArgs, false);
    }

    @Override
    public void onPostButton(Post post) {
        this.feed.feed.add(post);
        this.curUser.posts.addPosts(post);
        this.curUser.setNumPosts();
        this.persistenceFacade.savePost(post);
        this.mainView.displayFragment(new FeedFragment(this, this.feed), true);
    }

    @Override
    public void onCancelButton() {
        this.mainView.displayFragment(new FeedFragment(this, feed), false);
    }

    @Override
    public void onEditedUsername(String username, IEditProfileView editProfileView) {
        curUser.setUsername(username);
    }

    @Override
    public void onEditedPassword(String password, IEditProfileView editProfileView) {
        curUser.setPassword(password);
    }

    @Override
    public void onEditedBio(String bio, IEditProfileView editProfileView) {
        curUser.setBio(bio);
    }

    @Override
    public void onCreateButton(String username, String password, String bio, ICreateProfileView createProfileView) {
        Profile p = new Profile();
        p.setUsername(username);
        p.setPassword(password);
        p.setBio(bio);
        this.persistenceFacade.addProfile(p, new IPersistenceFacade.BinaryResultListener() {
            @Override
            public void onYesResult() {
                MainActivity.this.curUser = p;
                createProfileView.onCreateSuccess();
                MainActivity.this.mainView.displayFragment(new FeedFragment(MainActivity.this, feed), false);
            }

            @Override
            public void onNoResult() {
                createProfileView.onUserAlreadyExists();
            }
        });
    }

    @Override
    public void onAddPost() {
        Post post = new Post(this.curUser);
        Workout workout = new Workout();
        this.mainView.displayFragment(new Create_Post_Fragment(this, workout, post), true);
    }

    @Override
    public void CardioButton(Workout workout, Post post) {
        this.mainView.displayFragment(new CardioFragment(this, post, workout), false);
    }

    @Override
    public void StrengthButton(Workout workout, Post post) {
        this.mainView.displayFragment(new StrengthFragment(this, post, workout), false);
    }

    @Override
    public void MobilityButton(Workout workout, Post post) {
        this.mainView.displayFragment(new MobilityFragment(this, post, workout), false);
    }

    @Override
    public void onAddedAttributes(boolean[] Attributes, int workoutType, Post post) {

        Bundle fragArgs = AddWorkoutFragment.makeArgsBundle2(Attributes, workoutType, post);
        AddWorkoutFragment addWorkoutFragment = new AddWorkoutFragment(this);
        this.mainView.displayFragment(addWorkoutFragment.getClass(), fragArgs, false);
    }

    @Override
    public void onFilter() {
        this.mainView.displayFragment(FilterFragment.class, null, false);
        //this.mainView.displayFragment(new FilterFragment(this), false);
    }

    @Override
    public void onSetFilter(int length, int difficulty, int workoutType, String sport) {
        filteredFeed.feed = new ArrayList(feed.feed);
        Filter len = new Length(length, filteredFeed);
        filteredFeed.feed = len.filter();
        Filter diff = new Difficulty(difficulty, filteredFeed);
        filteredFeed.feed = diff.filter();
        Filter type = new Type(workoutType, filteredFeed);
        filteredFeed.feed = type.filter();
        Filter sprt = new Sport(sport, filteredFeed);
        filteredFeed.feed = sprt.filter();
        this.mainView.displayFragment(new FeedFragment(this, filteredFeed), false);
    }

    @Override
    public void removeFilters() {
        this.mainView.displayFragment(new FeedFragment(this, feed), false);
    }

    @Override
    public void onSignUp(){
        this.mainView.displayFragment(CreateProfileFragment.class, null, false);
        //this.mainView.displayFragment(new CreateProfileFragment(this), false);
    }

    @Override
    public void onLogIn(String username, String password, IHomeScreenView homeScreenView) {
        //p.setUsername(username);

        persistenceFacade.retrieveProfile(username, new IPersistenceFacade.DataListener<Profile>() {
            @Override
            public void onDataReceived(@NonNull Profile data) {
                if (data.validatePassword(password)) {
                    MainActivity.this.curUser = data;
                    MainActivity.this.mainView.displayFragment(new FeedFragment(MainActivity.this, feed), false);
                } else {
                    homeScreenView.onInvalidCredentials();
                }
            }

            @Override
            public void onNoDataFound() {
                homeScreenView.onInvalidCredentials();
            }
        });
    }

    @Override
    public void viewProfile() {
        this.mainView.displayFragment(new ViewProfileFragment(this, this.curUser), false);
    }

    @Override
    public void onProfileClick(String prod_ID) {

        this.mainView.displayFragment(new ViewOtherProfileFragment(this), false);
    }

    @Override
    public void onEditProfile() {
        this.mainView.displayFragment(new EditProfileFragment(this), false);
    }

    @Override
    public void onGoBack() {
        this.mainView.displayFragment(new FeedFragment(this, feed), false);
    }

    @Override
    public void onFollowRequests() {

    }

    @Override
    public void onDoneButton(){
        this.mainView.displayFragment(new FeedFragment(this, feed), false);
    }

    @Override
    public void goBack(){
        this.mainView.displayFragment(new FeedFragment(this, feed), false);
    }

    @Override
    public void requestFollow(){

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putBoolean("IN_PROGRESS", true);
        outState.putSerializable("FEED", this.feed);
        outState.putSerializable("CUR_USER", curUser);
    }

    @Override
    public void onBack() {
        this.mainView.displayFragment(new ViewProfileFragment(this, this.curUser), false);
    }

    @Override
    public void onAccept(Profile profile) {
        this.curUser.setNumFollowers();
        profile.setNumFollowing();
        this.curUser.getFollowRequests().remove(profile.getUsername(), profile);
    }

    @Override
    public void onDecline(Profile profile) {
        this.curUser.getFollowRequests().remove(profile.getUsername(), profile);
    }
}

