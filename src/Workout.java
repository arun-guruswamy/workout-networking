import java.util.Scanner;

public class Workout {
    int length;
    int difficulty;
    String workout;

    public String createWorkout() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please Enter a description for the workout");
        workout = scan.next();
        return workout;
    }

    public void setAttribute(Boolean attribute, String name) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Is your workout focussed on" + name + "? (yes or no)");
        if (scan.equals("yes"))
            attribute = true;
        else
            attribute = false;
    }

    public void setAllAttributes() {}

    public String toString() {
        return "";
    }
}
