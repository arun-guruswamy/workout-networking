package edu.vassar.cmpu203.workoutapp;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import static org.hamcrest.Matchers.anything;


import android.os.SystemClock;
import android.view.View;

import org.hamcrest.Matcher;
import org.junit.Test;

import edu.vassar.cmpu203.workoutapp.Controller.MainActivity;
import edu.vassar.cmpu203.workoutapp.AddPostInstTest;
import edu.vassar.cmpu203.workoutapp.CreateProfileInstTest;
import edu.vassar.cmpu203.workoutapp.Model.Cardio;
import edu.vassar.cmpu203.workoutapp.Model.Difficulty;
import edu.vassar.cmpu203.workoutapp.Model.Feed;
import edu.vassar.cmpu203.workoutapp.Model.Filter;
import edu.vassar.cmpu203.workoutapp.Model.Length;
import edu.vassar.cmpu203.workoutapp.Model.Post;
import edu.vassar.cmpu203.workoutapp.Model.Profile;
import edu.vassar.cmpu203.workoutapp.Model.Strength;
import edu.vassar.cmpu203.workoutapp.Model.Workout;
import edu.vassar.cmpu203.workoutapp.AddMiscThings;


public class FilterFeedInstTest extends AddMiscThings{
    @org.junit.Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    /**
     * Adds two posts, and then specifies a length filter that produces a feed with
     * only the desired length
     */
    @Test
    public void FilterLengthTest() {
        //create profile screen -> leaves default values and clicks create
        //creates a new Profile and sets the Username to default
        ViewInteraction createButtonVi = onView(withId(R.id.createButton));
        createButtonVi.perform(ViewActions.click());
        Profile profile = new Profile();
        profile.setUsername("Username");

        ViewInteraction post1Vi = onView(withId(R.id.Post1));
        post1Vi.check(ViewAssertions.matches(ViewMatchers.withText(R.string.Post1)));
        ViewInteraction addPostButtonVi = onView(withId(R.id.addButton));
        addPostButtonVi.perform(ViewActions.click());
        Post post = new Post(profile);
        Workout workout = new Workout();
        Feed f = new Feed();

        //create post screen, checks that default caption text is there
        ViewInteraction postCaptionVi = onView(withId(R.id.postCaption));
        postCaptionVi.check(ViewAssertions.matches(ViewMatchers.withText(R.string.postCaption)));

        // checks that the default workout text is there
        ViewInteraction postWorkoutVi = onView(withId(R.id.postWorkout));
        postWorkoutVi.check(ViewAssertions.matches(ViewMatchers.withText(workout.toString())));

        boolean[] attributes = new boolean[3];
        attributes[0] = true;
        workout = addWorkoutTests(1, workout, attributes, "5", 5, "5 mile run");
        post.setWorkout(workout);

        postWorkoutVi.check(ViewAssertions.matches(ViewMatchers.withText(workout.toString())));

        //create post screen, check to see of default text for caption is there
        //enter new caption
        ViewInteraction postCapEdVi = onView(withId(R.id.captionTextBox));
        postCapEdVi.check(ViewAssertions.matches(ViewMatchers.withText(R.string.captionTextBox)));
        postCapEdVi.perform(ViewActions.replaceText("A fun workout"));
        onView(ViewMatchers.isRoot()).perform(ViewActions.closeSoftKeyboard());

        //click the caption button and checks to see that the caption text has changed
        ViewInteraction captionButtonVi = onView(withId(R.id.captionButton));
        captionButtonVi.perform(ViewActions.click());
        postCaptionVi.check(ViewAssertions.matches(ViewMatchers.withText("A fun workout")));
        post.addCaption("A fun workout");

        // clicks on the post button
        ViewInteraction postButtonVi = onView(withId(R.id.postButton));
        postButtonVi.perform(ViewActions.click());

        //checks to see if the post1 text in the feed is the same as the post that was just created
        post1Vi = onView(withId(R.id.Post1));
        post1Vi.check(ViewAssertions.matches(ViewMatchers.withText(post.toString())));

        // START OF SECOND POST

        //Feed screen, checks that Post1 has the default text, clicks on the add post button
        ViewInteraction post2Vi = onView(withId(R.id.Post2));
        post2Vi.check(ViewAssertions.matches(ViewMatchers.withText(R.string.Post2)));
        addPostButtonVi.perform(ViewActions.click());
        Post post1 = new Post(profile);
        Workout workout1 = new Workout();

        boolean[] attributes1 = new boolean[4];
        attributes[0] = true;
        attributes[2] = true;
        workout1 = addWorkoutTests(2, workout1, attributes1, "3", 5, "5 mile run");
        post1.setWorkout(workout1);

        postWorkoutVi.check(ViewAssertions.matches(ViewMatchers.withText(workout1.toString())));

        //create post screen, check to see of default text for caption is there
        //enter new caption
        postCapEdVi.perform(ViewActions.replaceText("A fun workout"));
        onView(ViewMatchers.isRoot()).perform(ViewActions.closeSoftKeyboard());

        //click the caption button and checks to see that the caption text has changed
        captionButtonVi.perform(ViewActions.click());
        postCaptionVi.check(ViewAssertions.matches(ViewMatchers.withText("A fun workout")));
        post1.addCaption("A fun workout");

        // clicks on the post button
        postButtonVi.perform(ViewActions.click());

        //Clicks filter button
        ViewInteraction filterButtonVi = onView(withId(R.id.FeedFilter));
        filterButtonVi.perform(ViewActions.click());

        //Enter length filter
        ViewInteraction filterLengthVi = onView(withId(R.id.LengthInput));
        filterLengthVi.perform(ViewActions.typeText("3"));
        onView(ViewMatchers.isRoot()).perform(ViewActions.closeSoftKeyboard());


        //Set filters
        onView(withId(R.id.FilterSet)).perform(ViewActions.click());

        //Check if only second post is shown
        onView(withId(R.id.Post1)).check(ViewAssertions.matches(ViewMatchers.withText(post1.toString())));

        //Remove Filters and check if both posts are there
        onView(withId(R.id.RemoveFilter)).perform(ViewActions.click());
        onView(withId(R.id.Post1)).check(ViewAssertions.matches(ViewMatchers.withText(post.toString())));
        onView(withId(R.id.Post2)).check(ViewAssertions.matches(ViewMatchers.withText(post1.toString())));
    }

