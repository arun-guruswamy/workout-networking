package edu.vassar.cmpu203.workoutapp.Model;

import java.util.ArrayList;

public class Difficulty implements Filter {
    int difficulty;
    ArrayList<Post> filtered = new ArrayList();

    public Difficulty(int difficulty, Feed f) {
        this.difficulty = difficulty;
        filtered = f.feed;
    }

    public ArrayList<Post> filter() {
        filtered.removeIf(post -> (post.workout == null) || (post.workout.difficulty != difficulty && difficulty != 0));
        return filtered;
    }
}
