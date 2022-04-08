package edu.vassar.cmpu203.workoutapp.Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CardioTest {

    @Test
    void testToString() {
        boolean[] values = new boolean[3];
        values[0] = true;
        Workout cardio = new Cardio(values);
        cardio.setDescription("FUN");
        cardio.setLength(5);
        cardio.setDifficulty(2);

        assertEquals("FUN\n\nLength: 5, Difficulty: 2\nEndurance Focus: false\nAgility Focus: true\nSpeed Focus: false", cardio.toString());


    }
}