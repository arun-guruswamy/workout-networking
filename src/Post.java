import java.util.*;

public class Post {
    String prod_id;
    String caption;
    static int workout_limit = 1;
    static int caption_limit = 1;
    int WRKnum;
    int CAPnum;
    Workout workout;

    public Post() {
        this.prod_id = "test";
        WRKnum = 0;
        CAPnum = 0;
    }

    public void addWorkout(String type) {
        Workout w;

            if (type.equalsIgnoreCase("cardio"))
                w = new Cardio();
            else
                w = new Strength();

        w.createWorkout();
        w.setGeneralAttributes();
        w.setSpecificAttributes();
        this.workout = w;

        this.WRKnum = 1;
    }

    public void addCaption() {
        if(caption_limit == CAPnum) {
            System.out.println("This post already has a caption");
            return;
        }

        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your caption for the post");
        this.caption = scan.nextLine();
        this.CAPnum = 1;
    }

    public String toString() {
        return "\n" + this.prod_id + "\nWorkout: " + workout.toString() + "\n\n" + caption;
    }
}
