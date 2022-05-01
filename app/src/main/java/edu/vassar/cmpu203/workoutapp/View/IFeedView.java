package edu.vassar.cmpu203.workoutapp.View;

import edu.vassar.cmpu203.workoutapp.Model.Feed;

public interface IFeedView {

    interface Listener{
        void onAddPost();
        void onFilter();
        void removeFilters();
        void viewProfile();
        void onProfileClick(String prod_ID);
    }

    void onFeedUpdated(Feed feed);
}
