package edu.vassar.cmpu203.workoutapp.View;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.Snackbar;

import edu.vassar.cmpu203.workoutapp.Controller.MainActivity;
import edu.vassar.cmpu203.workoutapp.Model.Post;
import edu.vassar.cmpu203.workoutapp.Model.Workout;
import edu.vassar.cmpu203.workoutapp.R;
import edu.vassar.cmpu203.workoutapp.databinding.FragmentStrengthBinding;


public class StrengthFragment extends Fragment implements IWorkoutType {

    private FragmentStrengthBinding binding;
    private IWorkoutType.Listener listener;
    private boolean[] AttributeList  = new boolean[4];
    private Post post;
    private Workout workout;

    public StrengthFragment(Listener listener, Post post, Workout workout) {
        this.listener = listener;
        this.post = post;
        this.workout = workout;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        this.binding = FragmentStrengthBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {

        this.binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // retrieve item's name
                AttributeList[0] = StrengthFragment.this.binding.radioButton3.isChecked();
                AttributeList[1] = StrengthFragment.this.binding.radioButton4.isChecked();
                AttributeList[2] = StrengthFragment.this.binding.radioButton5.isChecked();
                AttributeList[3] = StrengthFragment.this.binding.radioButton.isChecked();


                // let view listener know that it should add a new workout
                StrengthFragment.this.listener.onAddedAttributes(AttributeList, 2, post);
            }
        });
    }

}