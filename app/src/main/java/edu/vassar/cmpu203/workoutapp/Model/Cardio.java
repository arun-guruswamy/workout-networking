package edu.vassar.cmpu203.workoutapp.Model;

public class Cardio extends Workout {
    private boolean EnduranceFocus = false;
    private boolean AgilityFocus = false;
    private boolean SpeedFocus = false;

    public Cardio() {}

    public Cardio(boolean[] Attributes) {
        AgilityFocus = Attributes[0];
        EnduranceFocus = Attributes[1];
        SpeedFocus = Attributes[2];
    }

    public void setAgilityFocus(boolean agilityFocus) {
        AgilityFocus = agilityFocus;
    }

    public void setEnduranceFocus(boolean enduranceFocus) {
        EnduranceFocus = enduranceFocus;
    }

    public void setSpeedFocus(boolean speedFocus) {
        SpeedFocus = speedFocus;
    }

    public String toString() {
        return workout + "\n\n" + "Length: " + this.length + ", Difficulty: " + this.difficulty + "\nEndurance Focus: " + EnduranceFocus
                + "\nAgility Focus: " + AgilityFocus + "\nSpeed Focus: " + SpeedFocus;
    }

}
