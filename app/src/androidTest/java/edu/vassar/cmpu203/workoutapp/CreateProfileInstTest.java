package edu.vassar.cmpu203.workoutapp;

import android.os.SystemClock;
import android.view.View;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;

import edu.vassar.cmpu203.workoutapp.Controller.MainActivity;
import edu.vassar.cmpu203.workoutapp.Model.Profile;

@RunWith(AndroidJUnit4.class)
public class CreateProfileInstTest {
    @org.junit.Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    /**
     * testing the values of the Create profile screen and checks to make sure that
     * we can input new information without crashing the app
     */
    @Test
    public void createProfileTest() {

        //checks the username default text and type in a new username
        ViewInteraction usernameVi = Espresso.onView(ViewMatchers.withId(R.id.UsernameText));
        usernameVi.check(ViewAssertions.matches(ViewMatchers.withText(R.string.usernameText)));
        usernameVi.perform(ViewActions.replaceText("ymi456"));

        //checks the password default text and types in password
        ViewInteraction passwordVi = Espresso.onView(ViewMatchers.withId(R.id.passwordEditText));
        passwordVi.check(ViewAssertions.matches(ViewMatchers.withText(R.string.passText)));
        passwordVi.perform((ViewActions.replaceText("abcdefg123!!")));

        // checks the bio default text and type new bio
        ViewInteraction bioVi = Espresso.onView(ViewMatchers.withId(R.id.bioEditText));
        bioVi.check(ViewAssertions.matches(ViewMatchers.withText(R.string.bioEdit)));
        bioVi.perform(ViewActions.replaceText("I love to workout"));

        //click the create button to make sure that we can get to the new screen
        ViewInteraction createButtonVi = Espresso.onView(ViewMatchers.withId(R.id.createButton));
        createButtonVi.perform(ViewActions.click());

//        Profile profile = new Profile();
//        profile.setUsername("ymi456");
//        profile.setPassword("abcdefg123!!");
//        profile.setBio("I love to workout");
//        return profile;
    }

    /**
     * Test to make sure that the snackbar will pop up
     * when all the needed data is not entered
     */
    @Test
    public void testSnackbar() {
        //Enter a blank username but has a password and a bio
        ViewInteraction usernameVi = Espresso.onView(ViewMatchers.withId(R.id.UsernameText));
        usernameVi.perform(ViewActions.replaceText(""));
        ViewInteraction createButtonVi = Espresso.onView(ViewMatchers.withId(R.id.createButton));
        createButtonVi.perform(ViewActions.click());

        //the snackbar matcher
        Matcher<View> snackbarMatcher = ViewMatchers.withText("Username, password, and bio are mandatory!");
       ViewInteraction snackBarVi = Espresso.onView(snackbarMatcher);
       snackBarVi.check(ViewAssertions.matches(snackbarMatcher));

       //sleep between each test so that the snackbar will go away
       SystemClock.sleep(3500);

       //Have entered a bio and username but no password
        ViewInteraction bioVi = Espresso.onView(ViewMatchers.withId(R.id.bioEditText));
        bioVi.perform(ViewActions.replaceText("Bio"));
        ViewInteraction passwordVi = Espresso.onView(ViewMatchers.withId(R.id.passwordEditText));
        passwordVi.perform((ViewActions.replaceText("")));
        usernameVi.perform(ViewActions.replaceText("Username"));
        createButtonVi.perform(ViewActions.click());

        snackBarVi.check(ViewAssertions.matches(snackbarMatcher));

        SystemClock.sleep(3500);

        //entered user name and password but no bio
        bioVi.perform(ViewActions.replaceText(""));
        passwordVi.perform(ViewActions.replaceText("password"));
        usernameVi.perform(ViewActions.replaceText("Username"));
        createButtonVi.perform(ViewActions.click());
        snackBarVi.check(ViewAssertions.matches(snackbarMatcher));

        SystemClock.sleep(3500);

        //did not enter any of the required data
        createButtonVi.perform(ViewActions.click());
        snackBarVi.check(ViewAssertions.matches(snackbarMatcher));

        SystemClock.sleep(3500);

        //entered just a password
        passwordVi.perform(ViewActions.replaceText("password"));
        createButtonVi.perform(ViewActions.click());
        snackBarVi.check(ViewAssertions.matches(snackbarMatcher));

        SystemClock.sleep(3500);

        //only entered a username
        usernameVi.perform(ViewActions.replaceText("Username"));
        createButtonVi.perform(ViewActions.click());
        snackBarVi.check(ViewAssertions.matches(snackbarMatcher));

        SystemClock.sleep(3500);

        //only entered a username
        bioVi.perform(ViewActions.replaceText("Bio"));
        createButtonVi.perform(ViewActions.click());
        snackBarVi.check(ViewAssertions.matches(snackbarMatcher));


    }
}
