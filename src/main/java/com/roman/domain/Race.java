package com.roman.domain;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private int numOfHorsesInRace;
    private int trackLength;
    private List<Horse> horsesListInRace = new ArrayList<>();

    public Race() {
    }

    public Race(int numOfHorsesInRace, int trackLength, List<Horse> horsesListInRace) {
        this.numOfHorsesInRace = numOfHorsesInRace;
        this.trackLength = trackLength;
        this.horsesListInRace = horsesListInRace;
    }

    public int getNumOfHorsesInRace() {
        return numOfHorsesInRace;
    }

    public void setNumOfHorsesInRace(int numOfHorsesInRace) {
        this.numOfHorsesInRace = numOfHorsesInRace;
    }

    public int getTrackLength() {
        return trackLength;
    }

    public void setTrackLength(int trackLength) {
        this.trackLength = trackLength;
    }

    public List<Horse> getHorsesListInRace() {
        return horsesListInRace;
    }

    public void setHorsesListInRace(List<Horse> horsesListInRace) {
        this.horsesListInRace = horsesListInRace;
    }
}
