package edu.vassar.cmpu203.workoutapp.View;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
    int signal = 0;


    private boolean workoutSet = false;
    private final static String WRK_SET = "WRK_SET";
    private final static  String WRK = "WRK";
    private final static String POST = "POST";
    private final static String ATRB = "ATRB";
    private final static String TYPE = "TYPE";
    private final static  String LENGTH = "LENGTH";
    private final static String DESC = "DESC";
    private final static String DIFF = "DIFF";

    public AddWorkoutFragment(Listener listener) {

        this.listener = listener;
        this.workout = listener.getCurWorkout();
    }

    public AddWorkoutFragment(Listener listener, Workout workout, Post post) {
        this.listener = listener;
        this.workout = workout;
        this.post = post;
        this.signal = 0;
    }

    public AddWorkoutFragment(Listener listener, boolean[] WorkoutAttributes, int workoutType, Post post) {
        this.listener = listener;
        this.WorkoutAttributes = WorkoutAttributes;
        this.workoutType = workoutType;
        this.post = post;
        this.signal = 0;
    }

    public AddWorkoutFragment(Listener listener, Workout w) {
        this.listener = listener;
        workout.length = w.getLength();
        workout.difficulty = w.getDifficulty();
        workout.description = w.getDescription();
        this.signal = 1;
        //this.binding.spinner2.set(w.length);
    }

    public static Bundle makeArgsBundle(Workout workout, Post post){
        Bundle args = new Bundle();
        args.putSerializable(WRK, workout);
        args.putSerializable(POST, post);
        return args;
    }

    public static Bundle makeArgsBundle2(boolean[] workoutAttributes, int workoutType, Post post){
        Bundle args = new Bundle();
        args.putSerializable(POST, post);
        args.putBooleanArray(ATRB, workoutAttributes);
        args.putInt(TYPE, workoutType);
        return args;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        Bundle args = this.getArguments();
        if(args != null){
            this.workout = (Workout) args.getSerializable("WRK");
            this.post = (Post) args.getSerializable("POST");
            this.WorkoutAttributes = args.getBooleanArray("ATRB");
            this.workoutType = args.getInt("TYPE");

        }
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

        onWorkoutSelected(workout.getWorkoutType());

        if (workout.getLength() != 0)
            this.binding.WorkoutLengthInput.setText(workout.getLength() + "");
        this.binding.WorkoutDifficultyInput.setProgress(workout.getDifficulty());
        this.binding.WorkoutDescriptionInput.setText(workout.getDescription());
        this.binding.spinner2.setSelection(getSportPos(workout.getSportFocus()));

        //this.binding.spinner2.set(w.length);
 /*          if(savedInstanceState != null) {
               String length = savedInstanceState.getString(LENGTH);
               this.binding.WorkoutLengthInput.setText(length);
               String description = savedInstanceState.getString(DESC);
               this.binding.WorkoutDescriptionInput.setText(description);
               int difficulty = savedInstanceState.getInt(DIFF);
               this.binding.WorkoutDifficultyInput.setProgress(difficulty);
           }*/


        // onViewCreated is responsible for wiring up the event handlers

        // add listener to be called when the add button is pressed

        this.workout = this.listener.getCurWorkout();

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
                if(workout.getWorkoutType() == 1 || workout.getWorkoutType() == 2 || workout.getWorkoutType() == 3) {
                    AddWorkoutFragment.this.listener.onAddedWorkout(workoutLength, workoutDifficulty, workoutDescStr, workoutSport);
                    workoutSet = true;
                }
                else
                    Snackbar.make(v, "Choosing a workout type is mandatory!", Snackbar.LENGTH_LONG).show();

            }
        });

        this.binding.CardioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Editable workoutLengthEditable = AddWorkoutFragment.this.binding.WorkoutLengthInput.getText();
                String workoutLengthStr = workoutLengthEditable.toString();

                Editable workoutDescEditable = AddWorkoutFragment.this.binding.WorkoutDescriptionInput.getText();
                String workoutDescStr = workoutDescEditable.toString();

                int workoutDifficulty = binding.WorkoutDifficultyInput.getProgress();

                String workoutSport = binding.spinner2.getSelectedItem().toString();

                workoutLength = Integer.parseInt(workoutLengthStr);

                workoutLengthEditable.clear();
                workoutDescEditable.clear();


                AddWorkoutFragment.this.listener.CardioButton(workoutLength, workoutDifficulty, workoutDescStr, workoutSport);

            }
        });

        this.binding.StrengthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Editable workoutLengthEditable = AddWorkoutFragment.this.binding.WorkoutLengthInput.getText();
                String workoutLengthStr = workoutLengthEditable.toString();

                Editable workoutDescEditable = AddWorkoutFragment.this.binding.WorkoutDescriptionInput.getText();
                String workoutDescStr = workoutDescEditable.toString();

                int workoutDifficulty = binding.WorkoutDifficultyInput.getProgress();

                String workoutSport = binding.spinner2.getSelectedItem().toString();

                workoutLength = Integer.parseInt(workoutLengthStr);

                workoutLengthEditable.clear();
                workoutDescEditable.clear();

                AddWorkoutFragment.this.listener.StrengthButton(workoutLength, workoutDifficulty, workoutDescStr, workoutSport);

            }
        });

        this.binding.MobilityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Editable workoutLengthEditable = AddWorkoutFragment.this.binding.WorkoutLengthInput.getText();
                String workoutLengthStr = workoutLengthEditable.toString();

                Editable workoutDescEditable = AddWorkoutFragment.this.binding.WorkoutDescriptionInput.getText();
                String workoutDescStr = workoutDescEditable.toString();

                int workoutDifficulty = binding.WorkoutDifficultyInput.getProgress();

                String workoutSport = binding.spinner2.getSelectedItem().toString();

                workoutLength = Integer.parseInt(workoutLengthStr);

                workoutLengthEditable.clear();
                workoutDescEditable.clear();


                AddWorkoutFragment.this.listener.MobilityButton(workoutLength, workoutDifficulty, workoutDescStr, workoutSport);
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

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(WRK_SET, this.workoutSet);

        Editable workoutLengthEditable = AddWorkoutFragment.this.binding.WorkoutLengthInput.getText();
        String workoutLengthStr = workoutLengthEditable.toString();
        outState.putString(LENGTH, workoutLengthStr);

        Editable workoutDescEditable = AddWorkoutFragment.this.binding.WorkoutDescriptionInput.getText();
        String workoutDescStr = workoutDescEditable.toString();
        outState.putString(DESC, workoutDescStr);

        int workoutDifficulty = binding.WorkoutDifficultyInput.getProgress();
        outState.putInt(DIFF, workoutDifficulty);


    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

        if (savedInstanceState != null){
            this.workoutSet = savedInstanceState.getBoolean(WRK_SET);

        }

        if(workoutSet) {
           onWorkoutSelected(workoutType);
        }

    }

    @Override
    public void onWorkoutSelected(int workoutType) {
        if (workoutType == 0) {
            this.binding.CardioButton.setBackgroundColor(Color.BLUE);
            this.binding.StrengthButton.setBackgroundColor(Color.BLUE);
            this.binding.MobilityButton.setBackgroundColor(Color.BLUE);
        }
        if (workoutType == 1) {
            this.binding.CardioButton.setBackgroundColor(Color.BLUE);
            this.binding.StrengthButton.setBackgroundColor(Color.GRAY);
            this.binding.MobilityButton.setBackgroundColor(Color.GRAY);
        }
        if (workoutType == 02) {
            this.binding.CardioButton.setBackgroundColor(Color.GRAY);
            this.binding.StrengthButton.setBackgroundColor(Color.BLUE);
            this.binding.MobilityButton.setBackgroundColor(Color.GRAY);
        }
        if (workoutType == 3) {
            this.binding.CardioButton.setBackgroundColor(Color.GRAY);
            this.binding.StrengthButton.setBackgroundColor(Color.GRAY);
            this.binding.MobilityButton.setBackgroundColor(Color.BLUE);
        }
    }

    public int getSportPos(String sport) {
        if (sport.equals("None"))
            return 0;
        else if (sport.equals("tennis"))
            return 1;
        else if (sport.equals("Lacrosse"))
            return 2;
        else if (sport.equals("Baseball"))
            return 3;
        else if (sport.equals("Soccer"))
            return 4;
        else if (sport.equals("Track and Field"))
            return 5;
        else if (sport.equals("Basketball"))
            return 6;
        else if (sport.equals("Rugby"))
            return 7;
        else if (sport.equals("Rowing"))
            return 8;
        else
            return 9;
    }

}