package edu.vassar.cmpu203.workoutapp.Persistence;

import androidx.annotation.NonNull;

import edu.vassar.cmpu203.workoutapp.Model.Feed;
import edu.vassar.cmpu203.workoutapp.Model.Post;

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
    void savePost(Post post);
}
