package edu.vassar.cmpu203.workoutapp.View;

public interface IFeedView {

    interface Listener{
        void onAddPost();
        void onFilter();
        void removeFilters();
    }
}
