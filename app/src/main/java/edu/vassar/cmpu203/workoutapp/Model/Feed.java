package edu.vassar.cmpu203.workoutapp.Model;

import java.util.ArrayList;

public class Feed {
    public ArrayList<Post> feed;

    public Feed() {
        feed = new ArrayList<>();
    }

    public String toString() {
        String res = "";

        for (Post post : feed) {
            res += post.toString() + "\n\n";
        }

        return res;
    }




}
