package edu.vassar.cmpu203.workoutapp.View;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.Snackbar;

import edu.vassar.cmpu203.workoutapp.Model.*;
import edu.vassar.cmpu203.workoutapp.databinding.FragmentCreatePostBinding;
import edu.vassar.cmpu203.workoutapp.databinding.FragmentAddWorkoutBinding;


import edu.vassar.cmpu203.workoutapp.R;

public class AddWorkoutFragment extends Fragment implements IAddWorkout {

    private FragmentAddWorkoutBinding binding;
    private IAddWorkout.Listener listener;
    private boolean[] WorkoutAttributes;
    private int workoutType = 0;


    public AddWorkoutFragment(Listener listener) {
        this.listener = listener;
    }

    public AddWorkoutFragment(Listener listener, boolean[] WorkoutAttributes, int workoutType) {
        this.WorkoutAttributes = WorkoutAttributes;
        this.workoutType = workoutType;
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
        this.binding.button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // retrieve item's name
                Editable workoutLengthEditable = AddWorkoutFragment.this.binding.editTextTextPersonName.getText();
                String workoutLengthStr = workoutLengthEditable.toString();

                Editable workoutDescEditable = AddWorkoutFragment.this.binding.editTextTextPersonName4.getText();
                String workoutDescStr = workoutDescEditable.toString();

                // retrieve item's quantity
                int workoutDifficulty = binding.seekBar2.getProgress();

                // confirm we have both name and qty
                if (workoutLengthStr.length() == 0 || workoutDifficulty == 0 || workoutDescStr.length() == 0){
                    Snackbar.make(v, "Both length and difficulty are mandatory!", Snackbar.LENGTH_LONG).show();
                    return;
                }

                int workoutLength = Integer.parseInt(workoutLengthStr);

                workoutLengthEditable.clear();
                workoutDescEditable.clear();




                // let view listener know that it should add a new workout
                if(workoutType == 1)
                    AddWorkoutFragment.this.listener.onAddedWorkout(workoutLength, workoutDifficulty, workoutDescStr, workoutType, WorkoutAttributes);
                else if(workoutType == 2)
                    AddWorkoutFragment.this.listener.onAddedWorkout(workoutLength, workoutDifficulty, workoutDescStr, workoutType, WorkoutAttributes);
                else
                    Snackbar.make(v, "Choosing a workout type is mandatory!", Snackbar.LENGTH_LONG).show();

            }
        });

        this.binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddWorkoutFragment.this.listener.CardioButton();

            }
        });

        this.binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddWorkoutFragment.this.listener.StrengthButton();

            }
        });
    }

}