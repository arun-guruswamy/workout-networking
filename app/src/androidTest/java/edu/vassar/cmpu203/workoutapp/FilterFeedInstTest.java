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


public class FilterFeedInstTest {
    @org.junit.Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    /**
     * testing the values of the Create profile screen and checks to make sure that
     * we can input new information without crashing the app
     */
    @Test
    public void FilterPosts() {
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

        ViewInteraction addWorkoutButtonVi = onView((withId(R.id.addWorkoutButton)));
        addWorkoutButtonVi.perform(ViewActions.click());

        ViewInteraction cardioButtonVi = onView(withId(R.id.button2));
        cardioButtonVi.perform(ViewActions.click());

        //cardio screen, clicks on the agility radio button
        ViewInteraction agilityVi = onView(withId(R.id.radioButton3));
        agilityVi.perform(ViewActions.click());

        //clicks on the set button
        ViewInteraction setVi = onView(withId(R.id.button3));
        setVi.perform(ViewActions.click());
        boolean[] values = new boolean[3];
        values[0] = true;
        workout = new Cardio(values);

        //create workout screen, enters the workout length
        ViewInteraction lengthVi = onView(withId(R.id.editTextTextPersonName));
        lengthVi.perform(ViewActions.typeText("5"));
        onView(ViewMatchers.isRoot()).perform(ViewActions.closeSoftKeyboard());
        workout.setLength(5);

        //enters the workout difficulty
        ViewInteraction difficultyVi = onView(withId(R.id.seekBar2));
        difficultyVi.perform(ViewActions.swipeRight());
        workout.setDifficulty(5);

        //checks that the default description is present
        ViewInteraction workoutDescriptionVi = onView(withId(R.id.editTextTextPersonName4));
        workoutDescriptionVi.check(ViewAssertions.matches(ViewMatchers.withText(R.string.input_workout)));

        //enters a new description
        workoutDescriptionVi.perform(ViewActions.replaceText("Five mile run"));
        onView(ViewMatchers.isRoot()).perform(ViewActions.closeSoftKeyboard());
        workout.setDescription("Five mile run");

        // clicks on the create workout button
        ViewInteraction createWorkoutButtonVi = onView(withId(R.id.button6));
        createWorkoutButtonVi.perform(ViewActions.click());
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
        Workout workout1;

        addWorkoutButtonVi.perform(ViewActions.click());

        //click on the strength button
        ViewInteraction strengthButtonVi = onView(withId(R.id.button));
        strengthButtonVi.perform(ViewActions.click());

        //click on multiple radio buttons
        ViewInteraction upperBodyButtonVi = onView(withId(R.id.radioButton3));
        upperBodyButtonVi.perform(ViewActions.click());
        ViewInteraction bodyweightButtonVi = onView(withId(R.id.radioButton5));
        bodyweightButtonVi.perform(ViewActions.click());
        ViewInteraction setButton = onView(withId(R.id.button3));
        setButton.perform(ViewActions.click());
        boolean[] values1 = new boolean[4];
        values1[0] = true;
        values1[2] = true;
        workout1 = new Strength(values1);

        //create workout screen, enters the workout length
        lengthVi.perform(ViewActions.replaceText("3"));
        onView(ViewMatchers.isRoot()).perform(ViewActions.closeSoftKeyboard());
        workout1.setLength(3);

        //enters the workout difficulty
        difficultyVi.perform(ViewActions.swipeRight());
        workout1.setDifficulty(5);


        //enters a new description
        workoutDescriptionVi.perform(ViewActions.replaceText("Five mile run"));
        workout1.setDescription("Five mile run");

        // clicks on the create workout button
        createWorkoutButtonVi.perform(ViewActions.click());
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

        //enters the difficulty filter
        ViewInteraction filterDifficultyVi = onView(withId(R.id.spinner));
        filterDifficultyVi.perform(ViewActions.click());
        onData(anything()).atPosition(5).perform(ViewActions.click());
        filterDifficultyVi.check(ViewAssertions.matches(ViewMatchers.withSpinnerText("5")));

        //Set filters
        onView(withId(R.id.FilterSet)).perform(ViewActions.click());

        //Check if only second post is shown
        onView(withId(R.id.Post1)).check(ViewAssertions.matches(ViewMatchers.withText(post1.toString())));




    }
}
