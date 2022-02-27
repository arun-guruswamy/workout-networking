import java.util.Scanner;

public abstract class Workout {
    int length;
    int difficulty;
    String workout;

    public void createWorkout() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please Enter a description for the workout");
        workout = scan.nextLine();
    }

    public boolean setAttribute(String name) {
        boolean attribute = false;
        Scanner scan = new Scanner(System.in);
        System.out.println("Is your workout focused on " + name + "? (yes or no)");
        String a = scan.next();
        if (a.equals("yes"))
            attribute = true;
        return attribute;
    }

    public void setAllAttributes() {}

    public String toString() {
        return "";
    }
}
