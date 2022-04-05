package edu.vassar.cmpu203.workoutapp.View;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.vassar.cmpu203.workoutapp.Model.*;
import edu.vassar.cmpu203.workoutapp.databinding.FragmentCreatePostBinding;


public class Create_Post_Fragment extends Fragment implements ICreatePostView {

    private FragmentCreatePostBinding binding;
    private ICreatePostView.Listener listener;
    private Workout w = new Cardio();
    private Post post;

    public Create_Post_Fragment(Listener listener) {
        this.listener = listener;
    }

    public Create_Post_Fragment(Listener listener, Post post) {
        this.listener = listener;
        this.post = post;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        this.binding = FragmentCreatePostBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){

        this.binding.postWorkout.setText(w.toString());

        this.binding.captionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                Editable postCaptionEditable = Create_Post_Fragment.this.binding.captionTextBox.getText();
                String postCaption = postCaptionEditable.toString();

                postCaptionEditable.clear();

                Create_Post_Fragment.this.listener.onAddedCaption(postCaption, Create_Post_Fragment.this, post);


            }
        });

        this.binding.addWorkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Create_Post_Fragment.this.listener.onWorkoutButton();

            }

        });

        this.binding.postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Create_Post_Fragment.this.listener.onPostButton();
            }
        });


    }

    @Override
    public void updateCaption(String caption) {

        this.binding.postCaption.setText(caption);
    }

}