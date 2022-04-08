package edu.vassar.cmpu203.workoutapp.Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PostTest {

    @Test
    void testToString() {
        Profile profile = new Profile();
        profile.setUsername("CoolDude");
        Post post = new Post(profile);
        post.addCaption("Nice workout");
        Workout workout = new Workout();
        workout.setDescription("FUN");
        workout.setLength(5);
        workout.setDifficulty(2);
        post.setWorkout(workout);


        assertEquals("\nCoolDude\nWorkout: FUN\n5\n2\n\nNice workout",post.toString());
    }
}