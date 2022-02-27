import java.util.*;

public class Cardio extends Workout {
    Boolean EnduranceFocus;
    Boolean AgilityFocus;
    Boolean SpeedFocus;

    public void setAllAttributes() {
        setAttribute(EnduranceFocus, "Endurance");
        setAttribute(AgilityFocus, "Agility");
        setAttribute(SpeedFocus, "Speed");
    }

    public String toString() {
        return workout + "\n\n" + "Workout attributes:" + "\n Endurance Focus: " + EnduranceFocus
                + "\n Agility Focus: " + AgilityFocus + "\n SpeedFocus: " + SpeedFocus;
    }

}
