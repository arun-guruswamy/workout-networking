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
    //void addProfile(@NonNull DataListener<Profile> listener);
    void savePost(Post post);
    void saveProfile(@NonNull Profile p);
    // void getProfile(@NonNull String prof_id);

    // authentication related
//    void createUserIfNotExists(@NonNull User user, @NonNull BinaryResultListener listener);
    void retrieveUser(@NonNull String username, @NonNull DataListener<Profile> listener);

}
