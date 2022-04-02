package edu.vassar.cmpu203.workoutapp.View;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.Snackbar;

import edu.vassar.cmpu203.workoutapp.R;
import edu.vassar.cmpu203.workoutapp.databinding.FragmentCreateProfileBinding;

public class CreateProfileFragment extends Fragment implements ICreateProfileView{

    private FragmentCreateProfileBinding binding;
    private ICreateProfileView.Listener listener;

    public CreateProfileFragment(Listener listener) {
        this.listener = listener;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        this.binding = FragmentCreateProfileBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){

        this.binding.createButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //For Username
                Editable profileUsernameEditable = CreateProfileFragment.this.binding.UsernameText.getText();
                String username = profileUsernameEditable.toString();

                profileUsernameEditable.clear();

                CreateProfileFragment.this.listener.onAddedUsername(username, CreateProfileFragment.this);

                //For Password
                Editable profilePasswordEditable = CreateProfileFragment.this.binding.passwordEditText.getText();
                String password = profilePasswordEditable.toString();

                profilePasswordEditable.clear();

                //For Bio information
                Editable profileBioEditable = CreateProfileFragment.this.binding.bioEditText.getText();
                String bio = profileBioEditable.toString();

                profileBioEditable.clear();

                if (username.length() == 0 || password.length() == 0 || bio.length() == 0){
                    Snackbar.make(v, "Username, password, and bio are mandatory!", Snackbar.LENGTH_LONG).show();
                    return;
                }

                CreateProfileFragment.this.listener.onAddedUsername(username, CreateProfileFragment.this);
                CreateProfileFragment.this.listener.onAddedPassword(password, CreateProfileFragment.this);
                CreateProfileFragment.this.listener.onAddedBio(bio, CreateProfileFragment.this);
                CreateProfileFragment.this.listener.onCreateButton();


            }

        });
    }
}