package edu.vassar.cmpu203.workoutapp.Model;

import java.util.ArrayList;

public class Sport implements Filter {
    String sport;
    ArrayList<Post> filtered = new ArrayList();

    public Sport(String sport, Feed f) {
        this.sport = sport;
        filtered = f.feed;
    }

    public ArrayList<Post> filter() {
        filtered.removeIf(post -> (post.workout == null) || (!(post.workout.sportFocus.equals(sport)) && !(sport.equals("None"))));
        return filtered;
    }
}
