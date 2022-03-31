package edu.vassar.cmpu203.workoutapp.View;

import android.view.View;

import edu.vassar.cmpu203.workoutapp.databinding.ActivityMainBinding;
import edu.vassar.cmpu203.workoutapp.Model.Workout;


public interface IAddWorkout {

    interface Listener{
        void onAddedWorkout(Workout w, IAddWorkout AddWorkout);
    }

    void updatePost(Workout w);

}
