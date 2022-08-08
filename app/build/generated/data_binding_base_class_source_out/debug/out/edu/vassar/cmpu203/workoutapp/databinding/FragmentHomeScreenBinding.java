// Generated by view binder compiler. Do not edit!
package edu.vassar.cmpu203.workoutapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import edu.vassar.cmpu203.workoutapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentHomeScreenBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final Button logInButton;

  @NonNull
  public final TextView newUserMessage;

  @NonNull
  public final EditText passwordField;

  @NonNull
  public final TextView passwordLogIn;

  @NonNull
  public final Button signUpButton;

  @NonNull
  public final EditText usernameField;

  @NonNull
  public final TextView usernameLogIn;

  @NonNull
  public final TextView welcomeMessage;

  private FragmentHomeScreenBinding(@NonNull FrameLayout rootView, @NonNull Button logInButton,
      @NonNull TextView newUserMessage, @NonNull EditText passwordField,
      @NonNull TextView passwordLogIn, @NonNull Button signUpButton,
      @NonNull EditText usernameField, @NonNull TextView usernameLogIn,
      @NonNull TextView welcomeMessage) {
    this.rootView = rootView;
    this.logInButton = logInButton;
    this.newUserMessage = newUserMessage;
    this.passwordField = passwordField;
    this.passwordLogIn = passwordLogIn;
    this.signUpButton = signUpButton;
    this.usernameField = usernameField;
    this.usernameLogIn = usernameLogIn;
    this.welcomeMessage = welcomeMessage;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentHomeScreenBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentHomeScreenBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_home_screen, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentHomeScreenBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.logInButton;
      Button logInButton = ViewBindings.findChildViewById(rootView, id);
      if (logInButton == null) {
        break missingId;
      }

      id = R.id.newUserMessage;
      TextView newUserMessage = ViewBindings.findChildViewById(rootView, id);
      if (newUserMessage == null) {
        break missingId;
      }

      id = R.id.passwordField;
      EditText passwordField = ViewBindings.findChildViewById(rootView, id);
      if (passwordField == null) {
        break missingId;
      }

      id = R.id.passwordLogIn;
      TextView passwordLogIn = ViewBindings.findChildViewById(rootView, id);
      if (passwordLogIn == null) {
        break missingId;
      }

      id = R.id.signUpButton;
      Button signUpButton = ViewBindings.findChildViewById(rootView, id);
      if (signUpButton == null) {
        break missingId;
      }

      id = R.id.usernameField;
      EditText usernameField = ViewBindings.findChildViewById(rootView, id);
      if (usernameField == null) {
        break missingId;
      }

      id = R.id.usernameLogIn;
      TextView usernameLogIn = ViewBindings.findChildViewById(rootView, id);
      if (usernameLogIn == null) {
        break missingId;
      }

      id = R.id.welcomeMessage;
      TextView welcomeMessage = ViewBindings.findChildViewById(rootView, id);
      if (welcomeMessage == null) {
        break missingId;
      }

      return new FragmentHomeScreenBinding((FrameLayout) rootView, logInButton, newUserMessage,
          passwordField, passwordLogIn, signUpButton, usernameField, usernameLogIn, welcomeMessage);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
