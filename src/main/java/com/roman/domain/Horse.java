package com.roman.domain;

public class Horse {

    private String horseName;
    private Rider rider;
    private Breed breed;
    private int distance;


    public Horse() {
    }

    public Horse(String horseName, Rider rider, Breed breed, int distance) {
        this.horseName = horseName;
        this.rider = rider;
        this.breed = breed;
        this.distance = distance;
    }

    public String getHorseName() {
        return horseName;
    }

    public void setHorseName(String horseName) {
        this.horseName = horseName;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}