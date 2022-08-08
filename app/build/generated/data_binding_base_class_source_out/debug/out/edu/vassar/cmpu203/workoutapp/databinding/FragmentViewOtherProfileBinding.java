// Generated by view binder compiler. Do not edit!
package edu.vassar.cmpu203.workoutapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

public final class FragmentViewOtherProfileBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView FollowerCount;

  @NonNull
  public final TextView FollowerDisplay;

  @NonNull
  public final TextView FollowingCount;

  @NonNull
  public final TextView FollowingDisplay;

  @NonNull
  public final TextView OtherProfileUsername;

  @NonNull
  public final TextView OtherProfileViewBio;

  @NonNull
  public final TextView PostNumberDisplay;

  @NonNull
  public final TextView PostsNumber;

  @NonNull
  public final TextView ProfileView;

  @NonNull
  public final TextView ViewProfileUsername;

  @NonNull
  public final Button backButton;

  @NonNull
  public final ConstraintLayout frameLayout5;

  @NonNull
  public final Button requestFollowButton;

  @NonNull
  public final TextView textView11;

  private FragmentViewOtherProfileBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextView FollowerCount, @NonNull TextView FollowerDisplay,
      @NonNull TextView FollowingCount, @NonNull TextView FollowingDisplay,
      @NonNull TextView OtherProfileUsername, @NonNull TextView OtherProfileViewBio,
      @NonNull TextView PostNumberDisplay, @NonNull TextView PostsNumber,
      @NonNull TextView ProfileView, @NonNull TextView ViewProfileUsername,
      @NonNull Button backButton, @NonNull ConstraintLayout frameLayout5,
      @NonNull Button requestFollowButton, @NonNull TextView textView11) {
    this.rootView = rootView;
    this.FollowerCount = FollowerCount;
    this.FollowerDisplay = FollowerDisplay;
    this.FollowingCount = FollowingCount;
    this.FollowingDisplay = FollowingDisplay;
    this.OtherProfileUsername = OtherProfileUsername;
    this.OtherProfileViewBio = OtherProfileViewBio;
    this.PostNumberDisplay = PostNumberDisplay;
    this.PostsNumber = PostsNumber;
    this.ProfileView = ProfileView;
    this.ViewProfileUsername = ViewProfileUsername;
    this.backButton = backButton;
    this.frameLayout5 = frameLayout5;
    this.requestFollowButton = requestFollowButton;
    this.textView11 = textView11;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentViewOtherProfileBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentViewOtherProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_view_other_profile, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentViewOtherProfileBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.FollowerCount;
      TextView FollowerCount = ViewBindings.findChildViewById(rootView, id);
      if (FollowerCount == null) {
        break missingId;
      }

      id = R.id.FollowerDisplay;
      TextView FollowerDisplay = ViewBindings.findChildViewById(rootView, id);
      if (FollowerDisplay == null) {
        break missingId;
      }

      id = R.id.FollowingCount;
      TextView FollowingCount = ViewBindings.findChildViewById(rootView, id);
      if (FollowingCount == null) {
        break missingId;
      }

      id = R.id.FollowingDisplay;
      TextView FollowingDisplay = ViewBindings.findChildViewById(rootView, id);
      if (FollowingDisplay == null) {
        break missingId;
      }

      id = R.id.OtherProfileUsername;
      TextView OtherProfileUsername = ViewBindings.findChildViewById(rootView, id);
      if (OtherProfileUsername == null) {
        break missingId;
      }

      id = R.id.OtherProfileViewBio;
      TextView OtherProfileViewBio = ViewBindings.findChildViewById(rootView, id);
      if (OtherProfileViewBio == null) {
        break missingId;
      }

      id = R.id.PostNumberDisplay;
      TextView PostNumberDisplay = ViewBindings.findChildViewById(rootView, id);
      if (PostNumberDisplay == null) {
        break missingId;
      }

      id = R.id.PostsNumber;
      TextView PostsNumber = ViewBindings.findChildViewById(rootView, id);
      if (PostsNumber == null) {
        break missingId;
      }

      id = R.id.ProfileView;
      TextView ProfileView = ViewBindings.findChildViewById(rootView, id);
      if (ProfileView == null) {
        break missingId;
      }

      id = R.id.ViewProfileUsername;
      TextView ViewProfileUsername = ViewBindings.findChildViewById(rootView, id);
      if (ViewProfileUsername == null) {
        break missingId;
      }

      id = R.id.backButton;
      Button backButton = ViewBindings.findChildViewById(rootView, id);
      if (backButton == null) {
        break missingId;
      }

      ConstraintLayout frameLayout5 = (ConstraintLayout) rootView;

      id = R.id.requestFollowButton;
      Button requestFollowButton = ViewBindings.findChildViewById(rootView, id);
      if (requestFollowButton == null) {
        break missingId;
      }

      id = R.id.textView11;
      TextView textView11 = ViewBindings.findChildViewById(rootView, id);
      if (textView11 == null) {
        break missingId;
      }

      return new FragmentViewOtherProfileBinding((ConstraintLayout) rootView, FollowerCount,
          FollowerDisplay, FollowingCount, FollowingDisplay, OtherProfileUsername,
          OtherProfileViewBio, PostNumberDisplay, PostsNumber, ProfileView, ViewProfileUsername,
          backButton, frameLayout5, requestFollowButton, textView11);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
