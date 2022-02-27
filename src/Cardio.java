import java.util.*;

public class Cardio extends Workout {
    boolean EnduranceFocus;
    boolean AgilityFocus;
    boolean SpeedFocus;

    public void setAllAttributes() {
        EnduranceFocus = setAttribute("Endurance");
        AgilityFocus = setAttribute( "Agility");
        SpeedFocus = setAttribute( "Speed");
    }

    public String toString() {
        return workout + "\n\n" + "Workout attributes:" + "\nEndurance Focus: " + EnduranceFocus
                + "\nAgility Focus: " + AgilityFocus + "\nSpeed Focus: " + SpeedFocus;
    }

}