    /**
     * Adds two posts, and then specifies a difficulty filter that produces a feed with
     * only the desired difficulty
     */
    @Test
    public void FilterDifficultyTest() {
        //create profile screen -> leaves default values and clicks create
        //creates a new Profile and sets the Username to default
        ViewInteraction createButtonVi = onView(withId(R.id.createButton));
        createButtonVi.perform(ViewActions.click());
        Profile profile = new Profile();
        profile.setUsername("Username");

        ViewInteraction post1Vi = onView(withId(R.id.Post1));
        post1Vi.check(ViewAssertions.matches(ViewMatchers.withText(R.string.Post1)));
        ViewInteraction addPostButtonVi = onView(withId(R.id.addButton));
        addPostButtonVi.perform(ViewActions.click());
        Post post = new Post(profile);
        Workout workout = new Workout();
        Feed f = new Feed();

        //create post screen, checks that default caption text is there
        ViewInteraction postCaptionVi = onView(withId(R.id.postCaption));
        postCaptionVi.check(ViewAssertions.matches(ViewMatchers.withText(R.string.postCaption)));

        // checks that the default workout text is there
        ViewInteraction postWorkoutVi = onView(withId(R.id.postWorkout));
        postWorkoutVi.check(ViewAssertions.matches(ViewMatchers.withText(workout.toString())));

        boolean[] attributes = new boolean[3];
        attributes[0] = true;
        workout = addWorkoutTests(1, workout, attributes, "5", 3, "5 mile run");
        post.setWorkout(workout);

        postWorkoutVi.check(ViewAssertions.matches(ViewMatchers.withText(workout.toString())));

        //create post screen, check to see of default text for caption is there
        //enter new caption
        ViewInteraction postCapEdVi = onView(withId(R.id.captionTextBox));
        postCapEdVi.check(ViewAssertions.matches(ViewMatchers.withText(R.string.captionTextBox)));
        postCapEdVi.perform(ViewActions.replaceText("A fun workout"));
        onView(ViewMatchers.isRoot()).perform(ViewActions.closeSoftKeyboard());

        //click the caption button and checks to see that the caption text has changed
        ViewInteraction captionButtonVi = onView(withId(R.id.captionButton));
        captionButtonVi.perform(ViewActions.click());
        postCaptionVi.check(ViewAssertions.matches(ViewMatchers.withText("A fun workout")));
        post.addCaption("A fun workout");

        // clicks on the post button
        ViewInteraction postButtonVi = onView(withId(R.id.postButton));
        postButtonVi.perform(ViewActions.click());

        //checks to see if the post1 text in the feed is the same as the post that was just created
        post1Vi = onView(withId(R.id.Post1));
        post1Vi.check(ViewAssertions.matches(ViewMatchers.withText(post.toString())));

        // START OF SECOND POST

        //Feed screen, checks that Post1 has the default text, clicks on the add post button
        ViewInteraction post2Vi = onView(withId(R.id.Post2));
        post2Vi.check(ViewAssertions.matches(ViewMatchers.withText(R.string.Post2)));
        addPostButtonVi.perform(ViewActions.click());
        Post post1 = new Post(profile);
        Workout workout1 = new Workout();

        boolean[] attributes1 = new boolean[4];
        attributes[0] = true;
        attributes[2] = true;
        workout1 = addWorkoutTests(2, workout1, attributes1, "5", 5, "5 mile run");
        post1.setWorkout(workout1);

        postWorkoutVi.check(ViewAssertions.matches(ViewMatchers.withText(workout1.toString())));

        //create post screen, check to see of default text for caption is there
        //enter new caption
        postCapEdVi.perform(ViewActions.replaceText("A fun workout"));
        onView(ViewMatchers.isRoot()).perform(ViewActions.closeSoftKeyboard());

        //click the caption button and checks to see that the caption text has changed
        captionButtonVi.perform(ViewActions.click());
        postCaptionVi.check(ViewAssertions.matches(ViewMatchers.withText("A fun workout")));
        post1.addCaption("A fun workout");

        // clicks on the post button
        postButtonVi.perform(ViewActions.click());

        //Clicks filter button
        ViewInteraction filterButtonVi = onView(withId(R.id.FeedFilter));
        filterButtonVi.perform(ViewActions.click());


        //enters the difficulty filter
        ViewInteraction filterDifficultyVi = onView(withId(R.id.spinner));
        filterDifficultyVi.perform(ViewActions.click());
        onData(anything()).atPosition(3).perform(ViewActions.click());
        filterDifficultyVi.check(ViewAssertions.matches(ViewMatchers.withSpinnerText("3")));

        //Set filters
        onView(withId(R.id.FilterSet)).perform(ViewActions.click());

        //Check if only first post is shown
        onView(withId(R.id.Post1)).check(ViewAssertions.matches(ViewMatchers.withText(post.toString())));

        //Remove Filters and check if both posts are there
        onView(withId(R.id.RemoveFilter)).perform(ViewActions.click());
        onView(withId(R.id.Post1)).check(ViewAssertions.matches(ViewMatchers.withText(post.toString())));
        onView(withId(R.id.Post2)).check(ViewAssertions.matches(ViewMatchers.withText(post1.toString())));
    }
    /**
     * Adds two posts, and then specifies a length and difficulty filter that produces a feed with
     * only the desired length and difficulty
     */
    @Test
    public void FilterLengthAndDifficulty() {
        //create profile screen -> leaves default values and clicks create
        //creates a new Profile and sets the Username to default
        ViewInteraction createButtonVi = onView(withId(R.id.createButton));
        createButtonVi.perform(ViewActions.click());
        Profile profile = new Profile();
        profile.setUsername("Username");

        ViewInteraction post1Vi = onView(withId(R.id.Post1));
        post1Vi.check(ViewAssertions.matches(ViewMatchers.withText(R.string.Post1)));
        ViewInteraction addPostButtonVi = onView(withId(R.id.addButton));
        addPostButtonVi.perform(ViewActions.click());
        Post post = new Post(profile);
        Workout workout = new Workout();
        Feed f = new Feed();

        //create post screen, checks that default caption text is there
        ViewInteraction postCaptionVi = onView(withId(R.id.postCaption));
        postCaptionVi.check(ViewAssertions.matches(ViewMatchers.withText(R.string.postCaption)));

        // checks that the default workout text is there
        ViewInteraction postWorkoutVi = onView(withId(R.id.postWorkout));
        postWorkoutVi.check(ViewAssertions.matches(ViewMatchers.withText(workout.toString())));

        boolean[] attributes = new boolean[3];
        attributes[0] = true;
        workout = addWorkoutTests(1, workout, attributes, "4", 3, "5 mile run");
        post.setWorkout(workout);

        postWorkoutVi.check(ViewAssertions.matches(ViewMatchers.withText(workout.toString())));

        //create post screen, check to see of default text for caption is there
        //enter new caption
        ViewInteraction postCapEdVi = onView(withId(R.id.captionTextBox));
        postCapEdVi.check(ViewAssertions.matches(ViewMatchers.withText(R.string.captionTextBox)));
        postCapEdVi.perform(ViewActions.replaceText("A fun workout"));
        onView(ViewMatchers.isRoot()).perform(ViewActions.closeSoftKeyboard());

        //click the caption button and checks to see that the caption text has changed
        ViewInteraction captionButtonVi = onView(withId(R.id.captionButton));
        captionButtonVi.perform(ViewActions.click());
        postCaptionVi.check(ViewAssertions.matches(ViewMatchers.withText("A fun workout")));
        post.addCaption("A fun workout");

        // clicks on the post button
        ViewInteraction postButtonVi = onView(withId(R.id.postButton));
        postButtonVi.perform(ViewActions.click());

        //checks to see if the post1 text in the feed is the same as the post that was just created
        post1Vi = onView(withId(R.id.Post1));
        post1Vi.check(ViewAssertions.matches(ViewMatchers.withText(post.toString())));

        // START OF SECOND POST

        //Feed screen, checks that Post1 has the default text, clicks on the add post button
        ViewInteraction post2Vi = onView(withId(R.id.Post2));
        post2Vi.check(ViewAssertions.matches(ViewMatchers.withText(R.string.Post2)));
        addPostButtonVi.perform(ViewActions.click());
        Post post1 = new Post(profile);
        Workout workout1 = new Workout();

        boolean[] attributes1 = new boolean[4];
        attributes[0] = true;
        attributes[2] = true;
        workout1 = addWorkoutTests(2, workout1, attributes1, "5", 5, "5 mile run");
        post1.setWorkout(workout1);

        postWorkoutVi.check(ViewAssertions.matches(ViewMatchers.withText(workout1.toString())));

        //create post screen, check to see of default text for caption is there
        //enter new caption
        postCapEdVi.perform(ViewActions.replaceText("A fun workout"));
        onView(ViewMatchers.isRoot()).perform(ViewActions.closeSoftKeyboard());

        //click the caption button and checks to see that the caption text has changed
        captionButtonVi.perform(ViewActions.click());
        postCaptionVi.check(ViewAssertions.matches(ViewMatchers.withText("A fun workout")));
        post1.addCaption("A fun workout");

        // clicks on the post button
        postButtonVi.perform(ViewActions.click());

        //Clicks filter button
        ViewInteraction filterButtonVi = onView(withId(R.id.FeedFilter));
        filterButtonVi.perform(ViewActions.click());

        //Enter length filter
        ViewInteraction filterLengthVi = onView(withId(R.id.LengthInput));
        filterLengthVi.perform(ViewActions.typeText("4"));
        onView(ViewMatchers.isRoot()).perform(ViewActions.closeSoftKeyboard());

        //enters the difficulty filter
        ViewInteraction filterDifficultyVi = onView(withId(R.id.spinner));
        filterDifficultyVi.perform(ViewActions.click());
        onData(anything()).atPosition(3).perform(ViewActions.click());
        filterDifficultyVi.check(ViewAssertions.matches(ViewMatchers.withSpinnerText("3")));

        //Set filters
        onView(withId(R.id.FilterSet)).perform(ViewActions.click());

        //Check if only first post is shown
        onView(withId(R.id.Post1)).check(ViewAssertions.matches(ViewMatchers.withText(post.toString())));

        //Remove Filters and check if both posts are there
        onView(withId(R.id.RemoveFilter)).perform(ViewActions.click());
        onView(withId(R.id.Post1)).check(ViewAssertions.matches(ViewMatchers.withText(post.toString())));
        onView(withId(R.id.Post2)).check(ViewAssertions.matches(ViewMatchers.withText(post1.toString())));
    }

