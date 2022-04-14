package edu.vassar.cmpu203.workoutapp.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FilterTest {

    @Test
    void testFilteredFeed() {
        Feed f = new Feed();

        //Add workout to feed
        Profile profile = new Profile();
        profile.setUsername("CoolDude");
        Post post = new Post(profile);
        post.addCaption("Nice workout");
        Workout workout = new Workout();
        workout.setDescription("FUN");
        workout.setLength(5);
        workout.setDifficulty(2);
        post.setWorkout(workout);

        f.feed.add(post);

        //Add second workout to feed
        Profile profile1 = new Profile();
        profile1.setUsername("CoolDude");
        Post post1 = new Post(profile1);
        post1.addCaption("Nice workout");
        Workout workout1 = new Workout();
        workout1.setDescription("FUN");
        workout1.setLength(3);
        workout1.setDifficulty(2);
        post1.setWorkout(workout1);

        f.feed.add(post1);

        //Add third workout to feed
        Profile profile2 = new Profile();
        profile2.setUsername("TestMan");
        Post post2 = new Post(profile2);
        post2.addCaption("fire workout");
        Workout workout2 = new Workout();
        workout2.setDescription("Intense");
        workout2.setLength(3);
        workout2.setDifficulty(1);
        post2.setWorkout(workout2);

        f.feed.add(post2);

        //Create Filters for feed
        Filter l = new Length(3, f);
        f.feed = l.filter();
        Filter d = new Difficulty(1, f);
        f.feed = d.filter();

        assertEquals("\nTestMan\nWorkout: Intense\n3\n1\n\nfire workout" + "\n\n", f.toString());
    }
}
