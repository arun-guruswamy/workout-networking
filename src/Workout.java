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

    public void setGeneralAttributes() {
        Scanner scan = new Scanner(System.in);
        System.out.println("How long is your workout? (Enter as a number in the format: 000 " +
                "with the first digit being hours and the last two digits minutes");
        while(true) {
            try {
                this.length = Integer.parseInt(scan.next());
                break;
            }
            catch(NumberFormatException e) {
                System.out.println("Please enter a valid length");
            }
        }

        System.out.println("How do you rate the difficulty of this workout? (A number from 1 to 5");
        while(true) {
            try {
                this.difficulty= Integer.parseInt(scan.next());
                break;
            }
            catch(NumberFormatException e) {
                System.out.println("Please enter a valid difficulty");
            }
        }
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

    abstract void setSpecificAttributes();

    abstract public String toString();
}
