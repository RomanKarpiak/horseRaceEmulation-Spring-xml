package com.roman.domain;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private int distance;
    private List<Horse> horsesList = new ArrayList<>();

    public Race() {
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public List<Horse> getHorsesList() {
        return horsesList;
    }

    public void setHorsesList(List<Horse> horsesList) {
        this.horsesList = horsesList;
    }
}
