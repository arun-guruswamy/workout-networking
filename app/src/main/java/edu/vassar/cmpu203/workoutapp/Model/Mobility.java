package edu.vassar.cmpu203.workoutapp.Model;

public class Mobility extends Workout{
    private boolean StaticStretching = false;
    private boolean DynamicStretching = false;
    private boolean Yoga = false;

    public Mobility() {}

    public Mobility(boolean[] Attributes) {
        StaticStretching = Attributes[0];
        DynamicStretching = Attributes[1];
        Yoga = Attributes[2];
    }

    public void setStaticFocus(boolean staticStretching) {
        StaticStretching = staticStretching;
    }

    public void setDynamicFocus(boolean dynamicStretching) { DynamicStretching = dynamicStretching; }

    public void setYogaFocus(boolean yoga) {
        Yoga = yoga;
    }

    public String toString() {
        return description + "\n\n" + "Length: " + this.length + ", Difficulty: " + this.difficulty + ", Sport Focus: " + this.sportFocus + "\nStatic Stretching Focus: " + StaticStretching
                + "\nDynamic Stretching: " + DynamicStretching + "\nYoga: " + Yoga;
    }
}
