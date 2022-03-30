package edu.vassar.cmpu203.workoutapp.View;

import android.view.View;

import edu.vassar.cmpu203.workoutapp.Model.*;

public interface ICreatePostView {


    interface Listener{void onAddedCaption(String caption); }
    View getRootView();
    void updateCaption(String caption);

}
