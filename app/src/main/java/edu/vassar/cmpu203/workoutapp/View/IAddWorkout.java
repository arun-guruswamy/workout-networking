package edu.vassar.cmpu203.workoutapp.View;

import android.view.View;

import edu.vassar.cmpu203.workoutapp.databinding.ActivityMainBinding;
import edu.vassar.cmpu203.workoutapp.Model.Workout;


public interface IAddWorkout {

    interface Listener{
        void onAddedWorkout(int length, int difficulty, String description, int workoutType, boolean[] WorkoutAttributes);
        void CardioButton();
        void StrengthButton();
    }

}
