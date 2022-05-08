package edu.vassar.cmpu203.workoutapp.View;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.Snackbar;

import edu.vassar.cmpu203.workoutapp.Model.Profile;
import edu.vassar.cmpu203.workoutapp.R;
import edu.vassar.cmpu203.workoutapp.databinding.FragmentCreateProfileBinding;
import edu.vassar.cmpu203.workoutapp.databinding.FragmentStrengthBinding;
import edu.vassar.cmpu203.workoutapp.databinding.FragmentViewOtherProfileBinding;


public class ViewOtherProfileFragment extends Fragment implements IViewOtherProfileView{

    private IViewOtherProfileView.Listener listener;
    private FragmentViewOtherProfileBinding binding;
    private Profile profile;
    private Profile curUser;
    private boolean request = false;
    private final static String REQUEST = "REQUEST";


    public ViewOtherProfileFragment(Listener listener) {

        this.listener = listener;
        this.profile = this.listener.getUser2();
    }

    public ViewOtherProfileFragment(Listener listener, Profile profile){
        this.listener = listener;
        this.profile = profile;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        this.binding = FragmentViewOtherProfileBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        this.binding.OtherProfileUsername.setText(profile.getUsername());
        this.binding.OtherProfileViewBio.setText(profile.getBio());
        this.binding.PostNumberDisplay.setText(""+ profile.getNumPosts());
        this.binding.FollowerDisplay.setText(""+profile.getNumFollowers());
        this.binding.FollowingDisplay.setText(""+profile.getNumFollowing());

        this.binding.requestFollowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewOtherProfileFragment.this.request = true;
                ViewOtherProfileFragment.this.listener.requestFollow(profile, ViewOtherProfileFragment.this);
            }
        });


        this.binding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewOtherProfileFragment.this.listener.goBack();
            }
        });
    }

    @Override
    public void onSaveInstanceState(@Nullable Bundle outState){
        super.onSaveInstanceState(outState);

        outState.putBoolean(REQUEST, request);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState){
        super.onViewStateRestored(savedInstanceState);

        if (savedInstanceState != null){
            this.request = savedInstanceState.getBoolean(REQUEST);
        }

        if(request){
            onRequest();
        }
    }

    @Override
    public void onRequest(){
        this.binding.requestFollowButton.setEnabled(false);
    }

    @Override
    public void onAlreadyFollowing(){
        this.binding.requestFollowButton.setEnabled(false);
        Snackbar.make(this.binding.getRoot(), "You already follow this profile", Snackbar.LENGTH_LONG).show();
    }
}