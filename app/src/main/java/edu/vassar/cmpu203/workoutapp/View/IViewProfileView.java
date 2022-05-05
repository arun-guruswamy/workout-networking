package edu.vassar.cmpu203.workoutapp.View;

import edu.vassar.cmpu203.workoutapp.Model.Post;
import edu.vassar.cmpu203.workoutapp.Model.Workout;

public interface IViewProfileView {

    interface Listener{
        void onEditProfile();
        void onGoBack();
        void onFollowRequests();

    }
}
