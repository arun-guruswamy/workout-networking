package edu.vassar.cmpu203.workoutapp.View;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import com.google.android.material.snackbar.Snackbar;

import edu.vassar.cmpu203.workoutapp.Model.*;
import edu.vassar.cmpu203.workoutapp.databinding.FragmentCreatePostBinding;
import edu.vassar.cmpu203.workoutapp.databinding.FragmentAddWorkoutBinding;


import edu.vassar.cmpu203.workoutapp.R;

public class AddWorkoutFragment extends Fragment implements IAddWorkout {

    private FragmentAddWorkoutBinding binding;
    private Listener listener;
    private boolean[] WorkoutAttributes;
    private int workoutType = 0;
    int workoutLength = 0;
    private Workout workout;
    private Post post;

    public AddWorkoutFragment(Listener listener) {
        this.listener = listener;
    }

    public AddWorkoutFragment(Listener listener, Workout workout, Post post) {
        this.listener = listener;
        this.workout = workout;
        this.post = post;
    }

    public AddWorkoutFragment(Listener listener, boolean[] WorkoutAttributes, int workoutType, Post post) {
        this.listener = listener;
        this.WorkoutAttributes = WorkoutAttributes;
        this.workoutType = workoutType;
        this.post = post;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        this.binding = FragmentAddWorkoutBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){


        // onViewCreated is responsible for wiring up the event handlers

        // add listener to be called when the add button is pressed
        this.binding.AddWorkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Editable workoutLengthEditable = AddWorkoutFragment.this.binding.WorkoutLengthInput.getText();
                String workoutLengthStr = workoutLengthEditable.toString();

                Editable workoutDescEditable = AddWorkoutFragment.this.binding.WorkoutDescriptionInput.getText();
                String workoutDescStr = workoutDescEditable.toString();

                int workoutDifficulty = binding.WorkoutDifficultyInput.getProgress();

                String workoutSport = binding.spinner2.getSelectedItem().toString();


                // confirm we have both name and qty
                if (workoutLengthStr.length() == 0 || workoutDifficulty == 0 || workoutDescStr.length() == 0){
                    Snackbar.make(v, "Length, difficulty and description are mandatory!", Snackbar.LENGTH_LONG).show();
                    return;
                }

                try {
                    workoutLength = Integer.parseInt(workoutLengthStr);
                } catch (NumberFormatException e) {
                    Snackbar.make(v, "Please enter a number for length", Snackbar.LENGTH_LONG).show();
                    return;
                }

                workoutLengthEditable.clear();
                workoutDescEditable.clear();




                // let view listener know that it should add a new workout
                if(workoutType == 1 || workoutType == 2 || workoutType == 3)
                    AddWorkoutFragment.this.listener.onAddedWorkout(workoutLength, workoutDifficulty, workoutDescStr,workoutType, WorkoutAttributes, post, workout, workoutSport);
                else
                    Snackbar.make(v, "Choosing a workout type is mandatory!", Snackbar.LENGTH_LONG).show();

            }
        });

        this.binding.CardioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddWorkoutFragment.this.listener.CardioButton(workout, post);

            }
        });

        this.binding.StrengthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddWorkoutFragment.this.listener.StrengthButton(workout, post);

            }
        });

        this.binding.MobilityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddWorkoutFragment.this.listener.MobilityButton(workout, post);
            }
        });



//        this.binding.WorkoutDifficultyInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
//
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//
//            }
//        }

    }

}