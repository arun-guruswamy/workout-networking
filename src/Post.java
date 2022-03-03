public class Post {
    private String prod_id;
    String caption;
    int WRKnum;
    int CAPnum;
    Workout workout;

    public Post() {
        this.prod_id = "test";
        WRKnum = 0;
        CAPnum = 0;
    }

    public Workout addWorkout(String type) {
        Workout w;

            if (type.equalsIgnoreCase("cardio"))
                w = new Cardio();
            else
                w = new Strength();

        w.setSpecificAttributes();
        this.workout = w;

        this.WRKnum = 1;

        return w;
    }

    public void addCaption(String caption) {
        this.caption = caption;
        this.CAPnum = 1;
    }

    void addWorkoutDescription(Workout w, String description) {
        w.createWorkout(description);
    }

    void addWorkoutLength(Workout w, int length) {
        w.setLength(length);
    }

    void addWorkoutDifficulty(Workout w, int difficulty) {
        w.setDifficulty(difficulty);
    }

    public String toString() {
        return "\n" + this.prod_id + "\nWorkout: " + workout + "\n\n" + caption;
    }
}
