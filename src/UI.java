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

    void addPost() {

    }
}
