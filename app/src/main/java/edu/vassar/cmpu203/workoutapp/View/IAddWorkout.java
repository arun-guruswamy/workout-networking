package edu.vassar.cmpu203.workoutapp.View;

import android.view.View;

import edu.vassar.cmpu203.workoutapp.Model.Post;
import edu.vassar.cmpu203.workoutapp.databinding.ActivityMainBinding;
import edu.vassar.cmpu203.workoutapp.Model.Workout;


public interface IAddWorkout {

    interface Listener{
        void onAddedWorkout(int length, int difficulty, String description, String sport);
        void CardioButton();
        void StrengthButton();
        void MobilityButton();
        Workout getCurWorkout();
    }

    void onWorkoutSelected();
}
