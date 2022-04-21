package edu.vassar.cmpu203.workoutapp.Controller;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;

import edu.vassar.cmpu203.workoutapp.View.AddWorkoutFragment;

public class WorkoutAppFragFactory extends FragmentFactory {

    private MainActivity controller;

    public WorkoutAppFragFactory(MainActivity controller) {
        this.controller = controller;
    }

   /* @NonNull
    @Override
    public Fragment instantiate(@NonNull ClassLoader classLoader, @NonNull String className){

        Class<? extends Fragment> fragClass = loadFragmentClass(classLoader, className);

        if(fragClass == AddWorkoutFragment.class)
            return new AddWorkoutFragment(controller);
    }*/

}
