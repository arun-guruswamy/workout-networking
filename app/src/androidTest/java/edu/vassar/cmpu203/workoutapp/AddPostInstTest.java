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
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.hamcrest.Matcher;
import org.junit.Test;
import org.junit.runner.RunWith;

import edu.vassar.cmpu203.workoutapp.Controller.MainActivity;
import edu.vassar.cmpu203.workoutapp.Model.Cardio;
import edu.vassar.cmpu203.workoutapp.Model.Post;
import edu.vassar.cmpu203.workoutapp.Model.Profile;
import edu.vassar.cmpu203.workoutapp.Model.Strength;
import edu.vassar.cmpu203.workoutapp.Model.Workout;

@RunWith(AndroidJUnit4.class)
public class AddPostInstTest extends AddMiscThings {

    @org.junit.Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    /**
     * Test to see if someone is able to post with a Cardio Workout
     * while creating a post to compare the results of the app too
     */
    @Test
    public void addCardioPostTest() {
        //create profile screen -> leaves default values and clicks create
        //creates a new Profile and sets the Username to default
        Profile profile = createProfile();


        //Feed screen, checks that Post1 has the default text, clicks on the add post button
        ViewInteraction post1Vi = Espresso.onView(ViewMatchers.withId(R.id.Post1));
        post1Vi.check(ViewAssertions.matches(ViewMatchers.withText(R.string.Post1)));
        ViewInteraction addPostButtonVi = Espresso.onView(ViewMatchers.withId(R.id.addButton));
        addPostButtonVi.perform(ViewActions.click());
        Post post = new Post(profile);
        Workout workout = new Workout();

        //create post screen, checks that default caption text is there
        ViewInteraction postCaptionVi = Espresso.onView(ViewMatchers.withId(R.id.postCaption));
        postCaptionVi.check(ViewAssertions.matches(ViewMatchers.withText(R.string.postCaption)));

        // checks that the default workout text is there
        ViewInteraction postWorkoutVi = Espresso.onView(ViewMatchers.withId(R.id.postWorkout));
        postWorkoutVi.check(ViewAssertions.matches(ViewMatchers.withText(workout.toString())));

        //create the values for the workout to be passed
        boolean[] values = new boolean[3];
        values[0] = true;

        //create and add the workout
        workout = addWorkoutTests(1, workout,values,"50",3,"A hard workout");
        post.setWorkout(workout);

        postWorkoutVi.check(ViewAssertions.matches(ViewMatchers.withText(workout.toString())));

        //create post screen, check to see of default text for caption is there
        //enter new caption
        ViewInteraction postCapEdVi = Espresso.onView(ViewMatchers.withId(R.id.captionTextBox));
        postCapEdVi.check(ViewAssertions.matches(ViewMatchers.withText(R.string.captionTextBox)));
        postCapEdVi.perform(ViewActions.replaceText("A fun workout"));

        //click the caption button and checks to see that the caption text has changed
        ViewInteraction captionButtonVi = Espresso.onView(ViewMatchers.withId(R.id.captionButton));
        captionButtonVi.perform(ViewActions.click());
        postCaptionVi.check(ViewAssertions.matches(ViewMatchers.withText("A fun workout")));
        post.addCaption("A fun workout");

        // clicks on the post button
        ViewInteraction postButtonVi = Espresso.onView(ViewMatchers.withId(R.id.postButton));
        postButtonVi.perform(ViewActions.click());

        //checks to see if the post1 text in the feed is the same as the post that was just created
        post1Vi.check(ViewAssertions.matches(ViewMatchers.withText(post.toString())));

    }

