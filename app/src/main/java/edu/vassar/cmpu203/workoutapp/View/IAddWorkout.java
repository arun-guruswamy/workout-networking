package edu.vassar.cmpu203.workoutapp.View;

import android.view.View;

import edu.vassar.cmpu203.workoutapp.Model.Post;
import edu.vassar.cmpu203.workoutapp.databinding.ActivityMainBinding;
import edu.vassar.cmpu203.workoutapp.Model.Workout;


public interface IAddWorkout {

    interface Listener{
        void onAddedWorkout(int length, int difficulty, String description, int workoutType, boolean[] WorkoutAttributes, Post post, Workout workout, String sport);
        void CardioButton(Workout workout, Post post);
        void StrengthButton(Workout workout, Post post);
        void MobilityButton(Workout workout, Post post);
    }

}
