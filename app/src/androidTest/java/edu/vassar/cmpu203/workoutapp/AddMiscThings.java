package edu.vassar.cmpu203.workoutapp;

import android.view.View;
import android.widget.SeekBar;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;

import org.hamcrest.Matcher;

import edu.vassar.cmpu203.workoutapp.Model.Cardio;
import edu.vassar.cmpu203.workoutapp.Model.Profile;
import edu.vassar.cmpu203.workoutapp.Model.Strength;
import edu.vassar.cmpu203.workoutapp.Model.Workout;

public class AddMiscThings {

    public static Workout addWorkoutTests(int type, Workout workout, boolean[] values, String length, int difficulty, String description) {
        ViewInteraction addWorkoutButtonVi = Espresso.onView((ViewMatchers.withId(R.id.addWorkoutButton)));
        addWorkoutButtonVi.perform(ViewActions.click());

        if(type == 1) {
            ViewInteraction cardioButtonVi = Espresso.onView(ViewMatchers.withId(R.id.button2));
            cardioButtonVi.perform(ViewActions.click());


            if(values[0]){
                ViewInteraction agilityVi = Espresso.onView(ViewMatchers.withId(R.id.radioButton3));
                agilityVi.perform(ViewActions.click());
            }

            if(values[1]){
                ViewInteraction enduranceButtonVi = Espresso.onView(ViewMatchers.withId(R.id.radioButton4));
                enduranceButtonVi.perform(ViewActions.click());
            }

            if(values[2]) {
                ViewInteraction speedButtonVi = Espresso.onView(ViewMatchers.withId(R.id.radioButton5));
                speedButtonVi.perform(ViewActions.click());
            }

            ViewInteraction setVi = Espresso.onView(ViewMatchers.withId(R.id.button3));
            setVi.perform(ViewActions.click());
            workout = new Cardio(values);
        }
        else {
            ViewInteraction strengthButtonVi = Espresso.onView(ViewMatchers.withId(R.id.button));
            strengthButtonVi.perform(ViewActions.click());

            if(values[0]){
                ViewInteraction upperBodyButtonVi = Espresso.onView(ViewMatchers.withId(R.id.radioButton3));
                upperBodyButtonVi.perform(ViewActions.click());
            }

            if(values[1]){
                ViewInteraction lowerBodyButtonVi = Espresso.onView(ViewMatchers.withId(R.id.radioButton4));
                lowerBodyButtonVi.perform(ViewActions.click());
            }

            if(values[2]) {
                ViewInteraction bodyweightButtonVi = Espresso.onView(ViewMatchers.withId(R.id.radioButton5));
                bodyweightButtonVi.perform(ViewActions.click());
            }

            if(values[3]){
                ViewInteraction fullBodyButtonVi = Espresso.onView(ViewMatchers.withId(R.id.fullbodyFocusButton));
                fullBodyButtonVi.perform(ViewActions.click());
            }

            ViewInteraction setButton = Espresso.onView(ViewMatchers.withId(R.id.button3));
            setButton.perform(ViewActions.click());
            workout = new Strength(values);
        }

        ViewInteraction lengthVi = Espresso.onView(ViewMatchers.withId(R.id.editTextTextPersonName));
        lengthVi.perform(ViewActions.replaceText(length));
        workout.setLength(Integer.parseInt(length));

        ViewInteraction difficultyVi = Espresso.onView(ViewMatchers.withId(R.id.seekBar2));
        difficultyVi.perform(setProgress(difficulty));
        workout.setDifficulty(difficulty);

        ViewInteraction workoutDescriptionVi = Espresso.onView(ViewMatchers.withId(R.id.editTextTextPersonName4));
        workoutDescriptionVi.check(ViewAssertions.matches(ViewMatchers.withText(R.string.input_workout)));
        workoutDescriptionVi.perform(ViewActions.replaceText(description));
        workout.setDescription(description);

        ViewInteraction createWorkoutButtonVi = Espresso.onView(ViewMatchers.withId(R.id.button6));
        createWorkoutButtonVi.perform(ViewActions.click());

        return workout;

    }

    public static ViewAction setProgress(final int progress) {
        return new ViewAction() {
            @Override
            public void perform(UiController uiController, View view) {
                SeekBar seekBar = (SeekBar) view;
                seekBar.setProgress(progress);
            }
            @Override
            public String getDescription() {
                return "Set a progress on a SeekBar";
            }
            @Override
            public Matcher<View> getConstraints() {
                return ViewMatchers.isAssignableFrom(SeekBar.class);
            }
        };
    }

    public static Profile createProfile() {
        ViewInteraction createButtonVi = Espresso.onView(ViewMatchers.withId(R.id.createButton));
        createButtonVi.perform(ViewActions.click());
        Profile profile = new Profile();
        profile.setUsername("Username");

        return profile;
    }

   /* public static Post addPostCaption(Post post, String caption) {

      //create post screen, check to see of default text for caption is there
        //enter new caption
        ViewInteraction postCapEdVi = Espresso.onView(ViewMatchers.withId(R.id.captionTextBox));
        postCapEdVi.check(ViewAssertions.matches(ViewMatchers.withText(R.string.captionTextBox)));
        postCapEdVi.perform(ViewActions.replaceText(caption));

        //click the caption button and checks to see that the caption text has changed
        ViewInteraction captionButtonVi = Espresso.onView(ViewMatchers.withId(R.id.captionButton));
        captionButtonVi.perform(ViewActions.click());
        ViewInteraction postCaptionVi = Espresso.onView(ViewMatchers.withId(R.id.postWorkout));
        postCaptionVi.check(ViewAssertions.matches(ViewMatchers.withText(caption)));
        post.addCaption(caption);


        return post;
    }*/
}
