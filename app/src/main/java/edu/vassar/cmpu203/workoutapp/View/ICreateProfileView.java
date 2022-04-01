package edu.vassar.cmpu203.workoutapp.View;

public interface ICreateProfileView {

    interface Listener{
        void onAddedUsername(String username, ICreateProfileView createProfileView);
        void onAddedPassword(String password, ICreateProfileView createProfileView);
        void onAddedBio(String bio, ICreateProfileView createProfileView);
        void onCreateButton();
    }

}
