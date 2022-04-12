package edu.vassar.cmpu203.workoutapp.Model;

import java.util.ArrayList;
import java.util.Scanner;

public class Length implements Filter {
    int length;
    ArrayList<Post> filtered = new ArrayList();

    public Length(int length, Feed f) {
        this.length = length;
        filtered = f.feed;
    }

    public ArrayList<Post> filter() {
        filtered.removeIf(post -> post.workout.length != length && length != 0);
        return filtered;

    }
}
