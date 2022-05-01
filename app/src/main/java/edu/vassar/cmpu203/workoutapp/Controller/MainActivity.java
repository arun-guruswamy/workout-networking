package edu.vassar.cmpu203.workoutapp.Controller;

import edu.vassar.cmpu203.workoutapp.Model.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import edu.vassar.cmpu203.workoutapp.View.*;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ICreatePostView.Listener, IAddWorkout.Listener, ICreateProfileView.Listener, IFeedView.Listener, IWorkoutType.Listener, IFilterView.Listener, IHomeScreenView.Listener, IViewProfileView.Listener, IEditProfileView.Listener {

    private Profile p;
    private IMainView mainView;
    private Feed feed;
    private Feed filteredFeed = new Feed();



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getSupportFragmentManager().setFragmentFactory(new WorkoutAppFragFactory(this));

        super.onCreate(savedInstanceState);

        if(savedInstanceState == null) {
            this.feed = new Feed();
        }
        else {
            this.feed = (Feed) savedInstanceState.getSerializable("FEED");
            this.p = (Profile) savedInstanceState.getSerializable("CUR_USER");
        }

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
        this.mainView.displayFragment(new FeedFragment(this, feed), true);
    }

    @Override
    public void onCancelButton() {
        this.mainView.displayFragment(new FeedFragment(this, feed), false);
    }

    @Override
    public void onEditedUsername(String username, IEditProfileView editProfileView) {
        p.setUsername(username);
    }

    @Override
    public void onEditedPassword(String password, IEditProfileView editProfileView) {
        p.setPassword(password);
    }

    @Override
    public void onEditedBio(String bio, IEditProfileView editProfileView) {
        p.setBio(bio);
    }

    @Override
    public void onCreateButton(String username, String password, String bio) {
        p = new Profile();
        p.setPassword(username);
        p.setPassword(password);
        p.setBio(bio);
        this.mainView.displayFragment(new FeedFragment(this, feed), false);
    }

    @Override
    public void onAddPost() {
        Post post = new Post(this.p);
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
        //addWorkoutFragment.onWorkoutSelected();
    }

    @Override
    public void onFilter() {
        this.mainView.displayFragment(new FilterFragment(this), false);
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
        this.mainView.displayFragment(new CreateProfileFragment(this), false);
    }

    @Override
    public void onLogIn(String username) {
        p.setUsername(username);
        this.mainView.displayFragment(new FeedFragment(this, feed), false);
    }

    @Override
    public void viewProfile() {
        this.mainView.displayFragment(new ViewProfileFragment(this), false);
    }

    @Override
    public void onProfileClick(String prod_ID) {
        //find prod_ID in the database
        //this.mainView.displayFragment(new ViewProfileFragment(this));
    }

    @Override
    public void onEditProfile() {
        this.mainView.displayFragment(new EditProfileFragment(this), false);
    }

    @Override
    public void onDoneButton(){
        this.mainView.displayFragment(new FeedFragment(this, feed), false);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putBoolean("IN_PROGRESS", true);
        outState.putSerializable("FEED", this.feed);
        outState.putSerializable("CUR_USER", p);
    }
}

