package edu.vassar.cmpu203.workoutapp.Model;

import java.util.ArrayList;

public class Type implements Filter{
    int type;
    ArrayList<Post> filtered = new ArrayList();

    public Type(int type, Feed f) {
        this.type = type;
        filtered = f.feed;
    }

    public ArrayList<Post> filter() {
        filtered.removeIf(post -> (post.workout == null) || (post.workout.workoutType != type && type != 0));
        return filtered;

    }
}
