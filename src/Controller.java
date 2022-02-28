import java.util.*;

public class Controller {

    Controller() {}

    public static void main(String[] args) {
        Feed f = new Feed();
        System.out.println("Welcome to the ultimate Social Workout App!!");
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Do you want to view or post workouts? (view or post)");
            String choice = scan.next();

            if (choice.equalsIgnoreCase("post")) {
                f = addPost(f);
            } else if (choice.equalsIgnoreCase("view")) {
                displayPosts(f);
            }
            else if (choice.equalsIgnoreCase("quit")) {
                System.out.println("Bye!");
                break;
            }
            // Need to flesh out view aspect through feed class
        }
    }

    static Feed addPost(Feed f) {
        Post p = new Post();
        p.addWorkout();
        p.addCaption();
        f.feed.push(p);
        System.out.println("Post successfully added\n");
        return f;
    }

    static void displayPosts(Feed f) {
        System.out.println(f);
    }
}
