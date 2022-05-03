package edu.vassar.cmpu203.workoutapp.View;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

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

    public FeedFragment(Listener listener){this.listener = listener;}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       this.binding = FragmentFeedBinding.inflate(inflater);
       return this.binding.getRoot();
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState ) {

        onFeedUpdated(this.feed);

        this.binding.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FeedFragment.this.listener.onAddPost();
            }
        });

        this.binding.FeedFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FeedFragment.this.listener.onFilter();
            }
        });
        this.binding.RemoveFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FeedFragment.this.listener.removeFilters();
            }
        });

        this.binding.ViewProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FeedFragment.this.listener.viewProfile();
            }
        });
    }

    @Override
    public void onFeedUpdated(Feed feed) {
        LinearLayout linearLayout = this.binding.feedLayout;

        for(Post post : feed.feed) {
            Button b = new Button(getContext());
            b.setBackgroundColor(Color.BLUE);
            b.setText(post.getProd_id());
            b.setTextColor(Color.WHITE);
            b.setId(View.generateViewId());
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // match the text of button to prod_id of a user
                    String prod_ID =  (String) b.getText();
                    FeedFragment.this.listener.onProfileClick(prod_ID);
                    // display new screen of their profile
                }
            });
            linearLayout.addView(b);
            TextView tv = new TextView(getContext());
            tv.setText(post.toString());
            linearLayout.addView(tv);
        }
    }
}