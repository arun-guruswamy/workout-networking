package edu.vassar.cmpu203.workoutapp.View;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.vassar.cmpu203.workoutapp.Model.Profile;
import edu.vassar.cmpu203.workoutapp.R;
import edu.vassar.cmpu203.workoutapp.databinding.FragmentCreateProfileBinding;
import edu.vassar.cmpu203.workoutapp.databinding.FragmentStrengthBinding;
import edu.vassar.cmpu203.workoutapp.databinding.FragmentViewProfileBinding;


public class ViewProfileFragment extends Fragment implements IViewProfileView{

    private IViewProfileView.Listener listener;
    private FragmentViewProfileBinding binding;
    private Profile curUser;

    public ViewProfileFragment(Listener listener){
        this.listener = listener;
        this.curUser = this.listener.getCurUser();
    }

    public ViewProfileFragment(Listener listener, Profile curUser) {

        this.listener = listener;
        this.curUser = curUser;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        this.binding = FragmentViewProfileBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        this.binding.viewUsername.setText(curUser.getUsername());
        this.binding.ProfileViewBio.setText(curUser.getBio());
        this.binding.FollowerDisplay.setText(""+ curUser.getNumFollowers());
        this.binding.FollowingDisplay.setText("" + curUser.getNumFollowing());
        this.binding.PostNumberDisplay.setText("" + curUser.getNumPosts());

        this.binding.editProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewProfileFragment.this.listener.onEditProfile();
            }
        });

        this.binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewProfileFragment.this.listener.onGoBack();
            }
        });

        this.binding.button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewProfileFragment.this.listener.onFollowRequests();
            }
        });
    }
}