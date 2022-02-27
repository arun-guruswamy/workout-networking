
public class Cardio extends Workout {
    boolean EnduranceFocus;
    boolean AgilityFocus;
    boolean SpeedFocus;

    public Cardio() {}

    public void setSpecificAttributes() {
        EnduranceFocus = setAttribute("Endurance");
        AgilityFocus = setAttribute( "Agility");
        SpeedFocus = setAttribute( "Speed");
    }

    public String toString() {
        return workout + "\n\n" + "Length: " + this.length + ", Difficulty" + this.difficulty + "\nEndurance Focus: " + EnduranceFocus
                + "\nAgility Focus: " + AgilityFocus + "\nSpeed Focus: " + SpeedFocus;
    }

}
