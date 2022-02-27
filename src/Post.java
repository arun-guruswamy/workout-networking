import java.util.*;

public class Post {
    String prod_id;
    String caption;
    final int workout_limit;
    Workout workout;

    public Post() {
        String prod_id = "test";
        workout_limit = 1;
    }

    public void addWorkout() {
        Workout w;
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter what type of workout you want to add (Cardio or Strength");
        String type = scan.next();
        if (type.equals("Cardio"))
            w = new Cardio();
        else
            w = new Strength();

        w.createWorkout();
        w.setAllAttributes();
        workout = w;
    }

    public String addCaption() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your caption for the post");
        String caption = scan.next();
        return "";
    }

    public String toString() {
        return workout.toString() + "\n\n" + caption;
    }
}