    @Test
    public void addStrengthPostTest() {
        //create profile screen -> leaves default values and clicks create
        //creates a new Profile and sets the Username to default
        Profile profile = createProfile();


        //Feed screen, checks that Post1 has the default text, clicks on the add post button
        ViewInteraction post1Vi = Espresso.onView(ViewMatchers.withId(R.id.Post1));
        post1Vi.check(ViewAssertions.matches(ViewMatchers.withText(R.string.Post1)));
        ViewInteraction addPostButtonVi = Espresso.onView(ViewMatchers.withId(R.id.addButton));
        addPostButtonVi.perform(ViewActions.click());
        Post post = new Post(profile);
        Workout workout = new Workout();

        //create post screen, checks that default caption text is there
        ViewInteraction postCaptionVi = Espresso.onView(ViewMatchers.withId(R.id.postCaption));
        postCaptionVi.check(ViewAssertions.matches(ViewMatchers.withText(R.string.postCaption)));

        // checks that the default workout text is there
        ViewInteraction postWorkoutVi = Espresso.onView(ViewMatchers.withId(R.id.postWorkout));
        postWorkoutVi.check(ViewAssertions.matches(ViewMatchers.withText(workout.toString())));

        boolean[] values = new boolean[4];
        values[0] = true;
        values[2] = true;

        workout = addWorkoutTests(2, workout,values,"20",4,"pushups and what not");
        post.setWorkout(workout);

        postWorkoutVi.check(ViewAssertions.matches(ViewMatchers.withText(workout.toString())));

        //create post screen, check to see of default text for caption is there
        //enter new caption
        ViewInteraction postCapEdVi = Espresso.onView(ViewMatchers.withId(R.id.captionTextBox));
        postCapEdVi.check(ViewAssertions.matches(ViewMatchers.withText(R.string.captionTextBox)));
        postCapEdVi.perform(ViewActions.replaceText("A fun workout"));

        //click the caption button and checks to see that the caption text has changed
        ViewInteraction captionButtonVi = Espresso.onView(ViewMatchers.withId(R.id.captionButton));
        captionButtonVi.perform(ViewActions.click());
        postCaptionVi.check(ViewAssertions.matches(ViewMatchers.withText("A fun workout")));
        post.addCaption("A fun workout");

        // clicks on the post button
        ViewInteraction postButtonVi = Espresso.onView(ViewMatchers.withId(R.id.postButton));
        postButtonVi.perform(ViewActions.click());

        //checks to see if the post1 text in the feed is the same as the post that was just created
        post1Vi.check(ViewAssertions.matches(ViewMatchers.withText(post.toString())));

    }

