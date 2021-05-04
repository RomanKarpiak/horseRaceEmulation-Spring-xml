package com.roman.domain;

import java.util.Objects;

public class Horse {

    private String horseName;
    private Rider rider;
    private Breed breed;
    private int distance;
    private boolean isSelected;

    public Horse() {
    }

    public Horse(String horseName, Rider rider, Breed breed, int distance, boolean isSelected) {
        this.horseName = horseName;
        this.rider = rider;
        this.breed = breed;
        this.distance = distance;
        this.isSelected = isSelected;
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

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horse horse = (Horse) o;
        return distance == horse.distance && isSelected == horse.isSelected && Objects.equals(horseName, horse.horseName) && Objects.equals(rider, horse.rider) && breed == horse.breed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(horseName, rider, breed, distance, isSelected);
    }
}
