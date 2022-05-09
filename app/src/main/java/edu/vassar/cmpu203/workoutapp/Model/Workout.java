package edu.vassar.cmpu203.workoutapp.Model;

import java.io.Serializable;

public class Workout implements Serializable {
    public int length = 0;
    public int difficulty = 0;
    public String description = "";
    protected String sportFocus;
    int workoutType;

    public Workout() {}

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSport(String sport) { this.sportFocus = sport;}

    public void setLength(int length) {
        this.length = length;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public void setType(int type) { workoutType = type; }


   // public boolean setAttribute(String name) {
     //  boolean attribute = false;
       // String a = scan.next();
        //if (a.equalsIgnoreCase("yes"))
          //  attribute = true;
        //return attribute;
    //}

   // abstract void setSpecificAttributes();

    public String toString() {
        return this.description + "\n" + this.length + "\n" + this.difficulty;
    }

/*
    public String toString() {
        if (this.workoutType == 1){
            return Cardio.class.toString();
        }
        else if (this.workoutType == 2){
            return Strength.class.toString();
        }
        else if (this.workoutType == 3){
            return Mobility.class.toString();
        }
        else
            return this.description + "\n" + this.length + "\n" + this.difficulty;
    }
*/

    public int getDifficulty() {
        return difficulty;
    }
    public int getLength() {return this.length;}
    public String getDescription(){return this.description;}
    public String getSportFocus(){return this.sportFocus;}

    public int getWorkoutType() {
        return workoutType;
    }
}
