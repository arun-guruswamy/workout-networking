package edu.vassar.cmpu203.workoutapp.Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StrengthTest {

    @Test
    void testToString() {
        boolean[] values = new boolean[4];
        values[0] = true;
        Workout strength = new Strength(values);
        strength.setDescription("FUN");
        strength.setLength(5);
        strength.setDifficulty(2);

        assertEquals("FUN\n\nLength: 5, Difficulty: 2\nUpperBody Focus: true\nLowerBody Focus: false\nFullBodyFocus: false" +
                "\nBodyWeight Focus: false", strength.toString());
    }
}