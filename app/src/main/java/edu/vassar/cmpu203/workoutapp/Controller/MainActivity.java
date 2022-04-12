package edu.vassar.cmpu203.workoutapp.Controller;

import edu.vassar.cmpu203.workoutapp.Model.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import edu.vassar.cmpu203.workoutapp.View.*;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ICreatePostView.Listener, IAddWorkout.Listener, ICreateProfileView.Listener, IFeedView.Listener, IWorkoutType.Listener, IFilterView.Listener {

    private Profile p = new Profile();
    private IMainView mainView;
    private Feed feed;
    private ICreatePostView createPostView;
    private Feed filteredFeed = new Feed();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.mainView = new MainView(this);
        this.feed = new Feed();

        setContentView(this.mainView.getRootView());
        this.mainView.displayFragment(new CreateProfileFragment(this), false);
    }

    @Override
    public void onAddedCaption(String caption, ICreatePostView createPostView, Post post) {
        post.addCaption(caption);
        createPostView.updateCaption(caption);
    }

    @Override
    public void onAddedWorkout(int length, int difficulty, String descr, int workoutType, boolean[] WorkoutAttributes, Post post, Workout workout) {
       if (workoutType == 1) {
            workout = new Cardio(WorkoutAttributes);
        }
      else
            workout = new Strength(WorkoutAttributes);
        //w.workout = descr;
        workout.setDescription(descr);
        //w.length = length;
        workout.setLength(length);
        //w.difficulty = difficulty;
        workout.setDifficulty(difficulty);
        post.setWorkout(workout);
        this.mainView.displayFragment(new Create_Post_Fragment(this, workout, post), true);
    }

    @Override
    public void onWorkoutButton(Workout workout, Post post) {

        this.mainView.displayFragment(new AddWorkoutFragment(this, workout, post), true);
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
    public void onAddedUsername(String username, ICreateProfileView createProfileView) {
        p.setUsername(username);
    }

    @Override
    public void onAddedPassword(String password, ICreateProfileView createProfileView) {
        p.setPassword(password);
    }

    @Override
    public void onAddedBio(String bio, ICreateProfileView createProfileView) {
        p.setBio(bio);
    }

    @Override
    public void onCreateButton() {
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
    public void onAddedAttributes(boolean[] Attributes, int workoutType, Post post) {
        this.mainView.displayFragment(new AddWorkoutFragment(this, Attributes, workoutType, post), false);
    }

    @Override
    public void onFilter() {
        this.mainView.displayFragment(new FilterFragment(this), false);
    }

    @Override
    public void onSetFilter(int length, int difficulty) {
        filteredFeed.feed = new ArrayList(feed.feed);
        Filter len = new Length(length, filteredFeed);
        filteredFeed.feed = len.filter();
        Filter diff = new Difficulty(difficulty, filteredFeed);
        filteredFeed.feed = diff.filter();
        this.mainView.displayFragment(new FeedFragment(this, filteredFeed), false);
    }

    @Override
    public void removeFilters() {
        this.mainView.displayFragment(new FeedFragment(this, feed), false);
    }
}