    @Test
    public void addMultiplePostsTest() {
        //create profile screen -> leaves default values and clicks create
        //creates a new Profile and sets the Username to default
        Profile profile = createProfile();

        ViewInteraction post1Vi = Espresso.onView(ViewMatchers.withId(R.id.Post1));
        post1Vi.check(ViewAssertions.matches(ViewMatchers.withText(R.string.Post1)));
        ViewInteraction addPostButtonVi = Espresso.onView(ViewMatchers.withId(R.id.addButton));
        addPostButtonVi.perform(ViewActions.click());
        Post post = new Post(profile);
        Workout workout = new Workout();

        //create post screen, checks that default caption text is there
        ViewInteraction postCaptionVi = Espresso.onView(ViewMatchers.withId(R.id.postCaption));
        postCaptionVi.check(ViewAssertions.matches(ViewMatchers.withText(R.string.postCaption)));

        // checks that the default workout text is there
        ViewInteraction postWorkoutVi = Espresso.onView(ViewMatchers.withId(R.id.postWorkout));
        postWorkoutVi.check(ViewAssertions.matches(ViewMatchers.withText(workout.toString())));


        boolean[] values = new boolean[3];
        values[1] = true;
        values[2] = true;

        workout = addWorkoutTests(1, workout,values, "100", 1, "Five sprints");
        post.setWorkout(workout);

        postWorkoutVi.check(ViewAssertions.matches(ViewMatchers.withText(workout.toString())));

        //create post screen, check to see of default text for caption is there
        //enter new caption
        ViewInteraction postCapEdVi = Espresso.onView(ViewMatchers.withId(R.id.captionTextBox));
        postCapEdVi.check(ViewAssertions.matches(ViewMatchers.withText(R.string.captionTextBox)));
        postCapEdVi.perform(ViewActions.replaceText("Did some sprints today"));

        //click the caption button and checks to see that the caption text has changed
        ViewInteraction captionButtonVi = Espresso.onView(ViewMatchers.withId(R.id.captionButton));
        captionButtonVi.perform(ViewActions.click());
        postCaptionVi.check(ViewAssertions.matches(ViewMatchers.withText("Did some sprints today")));
        post.addCaption("Did some sprints today");

        // clicks on the post button
        ViewInteraction postButtonVi = Espresso.onView(ViewMatchers.withId(R.id.postButton));
        postButtonVi.perform(ViewActions.click());

        //checks to see if the post1 text in the feed is the same as the post that was just created
        post1Vi.check(ViewAssertions.matches(ViewMatchers.withText(post.toString())));

        // START OF SECOND POST

        //Feed screen, checks that Post1 has the default text, clicks on the add post button
        ViewInteraction post2Vi = Espresso.onView(ViewMatchers.withId(R.id.Post2));
        post2Vi.check(ViewAssertions.matches(ViewMatchers.withText(R.string.Post2)));
        addPostButtonVi.perform(ViewActions.click());
        Post post1 = new Post(profile);
        Workout workout1;

        boolean[] values1 = new boolean[4];
        values1[0] = true;
        values1[2] = true;
        workout1 = new Strength(values1);

        workout1 = addWorkoutTests(2, workout1, values1, "40", 2, "Lots and lots of push-ups");
        post1.setWorkout(workout1);

        postWorkoutVi.check(ViewAssertions.matches(ViewMatchers.withText(workout1.toString())));

        //create post screen, check to see of default text for caption is there
        //enter new caption
        postCapEdVi.perform(ViewActions.replaceText("My arms are sore"));

        //click the caption button and checks to see that the caption text has changed
        captionButtonVi.perform(ViewActions.click());
        postCaptionVi.check(ViewAssertions.matches(ViewMatchers.withText("My arms are sore")));
        post1.addCaption("My arms are sore");

        // clicks on the post button
        postButtonVi.perform(ViewActions.click());

        //checks to see if the post1 text in the feed is the same as the post that was just created
        post2Vi.check(ViewAssertions.matches(ViewMatchers.withText(post1.toString())));

        // START OF THIRD POST

        ViewInteraction post3Vi = Espresso.onView(ViewMatchers.withId(R.id.Post3));
        post3Vi.check(ViewAssertions.matches(ViewMatchers.withText(R.string.Post3)));
        addPostButtonVi.perform(ViewActions.click());
        Post post2 = new Post(profile);
        Workout workout2;

        boolean[] values2 = new boolean[4];
        values2[1] = true;
        values2[3] = true;
        workout2 = new Strength(values2);

        workout2 = addWorkoutTests(2, workout2, values2, "30", 4, "Some good weights and what not");
        post2.setWorkout(workout2);

        postWorkoutVi.check(ViewAssertions.matches(ViewMatchers.withText(workout2.toString())));

        //create post screen, check to see of default text for caption is there
        //enter new caption
        postCapEdVi.perform(ViewActions.replaceText("My arms are sore"));

        //click the caption button and checks to see that the caption text has changed
        captionButtonVi.perform(ViewActions.click());
        postCaptionVi.check(ViewAssertions.matches(ViewMatchers.withText("My arms are sore")));
        post2.addCaption("My arms are sore");

        // clicks on the post button
        postButtonVi.perform(ViewActions.click());

        //checks to see if the post1 text in the feed is the same as the post that was just created
        post3Vi.check(ViewAssertions.matches(ViewMatchers.withText(post2.toString())));
    }

