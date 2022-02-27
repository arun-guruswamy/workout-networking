import java.util.*;

public class Controller {
    public static void main(String[] args) {
        System.out.println("Welcome to the ultimate Social Workout App!!");
        Scanner scan = new Scanner(System.in);
        System.out.println("Do you want to view or post workouts? (view or post)");
        String choice = scan.next();

        if (choice.equalsIgnoreCase("post")) {
            Post p = new Post();
            p.addWorkout();
            p.addCaption();
            System.out.println(p);
        }
        // Need to flesh out view aspect through feed class

    }
}
