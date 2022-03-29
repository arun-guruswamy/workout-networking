package edu.vassar.cmpu203.workoutapp.View;
import android.view.View;
import androidx.fragment.app.Fragment;

public interface IMainView {

    public View getRootView();
    public void displayFragment(Fragment fragment, boolean allowBack);
}
