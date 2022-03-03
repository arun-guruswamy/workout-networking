import java.util.Scanner;
public class UI {

    Scanner scan = new Scanner(System.in);

    UI() {}

     void intro() {
        System.out.println("Welcome to the ultimate Social Workout App!!");

    }

    String action() {
        System.out.println("Do you want to view or post workouts? (view or post)");
        return scan.next();

    }

    void outro() {
        System.out.println("Bye!");
    }

    void successfulPost() {
        System.out.println("Post successfully added\n");
    }

    void showFeed(Feed f) {
        System.out.println(f);
    }

    String askWorkoutType() {
        System.out.println("Please enter what type of workout you want to add (Cardio or Strength)");
        return scan.next();

    }

    void workoutLimitWarning() {
        System.out.println("This post already has a workout added");
    }

    void captionLimitWarning() {
        System.out.println("This post already has a caption");
    }

    void typeWarning() {
        System.out.println("Please enter a valid type of workout(Cardio or Strength)");
    }

    void successfulWorkout(){
        System.out.println("Workout successfully added");
    }

    String postOptions() {
        System.out.println("Do you want to add a workout(workout) or add a caption (caption)? \n\t Enter \"done\" when post is ready");
        return scan.next();
    }

    void postOptionWarning() {
        System.out.println("Specify a valid action for a post");
    }

    void emptyFeed() {
        System.out.println("There are no posts");
    }

    String askCaption() {
        System.out.println("Please enter your caption for the post");
        return scan.next();
    }
}
