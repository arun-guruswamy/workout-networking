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

        Matcher<View> snackbarMatcher0 = ViewMatchers.withText("Logout successful");
        ViewInteraction snackBarVi0 = Espresso.onView(snackbarMatcher0);
        snackBarVi0.check(ViewAssertions.matches(snackbarMatcher0));

        SystemClock.sleep(5000);

        //Step 2:
        // log in, show that it works, successful login snackbar
        ViewInteraction userInput = Espresso.onView(ViewMatchers.withId(R.id.usernameField));
        userInput.perform(ViewActions.replaceText(profile.getUsername()));

        ViewInteraction passInput = Espresso.onView(ViewMatchers.withId(R.id.passwordField));
        passInput.perform(ViewActions.replaceText("1"));

        ViewInteraction logInButton = Espresso.onView(ViewMatchers.withId(R.id.logInButton));
        logInButton.perform(ViewActions.click());

        Matcher<View> snackbarMatcher1 = ViewMatchers.withText(R.string.login);
        ViewInteraction snackBarVi1 = Espresso.onView(snackbarMatcher1);
        snackBarVi1.check(ViewAssertions.matches(snackbarMatcher1));

        SystemClock.sleep(5000);

        // log out
        profileButton.perform(ViewActions.click());
        logoutButton.perform(ViewActions.click());

        //Step 3:
        // log in with wrong username
        userInput.perform(ViewActions.replaceText("ajjd"));
        passInput.perform(ViewActions.replaceText("1"));
        logInButton.perform(ViewActions.click());

        Matcher<View> snackbarMatcher2 = ViewMatchers.withText(R.string.invalidCredentials);
        ViewInteraction snackBarVi2 = Espresso.onView(snackbarMatcher2);
        snackBarVi2.check(ViewAssertions.matches(snackbarMatcher2));

        SystemClock.sleep(5000);

        // log in with wrong password
        userInput.perform(ViewActions.replaceText(profile.getUsername()));
        passInput.perform(ViewActions.replaceText("jdjsfd"));
        logInButton.perform(ViewActions.click());
        snackBarVi2.check(ViewAssertions.matches(snackbarMatcher2));
        SystemClock.sleep(5000);

        // log in with only password
        userInput.perform(ViewActions.replaceText(""));
        passInput.perform(ViewActions.replaceText("1"));
        logInButton.perform(ViewActions.click());
        Matcher<View> snackbarMatcher3 = ViewMatchers.withText("Please enter both your username and password");
        ViewInteraction snackBarVi3 = Espresso.onView(snackbarMatcher3);
        snackBarVi3.check(ViewAssertions.matches(snackbarMatcher3));

        SystemClock.sleep(5000);

        // log in with only username
        userInput.perform(ViewActions.replaceText(profile.getUsername()));
        passInput.perform(ViewActions.replaceText(""));
        logInButton.perform(ViewActions.click());
        snackBarVi3.check(ViewAssertions.matches(snackbarMatcher3));
        SystemClock.sleep(5000);

        // log in with neither
        userInput.perform(ViewActions.replaceText(""));
        passInput.perform(ViewActions.replaceText(""));
        logInButton.perform(ViewActions.click());
        snackBarVi3.check(ViewAssertions.matches(snackbarMatcher3));
        SystemClock.sleep(5000);

        //DONE!
        this.persistenceFacade.removeUser(profile);
    }


}
