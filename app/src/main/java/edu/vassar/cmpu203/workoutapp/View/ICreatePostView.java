package edu.vassar.cmpu203.workoutapp.View;

import android.view.View;

import edu.vassar.cmpu203.workoutapp.Model.*;

public interface ICreatePostView {


    interface Listener{
        void onAddedCaption(String caption, ICreatePostView createPostView, Post p);
        void onWorkoutButton(Workout workout, Post post);
        void onPostButton(Post post);
        void onCancelButton();
    }
    void updateCaption(String caption);

}
