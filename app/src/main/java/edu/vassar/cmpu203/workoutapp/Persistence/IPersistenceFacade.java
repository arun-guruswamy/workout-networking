package edu.vassar.cmpu203.workoutapp.Persistence;

import androidx.annotation.NonNull;

import edu.vassar.cmpu203.workoutapp.Model.Feed;
import edu.vassar.cmpu203.workoutapp.Model.Post;
import edu.vassar.cmpu203.workoutapp.Model.Profile;

public interface IPersistenceFacade {

    interface DataListener<T> {
        void onDataReceived(@NonNull T data);
        void onNoDataFound();
    }

    interface BinaryResultListener {
        void onYesResult();
        void onNoResult();
    }

    void retrieveFeed(@NonNull DataListener<Feed> listener);
    void addProfile(@NonNull Profile profile, @NonNull BinaryResultListener listener);
    void savePost(Post post);
    void saveProfile(@NonNull Profile p);
    void retrieveProfile(@NonNull String Username, @NonNull DataListener<Profile> listener);
    void editProfile(Profile profile, String old);
}
