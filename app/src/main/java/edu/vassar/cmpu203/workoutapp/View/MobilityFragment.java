package edu.vassar.cmpu203.workoutapp.View;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.vassar.cmpu203.workoutapp.Model.Post;
import edu.vassar.cmpu203.workoutapp.Model.Workout;
import edu.vassar.cmpu203.workoutapp.R;
import edu.vassar.cmpu203.workoutapp.databinding.FragmentCardioBinding;
import edu.vassar.cmpu203.workoutapp.databinding.FragmentMobilityBinding;

/**
 * Class that creates helps create a Mobility Workout
 */
public class MobilityFragment extends Fragment implements IWorkoutType {

    private FragmentMobilityBinding binding;
    private IWorkoutType.Listener listener;
    private boolean[] AttributeList  = new boolean[3];
    private Post post;
    private Workout workout;

    public MobilityFragment(IWorkoutType.Listener listener, Post post, Workout workout) {
        this.listener = listener;
        this.post = post;
        this.workout = workout;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        this.binding = FragmentMobilityBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {

        this.binding.MobilitySetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // retrieve item's name
                AttributeList[0] = MobilityFragment.this.binding.StaticOption.isChecked();
                AttributeList[1] = MobilityFragment.this.binding.DynamicOption.isChecked();
                AttributeList[2] = MobilityFragment.this.binding.YogaOption.isChecked();


                // let view listener know that it should add a new workout
                MobilityFragment.this.listener.onAddedAttributes(AttributeList, 3, post);
            }
        });
    }
}