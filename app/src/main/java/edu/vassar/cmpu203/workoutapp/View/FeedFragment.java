package edu.vassar.cmpu203.workoutapp.View;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.vassar.cmpu203.workoutapp.Model.Feed;
import edu.vassar.cmpu203.workoutapp.Model.Post;
import edu.vassar.cmpu203.workoutapp.databinding.FragmentFeedBinding;

public class FeedFragment extends Fragment implements IFeedView {

    private FragmentFeedBinding binding;
    private IFeedView.Listener listener;
    private Feed feed;

    public FeedFragment(Listener listener, Feed feed) {
       this.listener = listener;
       this.feed = feed;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       this.binding = FragmentFeedBinding.inflate(inflater);
       return this.binding.getRoot();
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState ) {

            Post p = feed.feed.get(0);
            this.binding.Post1.setText(p.toString());
            Post p2 = feed.feed.get(1);
            this.binding.Post1.setText(p2.toString());
            Post p3 = feed.feed.get(2);
            this.binding.Post1.setText(p3.toString());


        this.binding.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FeedFragment.this.listener.onAddPost();
            }
        });
    }
}