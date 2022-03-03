import java.util.Scanner;

public abstract class Workout {
    int length;
    int difficulty;
    String workout;

    public void createWorkout(String description) {
        workout = description;
    }

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

    abstract public String toString();
}
