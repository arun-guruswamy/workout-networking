package edu.vassar.cmpu203.workoutapp.View;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import edu.vassar.cmpu203.workoutapp.Model.Feed;
import edu.vassar.cmpu203.workoutapp.Model.Post;
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

                //CreateProfileFragment.this.listener.onAddedUsername(username, CreateProfileFragment.this);

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

/*                CreateProfileFragment.this.listener.onAddedUsername(username, CreateProfileFragment.this);
                CreateProfileFragment.this.listener.onAddedPassword(password, CreateProfileFragment.this);
                CreateProfileFragment.this.listener.onAddedBio(bio, CreateProfileFragment.this);*/
                CreateProfileFragment.this.listener.onCreateButton(username, password, bio);


            }

        });
    }

//    @Override
//    public void onProfileUpdated(Feed feed) {
//        LinearLayout linearLayout = this.binding.feedLayout;
//
//        for(Post post : feed.feed) {
//            Button b = new Button(getContext());
//            b.setBackgroundColor(Color.BLUE);
//            b.setText(post.getProd_id());
//            b.setTextColor(Color.WHITE);
//            b.setId(View.generateViewId());
//            b.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    // match the text of button to prod_id of a user
//                    String prod_ID =  (String) b.getText();
//                    FeedFragment.this.listener.onProfileClick(prod_ID);
//                    // display new screen of their profile
//                }
//            });
//            linearLayout.addView(b);
//            TextView tv = new TextView(getContext());
//            tv.setText(post.toString());
//            linearLayout.addView(tv);
//        }
//    }
}