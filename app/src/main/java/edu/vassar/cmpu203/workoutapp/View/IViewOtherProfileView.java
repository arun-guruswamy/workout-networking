package edu.vassar.cmpu203.workoutapp.View;

import edu.vassar.cmpu203.workoutapp.Model.Profile;

public interface IViewOtherProfileView {

    interface Listener{
        void goBack();
        void requestFollow(Profile profile, IViewOtherProfileView iViewOtherProfileView);
    }

    void onRequest();
}
