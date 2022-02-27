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
    }

    public void addWorkout() {
        if(WRKnum == workout_limit) {
            System.out.println("This post already has a workout added");
            return;
        }

        Workout w = null;
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter what type of workout you want to add (Cardio or Strength)");
        String type = scan.next();
        while(w == null) {
            if (type.equalsIgnoreCase("CARDIO"))
                w = new Cardio();
            else if (type.equalsIgnoreCase("STRENGTH"))
                w = new Strength();
            else {
                System.out.println("Please enter an acceptable workout type (Cardio or Strength");
                type = scan.next();
            }
        }

        w.createWorkout();
        w.setAllAttributes();
        workout = w;

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
        return "\nWorkout: " + workout.toString() + "\n\n" + caption;
    }
}
