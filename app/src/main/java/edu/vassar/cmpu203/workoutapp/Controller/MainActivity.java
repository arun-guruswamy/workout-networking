package edu.vassar.cmpu203.workoutapp.Controller;

import edu.vassar.cmpu203.workoutapp.Model.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import edu.vassar.cmpu203.workoutapp.R;
import edu.vassar.cmpu203.workoutapp.View.Create_Post_Fragment;
import edu.vassar.cmpu203.workoutapp.View.ICreatePostView;
import edu.vassar.cmpu203.workoutapp.View.IMainView;
import edu.vassar.cmpu203.workoutapp.View.MainView;

public class MainActivity extends AppCompatActivity implements ICreatePostView.Listener {

    private Post post;
    private IMainView mainView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.mainView = new MainView(this);

        setContentView(this.mainView.getRootView());
        this.mainView.displayFragment(new Create_Post_Fragment(), true);
    }

    @Override
    public void onAddedCaption(String caption) {
        post.addCaption(caption);
    }

//    @Override
//    public void onAddedWorkout(int length, int difficulty) {
//
//    }
}