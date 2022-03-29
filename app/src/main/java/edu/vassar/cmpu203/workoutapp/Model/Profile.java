package edu.vassar.cmpu203.workoutapp.Model;

public class Profile {
    private String id;
    private String username;
    private String password;
    private Feed posts;
    private String name;
    private String bio;
    private int experienceLevel;

    Profile() {
        this.posts = new Feed();
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setExperienceLevel(int experienceLevel) {
        if (experienceLevel <= 5 || experienceLevel >= 0)
          this.experienceLevel = experienceLevel;
    }
}