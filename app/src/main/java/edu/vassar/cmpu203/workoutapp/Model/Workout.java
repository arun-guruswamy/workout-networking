package edu.vassar.cmpu203.workoutapp.Model;

public class Workout {
    public int length;
    public int difficulty;
    public String workout;
    protected String sportFocus;

    public void createWorkout(String description) {
        this.workout = description;
    }

    //public void setSport(String sport) { this.sportFocus = sport;}

    public void setLength(int length) {
        this.length = length;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

   // public boolean setAttribute(String name) {
     //  boolean attribute = false;
       // String a = scan.next();
        //if (a.equalsIgnoreCase("yes"))
          //  attribute = true;
        //return attribute;
    //}

   // abstract void setSpecificAttributes();

    public String toString() {
        return this.workout + "\n" + this.length + "\n" + this.difficulty;
    }
}
