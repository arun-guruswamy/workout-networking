// Generated by view binder compiler. Do not edit!
package edu.vassar.cmpu203.workoutapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import edu.vassar.cmpu203.workoutapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentCreatePostBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button addWorkoutButton;

  @NonNull
  public final Button cancelButton;

  @NonNull
  public final Button captionButton;

  @NonNull
  public final EditText captionTextBox;

  @NonNull
  public final ConstraintLayout constraintLayout;

  @NonNull
  public final TextView createPost;

  @NonNull
  public final Button postButton;

  @NonNull
  public final TextView postCaption;

  @NonNull
  public final TextView postWorkout;

  @NonNull
  public final TextView textView;

  @NonNull
  public final LinearLayout workoutLayout;

  private FragmentCreatePostBinding(@NonNull ConstraintLayout rootView,
      @NonNull Button addWorkoutButton, @NonNull Button cancelButton, @NonNull Button captionButton,
      @NonNull EditText captionTextBox, @NonNull ConstraintLayout constraintLayout,
      @NonNull TextView createPost, @NonNull Button postButton, @NonNull TextView postCaption,
      @NonNull TextView postWorkout, @NonNull TextView textView,
      @NonNull LinearLayout workoutLayout) {
    this.rootView = rootView;
    this.addWorkoutButton = addWorkoutButton;
    this.cancelButton = cancelButton;
    this.captionButton = captionButton;
    this.captionTextBox = captionTextBox;
    this.constraintLayout = constraintLayout;
    this.createPost = createPost;
    this.postButton = postButton;
    this.postCaption = postCaption;
    this.postWorkout = postWorkout;
    this.textView = textView;
    this.workoutLayout = workoutLayout;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentCreatePostBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentCreatePostBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_create__post_, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentCreatePostBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.addWorkoutButton;
      Button addWorkoutButton = ViewBindings.findChildViewById(rootView, id);
      if (addWorkoutButton == null) {
        break missingId;
      }

      id = R.id.cancelButton;
      Button cancelButton = ViewBindings.findChildViewById(rootView, id);
      if (cancelButton == null) {
        break missingId;
      }

      id = R.id.captionButton;
      Button captionButton = ViewBindings.findChildViewById(rootView, id);
      if (captionButton == null) {
        break missingId;
      }

      id = R.id.captionTextBox;
      EditText captionTextBox = ViewBindings.findChildViewById(rootView, id);
      if (captionTextBox == null) {
        break missingId;
      }

      ConstraintLayout constraintLayout = (ConstraintLayout) rootView;

      id = R.id.createPost;
      TextView createPost = ViewBindings.findChildViewById(rootView, id);
      if (createPost == null) {
        break missingId;
      }

      id = R.id.postButton;
      Button postButton = ViewBindings.findChildViewById(rootView, id);
      if (postButton == null) {
        break missingId;
      }

      id = R.id.postCaption;
      TextView postCaption = ViewBindings.findChildViewById(rootView, id);
      if (postCaption == null) {
        break missingId;
      }

      id = R.id.postWorkout;
      TextView postWorkout = ViewBindings.findChildViewById(rootView, id);
      if (postWorkout == null) {
        break missingId;
      }

      id = R.id.textView;
      TextView textView = ViewBindings.findChildViewById(rootView, id);
      if (textView == null) {
        break missingId;
      }

      id = R.id.workoutLayout;
      LinearLayout workoutLayout = ViewBindings.findChildViewById(rootView, id);
      if (workoutLayout == null) {
        break missingId;
      }

      return new FragmentCreatePostBinding((ConstraintLayout) rootView, addWorkoutButton,
          cancelButton, captionButton, captionTextBox, constraintLayout, createPost, postButton,
          postCaption, postWorkout, textView, workoutLayout);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
