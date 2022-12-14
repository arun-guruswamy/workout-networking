// Generated by view binder compiler. Do not edit!
package edu.vassar.cmpu203.workoutapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
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

public final class FragmentFilterBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button FilterSet;

  @NonNull
  public final TextView FilterTitle;

  @NonNull
  public final TextView LengthFilter;

  @NonNull
  public final EditText LengthInput;

  @NonNull
  public final TextView SportFilter;

  @NonNull
  public final TextView TypeFilter;

  @NonNull
  public final Spinner TypeOptions;

  @NonNull
  public final TextView diffFIlter;

  @NonNull
  public final Spinner diffOptions;

  @NonNull
  public final ConstraintLayout frameLayout4;

  @NonNull
  public final LinearLayout linearLayout5;

  @NonNull
  public final LinearLayout linearLayout7;

  @NonNull
  public final Spinner sportOptions;

  @NonNull
  public final TextView textView4;

  private FragmentFilterBinding(@NonNull ConstraintLayout rootView, @NonNull Button FilterSet,
      @NonNull TextView FilterTitle, @NonNull TextView LengthFilter, @NonNull EditText LengthInput,
      @NonNull TextView SportFilter, @NonNull TextView TypeFilter, @NonNull Spinner TypeOptions,
      @NonNull TextView diffFIlter, @NonNull Spinner diffOptions,
      @NonNull ConstraintLayout frameLayout4, @NonNull LinearLayout linearLayout5,
      @NonNull LinearLayout linearLayout7, @NonNull Spinner sportOptions,
      @NonNull TextView textView4) {
    this.rootView = rootView;
    this.FilterSet = FilterSet;
    this.FilterTitle = FilterTitle;
    this.LengthFilter = LengthFilter;
    this.LengthInput = LengthInput;
    this.SportFilter = SportFilter;
    this.TypeFilter = TypeFilter;
    this.TypeOptions = TypeOptions;
    this.diffFIlter = diffFIlter;
    this.diffOptions = diffOptions;
    this.frameLayout4 = frameLayout4;
    this.linearLayout5 = linearLayout5;
    this.linearLayout7 = linearLayout7;
    this.sportOptions = sportOptions;
    this.textView4 = textView4;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentFilterBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentFilterBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_filter, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentFilterBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.FilterSet;
      Button FilterSet = ViewBindings.findChildViewById(rootView, id);
      if (FilterSet == null) {
        break missingId;
      }

      id = R.id.FilterTitle;
      TextView FilterTitle = ViewBindings.findChildViewById(rootView, id);
      if (FilterTitle == null) {
        break missingId;
      }

      id = R.id.LengthFilter;
      TextView LengthFilter = ViewBindings.findChildViewById(rootView, id);
      if (LengthFilter == null) {
        break missingId;
      }

      id = R.id.LengthInput;
      EditText LengthInput = ViewBindings.findChildViewById(rootView, id);
      if (LengthInput == null) {
        break missingId;
      }

      id = R.id.SportFilter;
      TextView SportFilter = ViewBindings.findChildViewById(rootView, id);
      if (SportFilter == null) {
        break missingId;
      }

      id = R.id.TypeFilter;
      TextView TypeFilter = ViewBindings.findChildViewById(rootView, id);
      if (TypeFilter == null) {
        break missingId;
      }

      id = R.id.TypeOptions;
      Spinner TypeOptions = ViewBindings.findChildViewById(rootView, id);
      if (TypeOptions == null) {
        break missingId;
      }

      id = R.id.diffFIlter;
      TextView diffFIlter = ViewBindings.findChildViewById(rootView, id);
      if (diffFIlter == null) {
        break missingId;
      }

      id = R.id.diffOptions;
      Spinner diffOptions = ViewBindings.findChildViewById(rootView, id);
      if (diffOptions == null) {
        break missingId;
      }

      ConstraintLayout frameLayout4 = (ConstraintLayout) rootView;

      id = R.id.linearLayout5;
      LinearLayout linearLayout5 = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout5 == null) {
        break missingId;
      }

      id = R.id.linearLayout7;
      LinearLayout linearLayout7 = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout7 == null) {
        break missingId;
      }

      id = R.id.sportOptions;
      Spinner sportOptions = ViewBindings.findChildViewById(rootView, id);
      if (sportOptions == null) {
        break missingId;
      }

      id = R.id.textView4;
      TextView textView4 = ViewBindings.findChildViewById(rootView, id);
      if (textView4 == null) {
        break missingId;
      }

      return new FragmentFilterBinding((ConstraintLayout) rootView, FilterSet, FilterTitle,
          LengthFilter, LengthInput, SportFilter, TypeFilter, TypeOptions, diffFIlter, diffOptions,
          frameLayout4, linearLayout5, linearLayout7, sportOptions, textView4);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
