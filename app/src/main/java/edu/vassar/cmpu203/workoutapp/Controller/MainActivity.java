package edu.vassar.cmpu203.workoutapp.Controller;

import edu.vassar.cmpu203.workoutapp.Model.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import edu.vassar.cmpu203.workoutapp.View.AddWorkoutFragment;
import edu.vassar.cmpu203.workoutapp.View.CreateProfileFragment;
import edu.vassar.cmpu203.workoutapp.View.Create_Post_Fragment;
import edu.vassar.cmpu203.workoutapp.View.FeedFragment;
import edu.vassar.cmpu203.workoutapp.View.IAddWorkout;
import edu.vassar.cmpu203.workoutapp.View.ICreatePostView;
import edu.vassar.cmpu203.workoutapp.View.ICreateProfileView;
import edu.vassar.cmpu203.workoutapp.View.IFeedView;
import edu.vassar.cmpu203.workoutapp.View.IMainView;
import edu.vassar.cmpu203.workoutapp.View.MainView;

public class MainActivity extends AppCompatActivity implements ICreatePostView.Listener, IAddWorkout.Listener, ICreateProfileView.Listener, IFeedView.Listener {

    private Profile p = new Profile();
    private Post post = new Post(p);
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
    public void onAddedCaption(String caption, ICreatePostView createPostView) {
        post.addCaption(caption);
        createPostView.updateCaption(caption);
    }

    @Override
    public void onAddedWorkout(int length, int difficulty, String descr) {
        Workout w = new Cardio();
        w.workout = descr;
        w.length = length;
        w.difficulty = difficulty;
        this.mainView.displayFragment(new Create_Post_Fragment(this, w), true);
    }

    @Override
    public void onWorkoutButton() {
        this.mainView.displayFragment(new AddWorkoutFragment(this), true);
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
        Workout w = new Cardio();
        this.mainView.displayFragment(new Create_Post_Fragment(this, w), true);
    }
}