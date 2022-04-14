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

    /**
     * navigates the add workout screens and creates a workout to help with the testing
     * makes it easier to create different types of workouts
     *
     * @param type the type of workout
     * @param workout the workout that is being worked on for comparison
     * @param values the values for the workout, determines which radio buttons are pressed
     * @param length the length of the workout being created
     * @param difficulty the difficulty of the workout being created
     * @param description the description of the workout being created
     * @return a workout that is going to be used for comparison to make sure the app is displaying the data properly
     */
    public static Workout addWorkoutTests(int type, Workout workout, boolean[] values, String length, int difficulty, String description) {
        //clicks the add workout button on the create post screen
        ViewInteraction addWorkoutButtonVi = Espresso.onView((ViewMatchers.withId(R.id.addWorkoutButton)));
        addWorkoutButtonVi.perform(ViewActions.click());

        //if the workout type is a cardio workout and adds the correct values
        if(type == 1) {
            ViewInteraction cardioButtonVi = Espresso.onView(ViewMatchers.withId(R.id.CardioButton));
            cardioButtonVi.perform(ViewActions.click());


            if(values[0]){
                ViewInteraction agilityVi = Espresso.onView(ViewMatchers.withId(R.id.AgilityOption));
                agilityVi.perform(ViewActions.click());
            }

            if(values[1]){
                ViewInteraction enduranceButtonVi = Espresso.onView(ViewMatchers.withId(R.id.EnduranceOption));
                enduranceButtonVi.perform(ViewActions.click());
            }

            if(values[2]) {
                ViewInteraction speedButtonVi = Espresso.onView(ViewMatchers.withId(R.id.SpeedOption));
                speedButtonVi.perform(ViewActions.click());
            }

            ViewInteraction setVi = Espresso.onView(ViewMatchers.withId(R.id.CardioSetButton));
            setVi.perform(ViewActions.click());
            workout = new Cardio(values);
        }
        // if the workout is a strength workout
        else {
            ViewInteraction strengthButtonVi = Espresso.onView(ViewMatchers.withId(R.id.StrengthButton));
            strengthButtonVi.perform(ViewActions.click());

            if(values[0]){
                ViewInteraction upperBodyButtonVi = Espresso.onView(ViewMatchers.withId(R.id.UpperBodyOption));
                upperBodyButtonVi.perform(ViewActions.click());
            }

            if(values[1]){
                ViewInteraction lowerBodyButtonVi = Espresso.onView(ViewMatchers.withId(R.id.LowerBodyOption));
                lowerBodyButtonVi.perform(ViewActions.click());
            }

            if(values[2]) {
                ViewInteraction bodyweightButtonVi = Espresso.onView(ViewMatchers.withId(R.id.BodyWeightOption));
                bodyweightButtonVi.perform(ViewActions.click());
            }

            if(values[3]){
                ViewInteraction fullBodyButtonVi = Espresso.onView(ViewMatchers.withId(R.id.FullBodyOption));
                fullBodyButtonVi.perform(ViewActions.click());
            }

            ViewInteraction setButton = Espresso.onView(ViewMatchers.withId(R.id.StrengthSetButton));
            setButton.perform(ViewActions.click());
            workout = new Strength(values);
        }

        // add the length
        ViewInteraction lengthVi = Espresso.onView(ViewMatchers.withId(R.id.WorkoutLengthInput));
        lengthVi.perform(ViewActions.replaceText(length));
        workout.setLength(Integer.parseInt(length));

        //add the difficulty
        ViewInteraction difficultyVi = Espresso.onView(ViewMatchers.withId(R.id.WorkoutDifficultyInput));
        difficultyVi.perform(setProgress(difficulty));
        workout.setDifficulty(difficulty);

        // add the description
        ViewInteraction workoutDescriptionVi = Espresso.onView(ViewMatchers.withId(R.id.WorkoutDescriptionInput));
        workoutDescriptionVi.check(ViewAssertions.matches(ViewMatchers.withText(R.string.input_workout)));
        workoutDescriptionVi.perform(ViewActions.replaceText(description));
        workout.setDescription(description);

        //click the create workout button on the add workout screen
        ViewInteraction createWorkoutButtonVi = Espresso.onView(ViewMatchers.withId(R.id.AddWorkoutButton));
        createWorkoutButtonVi.perform(ViewActions.click());

        return workout;

    }

    //helps set the seekbar to different values
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

    /**
     * navigates the create profile screen
     * @return a default profile to be used to testing
     */
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
