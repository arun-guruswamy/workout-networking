package edu.vassar.cmpu203.workoutapp.View;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.vassar.cmpu203.workoutapp.R;
import edu.vassar.cmpu203.workoutapp.databinding.FragmentCreateProfileBinding;
import edu.vassar.cmpu203.workoutapp.databinding.FragmentStrengthBinding;
import edu.vassar.cmpu203.workoutapp.databinding.FragmentViewOtherProfileBinding;


public class ViewOtherProfileFragment extends Fragment implements IViewOtherProfileView{

    private IViewOtherProfileView.Listener listener;
    private FragmentViewOtherProfileBinding binding;

    public ViewOtherProfileFragment(Listener listener) {
        this.listener = listener;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        this.binding = FragmentViewOtherProfileBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
//        this.binding.viewUsername.setText(Profile.username);
//        this.binding.ProfileViewBio.setText(Profile.bio);
        this.binding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewOtherProfileFragment.this.listener.goBack();
            }
        });
    }
}