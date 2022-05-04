package edu.vassar.cmpu203.workoutapp.Model;


import java.io.Serializable;

public class Profile implements Serializable {
    private String username;
    private AuthKey password;
    public Feed posts;
    private String bio;

    public Profile() {
        this.posts = new Feed();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = new AuthKey(password);
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getUsername() {
        return this.username;
    }
    public AuthKey getPassword() { return this.password;}
    public Feed getPosts(){return this.posts;}
    public String getBio(){return this.bio;}

    public boolean validatePassword(String password){
        return this.password.validatePassword(password);
    }
}