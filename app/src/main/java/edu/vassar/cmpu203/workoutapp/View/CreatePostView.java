package edu.vassar.cmpu203.workoutapp.View;

import android.content.Context;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;

import edu.vassar.cmpu203.workoutapp.Model.Post;
import edu.vassar.cmpu203.workoutapp.databinding.FragmentCreatePostBinding;

public class CreatePostView implements ICreatePostView{

    private FragmentCreatePostBinding binding;
    private Listener listener;

    public CreatePostView(Context context, Listener listener) {
        this.binding = FragmentCreatePostBinding.inflate(LayoutInflater.from(context));
        this.listener = listener;

        this.binding.captionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                Editable postCaptionEditable = CreatePostView.this.binding.captionTextBox.getText();
                String postCaption = postCaptionEditable.toString();

                postCaptionEditable.clear();

                CreatePostView.this.listener.onAddedCaption(postCaption);

            }
        });
    }

    @Override
    public View getRootView(){
        return binding.getRoot();
    }

    @Override
    public void updateCaption(String caption) {

        this.binding.postCaption.setText(caption);
    }

}


