import java.util.*;

public class Strength extends Workout {
    Boolean UpperBodyFocus;
    Boolean LowerBodyFocus;
    Boolean FullBodyFocus;
    Boolean BodyWeightFocus;

    public void setAllAttributes() {
        setAttribute(UpperBodyFocus, "Upper Body");
        setAttribute(LowerBodyFocus, "Lower Body");
        setAttribute(FullBodyFocus, "Full Body");
        setAttribute(BodyWeightFocus, "Body weight exercises");
    }

    public String toString() {
        return workout + "\n\n" + "Workout attributes:" + "\n UpperBody Focus: " + UpperBodyFocus
                + "\n LowerBody Focus: " + LowerBodyFocus + "\n FullBodyFocus: " + FullBodyFocus
                + "\n BodyWeight Focus: " + BodyWeightFocus;
    }
}
