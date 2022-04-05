package edu.vassar.cmpu203.workoutapp.Controller;

import edu.vassar.cmpu203.workoutapp.Model.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import edu.vassar.cmpu203.workoutapp.View.AddWorkoutFragment;
import edu.vassar.cmpu203.workoutapp.View.CreateProfileFragment;
import edu.vassar.cmpu203.workoutapp.View.Create_Post_Fragment;
import edu.vassar.cmpu203.workoutapp.View.CardioFragment;
import edu.vassar.cmpu203.workoutapp.View.StrengthFragment;
import edu.vassar.cmpu203.workoutapp.View.FeedFragment;
import edu.vassar.cmpu203.workoutapp.View.IAddWorkout;
import edu.vassar.cmpu203.workoutapp.View.ICreatePostView;
import edu.vassar.cmpu203.workoutapp.View.ICreateProfileView;
import edu.vassar.cmpu203.workoutapp.View.IFeedView;
import edu.vassar.cmpu203.workoutapp.View.IMainView;
import edu.vassar.cmpu203.workoutapp.View.IWorkoutType;
import edu.vassar.cmpu203.workoutapp.View.MainView;

public class MainActivity extends AppCompatActivity implements ICreatePostView.Listener, IAddWorkout.Listener, ICreateProfileView.Listener, IFeedView.Listener, IWorkoutType.Listener {

    private Profile p = new Profile();
    private IMainView mainView;
    private Feed feed;
    private ICreatePostView createPostView;


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
        workout.createWorkout(descr);
        //w.length = length;
        workout.setLength(length);
        //w.difficulty = difficulty;
        workout.setDifficulty(difficulty);
        this.mainView.displayFragment(new Create_Post_Fragment(this, workout, post), true);
    }

    @Override
    public void onWorkoutButton(Workout workout, Post post) {

        this.mainView.displayFragment(new AddWorkoutFragment(this, workout, post), true);
    }

    @Override
    public void onPostButton() {
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
}