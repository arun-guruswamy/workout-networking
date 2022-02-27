
public class Strength extends Workout {
    boolean UpperBodyFocus;
    boolean LowerBodyFocus;
    boolean FullBodyFocus;
    boolean BodyWeightFocus;

    Strength() {}

    public void setSpecificAttributes() {
        UpperBodyFocus = setAttribute( "Upper Body");
        LowerBodyFocus = setAttribute( "Lower Body");
        FullBodyFocus = setAttribute( "Full Body");
        BodyWeightFocus = setAttribute( "Body weight exercises");
    }

    public String toString() {
        return workout + "\n\n" + "Workout attributes:" + "\n UpperBody Focus: " + UpperBodyFocus
                + "\n LowerBody Focus: " + LowerBodyFocus + "\n FullBodyFocus: " + FullBodyFocus
                + "\n BodyWeight Focus: " + BodyWeightFocus;
    }
}
