package edu.vassar.cmpu203.workoutapp.View;

import android.content.Context;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

import edu.vassar.cmpu203.workoutapp.databinding.FragmentAddWorkoutBinding;
import edu.vassar.cmpu203.workoutapp.databinding.FragmentCreatePostBinding;
import edu.vassar.cmpu203.workoutapp.Model.Workout;

public class AddWorkoutView implements IAddWorkout{
    private FragmentAddWorkoutBinding binding;
    private Listener listener;

    public AddWorkoutView(Context context, Listener listener){
        this.binding = FragmentAddWorkoutBinding.inflate(LayoutInflater.from(context));
        this.listener = listener;

        // add listener to be called when a button is pressed
        this.binding.button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // retrieve item's name
                Editable workoutLengthEditable = AddWorkoutView.this.binding.editTextTextPersonName.getText();
                String workoutLengthStr = workoutLengthEditable.toString();

                Editable workoutDescEditable = AddWorkoutView.this.binding.editTextTextPersonName4.getText();
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

                // let view listener know that it should add a new item
                AddWorkoutView.this.listener.onAddedWorkout(workoutLength, workoutDifficulty, workoutDescStr);
            }
        });
    }

    public void updatePost(Workout w){
        //this.binding.postWorkout.setText(w.toString()); // update the line items display
    }

    @Override
    public View getRootView() {
        return binding.getRoot();
    }


}
