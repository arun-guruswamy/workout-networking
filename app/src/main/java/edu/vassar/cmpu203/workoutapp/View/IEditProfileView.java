package edu.vassar.cmpu203.workoutapp.View;

public interface IEditProfileView {

    interface Listener{
        void onEditedUsername(String username, IEditProfileView editProfileView);
        void onEditedPassword(String password, IEditProfileView editProfileView);
        void onEditedBio(String bio, IEditProfileView editProfileView);
        void onDoneButton();
    }
}
