package edu.vassar.cmpu203.workoutapp.View;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.collection.LLRBNode;

import edu.vassar.cmpu203.workoutapp.Model.Profile;
import edu.vassar.cmpu203.workoutapp.R;
import edu.vassar.cmpu203.workoutapp.databinding.FragmentFollowRequestBinding;


public class FollowRequestFragment extends Fragment implements IFollowRequestView {

    private Profile curUser;
    private FragmentFollowRequestBinding binding;
    private Listener listener;


    public FollowRequestFragment(Listener listener, Profile curUser) {
        this.listener = listener;
        this.curUser = curUser;
    }




   /* @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        this.binding = FragmentFollowRequestBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){

        LinearLayout ll = this.binding.followRequestLinear;

        for(Profile p : this.curUser.getFollowRequests().values()) {
            TextView tv = new TextView(getContext());
            tv.setText(p.getUsername() + " wants to follow you!");
            tv.setTextSize(24);
            ll.addView(tv);
            Button accept = new Button(getContext());
            accept.setText("Accept");
            accept.setTextSize(18);
            accept.setTextColor(Color.WHITE);
            accept.setBackgroundColor(Color.BLUE);
            Button decline = new Button(getContext());
            decline.setText("Decline");
            decline.setTextSize(18);
            decline.setTextColor(Color.WHITE);
            decline.setBackgroundColor(Color.BLUE);

            accept.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FollowRequestFragment.this.listener.onAccept(p);
                    answerGiven(ll, tv, accept, decline);
                    displayMessage(R.string.accept);
                }
            });
            decline.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FollowRequestFragment.this.listener.onDecline(p);
                    answerGiven(ll, tv, accept, decline);
                    displayMessage(R.string.decline);
                }
            });

            ll.addView(accept);
            ll.addView(decline);
        }

        this.binding.backToProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FollowRequestFragment.this.listener.onBack();
            }
        });
    }

    private void answerGiven(LinearLayout ll, View tv, View b1, View b2){
        ll.removeView(tv);
        ll.removeView(b1);
        ll.removeView(b2);
    }

    private void displayMessage(int msgRid){
        Snackbar.make(this.binding.getRoot(), msgRid, Snackbar.LENGTH_LONG).show();
    }
}