    /**
     * Test to make sure that the snackbar will pop up
     * when length is left empty
     */
    @Test
    public void testFilterSnackbar() {
        Profile profile = createProfile();

        ViewInteraction feedVi = Espresso.onView(ViewMatchers.withId(R.id.FeedFilter));
        feedVi.perform(ViewActions.click());

        //Enter a blank length input
        ViewInteraction lengthVi = Espresso.onView(ViewMatchers.withId(R.id.LengthInput));
        lengthVi.perform(ViewActions.replaceText(""));
        ViewInteraction setButtonVi = Espresso.onView(ViewMatchers.withId(R.id.FilterSet));
        setButtonVi.perform(ViewActions.click());

        //the snackbar matcher
        Matcher<View> snackbarMatcher = ViewMatchers.withText("Input for length mandatory!");
        ViewInteraction snackBarVi = Espresso.onView(snackbarMatcher);
        snackBarVi.check(ViewAssertions.matches(snackbarMatcher));


        //Test for a non-numeric input
        lengthVi.perform(ViewActions.replaceText("This shouldn't be here"));
        setButtonVi.perform(ViewActions.click());

        //the snackbar matcher
        snackbarMatcher = ViewMatchers.withText("Please enter a number for length");
        snackBarVi = Espresso.onView(snackbarMatcher);
        snackBarVi.check(ViewAssertions.matches(snackbarMatcher));


    }

}
