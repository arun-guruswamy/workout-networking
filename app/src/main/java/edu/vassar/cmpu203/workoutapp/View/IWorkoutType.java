package edu.vassar.cmpu203.workoutapp.View;


import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

public interface IWorkoutType {


    interface Listener{
        void onAddedAttributes(boolean[] Attributes, int workoutType);
    }
}
