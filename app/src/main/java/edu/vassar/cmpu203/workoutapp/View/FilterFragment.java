package edu.vassar.cmpu203.workoutapp.View;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.Snackbar;

import edu.vassar.cmpu203.workoutapp.Model.Feed;
import edu.vassar.cmpu203.workoutapp.Model.Post;
import edu.vassar.cmpu203.workoutapp.R;
import edu.vassar.cmpu203.workoutapp.databinding.FragmentAddWorkoutBinding;
import edu.vassar.cmpu203.workoutapp.databinding.FragmentFilterBinding;

public class FilterFragment extends Fragment implements IFilterView {

    private FragmentFilterBinding binding;
    private Listener listener;
    private Feed feed;
    public FilterFragment(Listener listener) {
        this.listener = listener;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        this.binding = FragmentFilterBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(View v, Bundle savedInstanceState ) {

        Editable workoutLengthEditable = FilterFragment.this.binding.LengthInput.getText();
        String workoutLengthStr = workoutLengthEditable.toString();

        // retrieve item's quantity
        String workoutDifficulty = binding.spinner.getSelectedItem().toString();

        int workoutDif = Integer.parseInt(workoutDifficulty);


        // confirm we have both name and qty
        if (workoutLengthStr.length() == 0 || workoutDif == 0){
            Snackbar.make(v, "Both length and difficulty are mandatory!", Snackbar.LENGTH_LONG).show();
            return;
        }

        try {
            int workoutLength = Integer.parseInt(workoutLengthStr);
        } catch (NumberFormatException e) {
            Snackbar.make(v, "Please enter a number for length", Snackbar.LENGTH_LONG).show();
            return;
        }

        workoutLengthEditable.clear();

        this.binding.FilterSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FilterFragment.this.listener.onSetFilter();
            }
        });
    }
}