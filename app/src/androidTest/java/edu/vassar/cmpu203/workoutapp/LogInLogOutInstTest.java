package edu.vassar.cmpu203.workoutapp;

import android.os.SystemClock;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import edu.vassar.cmpu203.workoutapp.Controller.MainActivity;
import edu.vassar.cmpu203.workoutapp.Model.Profile;

@RunWith(AndroidJUnit4.class)
public class LogInLogOutInstTest extends AddMiscThings {

    @org.junit.Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void logTest() {
        //Step 1:
        // create an account
        // go to profile
        // log out
        // show successful logout snackbar

        Profile profile = createProfile("tester1", "1", "hi");
        SystemClock.sleep(5000);

        ViewInteraction profileButton = Espresso.onView(ViewMatchers.withId(R.id.ViewProfileButton));
        profileButton.perform(ViewActions.click());

        ViewInteraction logoutButton = Espresso.onView(ViewMatchers.withId(R.id.LogoutButton));
        logoutButton.perform(ViewActions.click());


        //Step 2:
        // log in, show that it works, successful login snackbar
        // log out
        //Step 3:
        // log in with wrong username
        // log in with wrong password
        // log in with only password
        // log in with only username
        // log in with neither
        // show snackbars for all

        //DONE!
    }


}
