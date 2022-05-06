package edu.vassar.cmpu203.workoutapp.Model;

import java.io.Serializable;

public class Post implements Serializable {

    private String prod_id;
    private String caption;
    private int WRKnum;
    private int CAPnum;
    public Workout workout;

    public Post(){}

    public Post(Profile profile) {
        this.prod_id = profile.getUsername();
        WRKnum = 0;
        CAPnum = 0;
    }

//    public Workout addWorkout(String type) {
//        Workout w;
//
//            if (type.equalsIgnoreCase("cardio"))
//                w = new Cardio();
//            else
//                w = new Strength();
//        this.workout = w;
//        this.WRKnum = 1;
//
//        return w;
//    }


    public void setWorkout(Workout workout){
        this.workout = workout;
        this.WRKnum = 1;
    }

    public void addCaption(String caption) {
        this.caption = caption;
        this.CAPnum = 1;
    }

    void addWorkoutDescription(Workout w, String description) {
        w.setDescription(description);
    }

    void addWorkoutLength(Workout w, int length) {
        w.setLength(length);
    }

    void addWorkoutDifficulty(Workout w, int difficulty) {
        w.setDifficulty(difficulty);
    }

    // void addWorkoutSport(Workout w, String s) { w.setSport(s); }


    public String toString() {
        return "\nWorkout: " + workout + "\n\n" + caption;
    }

    public int getCAPnum() {
        return CAPnum;
    }

    public int getWRKnum() {
        return WRKnum;
    }

    public String getProd_id() {
        return prod_id;
    }

    public String getCaption() {
        return caption;
    }

    public Workout getWorkout() {
          return workout;
    }


}
