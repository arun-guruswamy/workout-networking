package edu.vassar.cmpu203.workoutapp.Controller;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;

import edu.vassar.cmpu203.workoutapp.View.AddWorkoutFragment;
import edu.vassar.cmpu203.workoutapp.View.CardioFragment;
import edu.vassar.cmpu203.workoutapp.View.StrengthFragment;
import edu.vassar.cmpu203.workoutapp.Model.*;
import edu.vassar.cmpu203.workoutapp.View.CardioFragment;
import edu.vassar.cmpu203.workoutapp.View.CreateProfileFragment;
import edu.vassar.cmpu203.workoutapp.View.Create_Post_Fragment;
import edu.vassar.cmpu203.workoutapp.View.FeedFragment;
import edu.vassar.cmpu203.workoutapp.View.FilterFragment;
import edu.vassar.cmpu203.workoutapp.View.HomeScreenFragment;
import edu.vassar.cmpu203.workoutapp.View.MobilityFragment;
import edu.vassar.cmpu203.workoutapp.View.StrengthFragment;
import edu.vassar.cmpu203.workoutapp.View.ViewProfileFragment;

public class WorkoutAppFragFactory extends FragmentFactory {

    private MainActivity controller;

    public WorkoutAppFragFactory(MainActivity controller) {
        this.controller = controller;
    }

//    @NonNull
//    @Override
//    public Fragment instantiate(@NonNull ClassLoader classLoader, @NonNull String className){
//
//        Class<? extends Fragment> fragClass = loadFragmentClass(classLoader, className);
//
//        if(fragClass == AddWorkoutFragment.class)
//            return new AddWorkoutFragment(controller);
//        if(fragClass == FeedFragment.class)
//            return new FeedFragment(controller);
//        if(fragClass == Create_Post_Fragment.class)
//            return new Create_Post_Fragment(controller);
//''      if(fragClass == FilterFragment.class)
//            return new FilterFragment(controller);
//        if(fragClass == HomeScreenFragment.class)
//            return new HomeScreenFragment(controller);
//        if(fragClass == CreateProfileFragment.class)
//            return new CreateProfileFragment(controller);
//        if(fragClass == CardioFragment.class)
//            return new CardioFragment(controller);
//        if(fragClass == StrengthFragment.class)
//            return new StrengthFragment(controller);
//        if(fragClass == MobilityFragment.class)
//            return new MobilityFragment(controller);
//        if(fragClass == ViewProfileFragment.class)
//            return new ViewProfileFragment(controller);
//    }

}
