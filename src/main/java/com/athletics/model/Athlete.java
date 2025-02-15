package com.athletics.model;

public class Athlete {
    private String lastName;
    private String firstName;
    private String gender;
    private String distance;
    private String time;

    public Athlete(String lastName, String firstName, String gender, String distance, String time) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.gender = gender;
        this.distance = distance;
        this.time = time;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
