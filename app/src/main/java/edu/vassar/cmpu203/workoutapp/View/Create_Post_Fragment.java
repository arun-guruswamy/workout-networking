package edu.vassar.cmpu203.workoutapp.View;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.vassar.cmpu203.workoutapp.R;
import edu.vassar.cmpu203.workoutapp.databinding.FragmentCreatePostBinding;


public class Create_Post_Fragment extends Fragment implements ICreatePostView {

    private FragmentCreatePostBinding binding;
    private ICreatePostView.Listener listener;

    public Create_Post_Fragment(Listener listener) {
        this.listener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        this.binding = FragmentCreatePostBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){

        this.binding.captionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                Editable postCaptionEditable = Create_Post_Fragment.this.binding.captionTextBox.getText();
                String postCaption = postCaptionEditable.toString();

                postCaptionEditable.clear();

                Create_Post_Fragment.this.listener.onAddedCaption(postCaption, Create_Post_Fragment.this);

            }
        });

        this.binding.addWorkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Create_Post_Fragment.this.listener.onWorkoutButton();

            }

        });


    }

    @Override
    public void updateCaption(String caption) {

        this.binding.postCaption.setText(caption);
    }
}