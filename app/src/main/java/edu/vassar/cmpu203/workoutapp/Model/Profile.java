package edu.vassar.cmpu203.workoutapp.Model;


import java.io.Serializable;

public class Profile implements Serializable {
    private String username;
    private String password;
    private Feed posts;
    private String bio;

    public Profile() {
        this.posts = new Feed();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getUsername() {
        return this.username;
    }
    public String getPassword() { return password;}
    public Feed getPosts(){return this.posts;}
    public String bio(){return this.bio;}
}