    @Test
    public void addPostNoWorkoutTest() {
        ViewInteraction createButtonVi = Espresso.onView(ViewMatchers.withId(R.id.createButton));
        createButtonVi.perform(ViewActions.click());
        Profile profile = new Profile();
        profile.setUsername("Username");

        ViewInteraction post1Vi = Espresso.onView(ViewMatchers.withId(R.id.Post1));
        ViewInteraction addPostButtonVi = Espresso.onView(ViewMatchers.withId(R.id.addButton));
        addPostButtonVi.perform(ViewActions.click());
        Post post = new Post(profile);
        Workout workout = new Workout();

        ViewInteraction postCapEdVi = Espresso.onView(ViewMatchers.withId(R.id.captionTextBox));
        postCapEdVi.perform(ViewActions.replaceText("This is pretty chill"));
        ViewInteraction captionButtonVi = Espresso.onView(ViewMatchers.withId(R.id.captionButton));
        captionButtonVi.perform(ViewActions.click());
        post.addCaption("This is pretty chill");

        ViewInteraction postButtonVi = Espresso.onView(ViewMatchers.withId(R.id.postButton));
        postButtonVi.perform(ViewActions.click());

        post1Vi = Espresso.onView(ViewMatchers.withId(R.id.Post1));
        post1Vi.check(ViewAssertions.matches(ViewMatchers.withText(post.toString())));


    }

    @Test
    public void addPostNoCaption() {
        ViewInteraction createButtonVi = Espresso.onView(ViewMatchers.withId(R.id.createButton));
        createButtonVi.perform(ViewActions.click());
        Profile profile = new Profile();
        profile.setUsername("Username");

        ViewInteraction post1Vi = Espresso.onView(ViewMatchers.withId(R.id.Post1));
        ViewInteraction addPostButtonVi = Espresso.onView(ViewMatchers.withId(R.id.addButton));
        addPostButtonVi.perform(ViewActions.click());
        Post post = new Post(profile);
        Workout workout = new Workout();

        ViewInteraction postWorkoutVi = Espresso.onView(ViewMatchers.withId(R.id.postWorkout));
        postWorkoutVi.check(ViewAssertions.matches(ViewMatchers.withText(workout.toString())));

        ViewInteraction addWorkoutButtonVi = Espresso.onView((ViewMatchers.withId(R.id.addWorkoutButton)));
        addWorkoutButtonVi.perform(ViewActions.click());

        ViewInteraction cardioButtonVi = Espresso.onView(ViewMatchers.withId(R.id.button2));
        cardioButtonVi.perform(ViewActions.click());

        ViewInteraction enduranceButtonVi = Espresso.onView(ViewMatchers.withId(R.id.radioButton4));
        enduranceButtonVi.perform(ViewActions.click());
        ViewInteraction speedButtonVi = Espresso.onView(ViewMatchers.withId(R.id.radioButton5));
        speedButtonVi.perform(ViewActions.click());

        ViewInteraction setVi = Espresso.onView(ViewMatchers.withId(R.id.button3));
        setVi.perform(ViewActions.click());
        boolean[] values = new boolean[3];
        values[1] = true;
        values[2] =true;
        workout = new Cardio(values);

        ViewInteraction lengthVi = Espresso.onView(ViewMatchers.withId(R.id.editTextTextPersonName));
        lengthVi.perform(ViewActions.replaceText("100"));
        workout.setLength(100);

        ViewInteraction difficultyVi = Espresso.onView(ViewMatchers.withId(R.id.seekBar2));
        difficultyVi.perform(ViewActions.swipeRight());
        workout.setDifficulty(5);

        ViewInteraction workoutDescriptionVi = Espresso.onView(ViewMatchers.withId(R.id.editTextTextPersonName4));
        workoutDescriptionVi.perform(ViewActions.replaceText("A super hard sprint marathon"));
        workout.setDescription("A super hard sprint marathon");

        ViewInteraction createWorkoutButtonVi = Espresso.onView(ViewMatchers.withId(R.id.button6));
        createWorkoutButtonVi.perform(ViewActions.click());
        post.setWorkout(workout);

        postWorkoutVi.check(ViewAssertions.matches(ViewMatchers.withText(workout.toString())));

        ViewInteraction postButtonVi = Espresso.onView(ViewMatchers.withId(R.id.postButton));
        postButtonVi.perform(ViewActions.click());

        post1Vi = Espresso.onView(ViewMatchers.withId(R.id.Post1));
        post1Vi.check(ViewAssertions.matches(ViewMatchers.withText(post.toString())));

    }

    @Test
    public void testSnackBars(){

    }

}
