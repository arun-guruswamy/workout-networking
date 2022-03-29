package edu.vassar.cmpu203.workoutapp.Controller;

import edu.vassar.cmpu203.workoutapp.Model.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import edu.vassar.cmpu203.workoutapp.R;
import edu.vassar.cmpu203.workoutapp.View.Create_Post_Fragment;
import edu.vassar.cmpu203.workoutapp.View.IMainView;
import edu.vassar.cmpu203.workoutapp.View.MainView;

public class MainActivity extends AppCompatActivity {

    private Post post;
    private IMainView mainView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.mainView = new MainView(this);

        setContentView(this.mainView.getRootView());
        this.mainView.displayFragment(new Create_Post_Fragment(), true);
    }
}