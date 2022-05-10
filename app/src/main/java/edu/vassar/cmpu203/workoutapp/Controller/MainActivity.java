package edu.vassar.cmpu203.workoutapp.Controller;

import edu.vassar.cmpu203.workoutapp.Model.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.google.firebase.firestore.DocumentReference;

import edu.vassar.cmpu203.workoutapp.Persistence.FirestoreFacade;
import edu.vassar.cmpu203.workoutapp.Persistence.IPersistenceFacade;
import edu.vassar.cmpu203.workoutapp.View.*;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ICreatePostView.Listener, IAddWorkout.Listener, ICreateProfileView.Listener, IFeedView.Listener, IWorkoutType.Listener, IFilterView.Listener, IHomeScreenView.Listener, IViewProfileView.Listener, IEditProfileView.Listener, IViewOtherProfileView.Listener, IFollowRequestView.Listener {

    private IMainView mainView;
    private Feed curFeed;
    private Feed unFeed = new Feed();
    private Feed filteredFeed = new Feed();
    private Profile curUser;
    private Post curPost;
    private Workout curWorkout;
    // another profile to help view other profiles
    private Profile user2;

    private IPersistenceFacade persistenceFacade = new FirestoreFacade();



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getSupportFragmentManager().setFragmentFactory(new WorkoutAppFragFactory(this));

        super.onCreate(savedInstanceState);

        if(savedInstanceState == null) {
            this.curFeed = new Feed();
        }
        else {
            this.curFeed = (Feed) savedInstanceState.getSerializable("FEED");
            this.curUser = (Profile) savedInstanceState.getSerializable("CUR_USER");
        }

        this.persistenceFacade.retrieveFeed(new IPersistenceFacade.DataListener<Feed>() {
            @Override
            public void onDataReceived(@NonNull Feed feed) {
                MainActivity.this.unFeed = feed;
                MainActivity.this.curFeed = unFeed;
                Fragment curFrag = MainActivity.this.mainView.getCurrentFragment();
                if(curFrag instanceof IFeedView)
                    ((IFeedView) curFrag).onFeedUpdated(curFeed);
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
    public void onAddedCaption(String caption, ICreatePostView createPostView) {
        this.curPost.addCaption(caption);
        createPostView.updateCaption(caption);
    }

    @Override
    public void onAddedWorkout(int length, int difficulty, String descr, String sport) {
   /*    if (workoutType == 1)
            this.curWorkout = new Cardio(WorkoutAttributes);
      else if (workoutType == 2)
            this.curWorkout = new Strength(WorkoutAttributes);
      else
          this.curWorkout = new Mobility(WorkoutAttributes);*/

        this.curWorkout.setDescription(descr);
        this.curWorkout.setLength(length);
       // this.curWorkout.setType(workoutType);
        this.curWorkout.setDifficulty(difficulty);
        this.curWorkout.setSport(sport);
        this.curPost.setWorkout(this.curWorkout);
        this.mainView.displayFragment(Create_Post_Fragment.class, null, false);
    }

    @Override
    public void onWorkoutButton() {

        this.mainView.displayFragment(AddWorkoutFragment.class, null, false);
    }

    @Override
    public void onPostButton() {
        this.unFeed.feed.add(this.curPost);
        this.curUser.posts.addPosts(this.curPost);
        this.curUser.setNumPosts();
        String id = this.persistenceFacade.savePost(this.curPost);
        updatePostId(id);
        this.persistenceFacade.saveProfile(this.curUser);
        this.mainView.displayFragment(FeedFragment.class, null, false);
    }

    private void updatePostId(String id){
        this.curPost.setId(id);
        this.persistenceFacade.editPost(this.curPost, id);
    }

    @Override
    public void onCancelButton() {
        this.mainView.displayFragment(FeedFragment.class, null, false);
    }

    @Override
    public void onEditedPassword(String password, IEditProfileView editProfileView) {
        curUser.setPasswordFromString(password);
        this.persistenceFacade.saveProfile(this.curUser);
    }

    @Override
    public void onEditedBio(String bio, IEditProfileView editProfileView) {

        curUser.setBio(bio);
        this.persistenceFacade.saveProfile(this.curUser);
    }

    @Override
    public void onCreateButton(String username, String password, String bio, ICreateProfileView createProfileView) {
        Profile p = new Profile();
        p.setUsername(username);
        p.setPasswordFromString(password);
        p.setBio(bio);
        this.persistenceFacade.addProfile(p, new IPersistenceFacade.BinaryResultListener() {
            @Override
            public void onYesResult() {
                MainActivity.this.curUser = p;
                createProfileView.onCreateSuccess();
                MainActivity.this.mainView.displayFragment(FeedFragment.class, null, false);
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
        curPost = post;
        curWorkout = workout;
        this.mainView.displayFragment(Create_Post_Fragment.class, null, false);
    }

    @Override
    public void CardioButton(int length, int difficulty, String descr, String sport) {
        this.curWorkout.setDescription(descr);
        this.curWorkout.setLength(length);
        // this.curWorkout.setType(workoutType);
        this.curWorkout.setDifficulty(difficulty);
        this.curWorkout.setSport(sport);
        this.mainView.displayFragment(CardioFragment.class, null, false);
    }

    @Override
    public void StrengthButton(int length, int difficulty, String descr, String sport) {
        this.curWorkout.setDescription(descr);
        this.curWorkout.setLength(length);
        // this.curWorkout.setType(workoutType);
        this.curWorkout.setDifficulty(difficulty);
        this.curWorkout.setSport(sport);
        this.mainView.displayFragment(StrengthFragment.class, null, false);
    }

    @Override
    public void MobilityButton(int length, int difficulty, String descr, String sport) {
        this.curWorkout.setDescription(descr);
        this.curWorkout.setLength(length);
        // this.curWorkout.setType(workoutType);
        this.curWorkout.setDifficulty(difficulty);
        this.curWorkout.setSport(sport);
        this.mainView.displayFragment(MobilityFragment.class, null, false);
    }

    @Override
    public void onAddedAttributes(boolean[] Attributes, int workoutType) {
        Cardio c;
        Strength s;
        Mobility m;
        if (workoutType == 1) {
            c = new Cardio(Attributes);
            c.setLength(curWorkout.getLength());
            c.setDifficulty(curWorkout.getDifficulty());
            c.setDescription(curWorkout.getDescription());
            c.setSport(curWorkout.getSportFocus());
            this.curWorkout = c;
        }
        else if (workoutType == 2) {
            s = new Strength(Attributes);
            s.setLength(curWorkout.getLength());
            s.setDifficulty(curWorkout.getDifficulty());
            s.setDescription(curWorkout.getDescription());
            s.setSport(curWorkout.getSportFocus());
            this.curWorkout = s;
        }

        else {
            m = new Mobility(Attributes);
            m.setLength(curWorkout.getLength());
            m.setDifficulty(curWorkout.getDifficulty());
            m.setDescription(curWorkout.getDescription());
            m.setSport(curWorkout.getSportFocus());
            this.curWorkout = m;
        }

        this.curWorkout.setType(workoutType);

        this.mainView.displayFragment(AddWorkoutFragment.class, null, false);
    }

    @Override
    public void onFilter() {
        this.mainView.displayFragment(FilterFragment.class, null, false);
        //this.mainView.displayFragment(new FilterFragment(this), false);
    }

    @Override
    public void onSetFilter(int length, int difficulty, int workoutType, String sport) {
        filteredFeed.feed = new ArrayList(this.curFeed.feed);
        Filter len = new Length(length, filteredFeed);
        filteredFeed.feed = len.filter();
        Filter diff = new Difficulty(difficulty, filteredFeed);
        filteredFeed.feed = diff.filter();
        Filter type = new Type(workoutType, filteredFeed);
        filteredFeed.feed = type.filter();
        Filter sprt = new Sport(sport, filteredFeed);
        filteredFeed.feed = sprt.filter();

        this.curFeed = filteredFeed;

        this.mainView.displayFragment(FeedFragment.class, null, false);
    }

    @Override
    public void removeFilters() {
        this.curFeed = unFeed;
        this.mainView.displayFragment(FeedFragment.class, null, false);
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
                    homeScreenView.successfulLogIn();
                    MainActivity.this.mainView.displayFragment(FeedFragment.class, null, false );
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
        this.mainView.displayFragment(ViewProfileFragment.class, null, false);
    }

    @Override
    public void onProfileClick(String prod_ID) {
        persistenceFacade.retrieveProfile(prod_ID, new IPersistenceFacade.DataListener<Profile>() {
            @Override
            public void onDataReceived(@NonNull Profile data) {
                MainActivity.this.user2 = data;

                if(user2.getUsername().equals(MainActivity.this.curUser.getUsername()))
                    MainActivity.this.mainView.displayFragment(ViewProfileFragment.class, null, false);
                else
                    MainActivity.this.mainView.displayFragment(ViewOtherProfileFragment.class, null, false);
            }

            @Override
            public void onNoDataFound() {

            }
        });

    }

    @Override
    public void onEditProfile() {
        this.mainView.displayFragment(EditProfileFragment.class, null, false);
    }

    @Override
    public void onGoBack() {
        this.mainView.displayFragment(FeedFragment.class, null, false);
    }

    @Override
    public void onFollowRequests() {
            this.mainView.displayFragment(FollowRequestFragment.class, null, false);
    }

    @Override
    public void onDoneButton(){
        this.mainView.displayFragment(FeedFragment.class, null, false);
    }

    @Override
    public void goBack(){
        this.mainView.displayFragment(FeedFragment.class, null, false);
    }

    @Override
    public void requestFollow(Profile profile, IViewOtherProfileView iViewOtherProfileView){
        // what if I already requested to follow this person
        if(profile.getFollowRequests().containsKey(this.curUser.getUsername()))
            iViewOtherProfileView.onAlreadyRequested();
        // what if I already follow this person
        else if(profile.getFollowers().containsKey(this.curUser.getUsername()))
            iViewOtherProfileView.onAlreadyFollowed();

        iViewOtherProfileView.onRequest();
        profile.getFollowRequests().put(this.curUser.getUsername(), curUser);
        this.persistenceFacade.saveProfile(profile);

    }

    @Override
    public Profile getUser2() {
        return this.user2;
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putBoolean("IN_PROGRESS", true);
        outState.putSerializable("FEED", this.curFeed);
        outState.putSerializable("CUR_USER", curUser);
    }

    @Override
    public void onBack() {
        this.mainView.displayFragment(ViewProfileFragment.class, null, false);
    }

    @Override
    public void onAccept(Profile profile) {
        this.curUser.setNumFollowers();
        profile.setNumFollowing();
        this.persistenceFacade.saveProfile(profile);
        this.curUser.getFollowRequests().remove(profile.getUsername(), profile);
        this.persistenceFacade.saveProfile(this.curUser);
    }

    @Override
    public void onAddedFollower(Profile profile){
        this.curUser.getFollowers().put(profile.getUsername(), profile);
        this.persistenceFacade.saveProfile(this.curUser);
    }

    @Override
    public void onDecline(Profile profile) {
        this.curUser.getFollowRequests().remove(profile.getUsername(), profile);
        this.persistenceFacade.saveProfile(this.curUser);
    }

    @Override
    public Feed getCurFeed() {
        return curFeed;
    }


    @Override
    public Profile getCurUser() {
        return curUser;
    }

    @Override
    public Workout getCurWorkout() {
        return curWorkout;
    }

    @Override
    public void logout(IViewProfileView viewProfileView) {
        curUser = null;
        this.mainView.displayFragment(HomeScreenFragment.class, null, false);
    }
}

