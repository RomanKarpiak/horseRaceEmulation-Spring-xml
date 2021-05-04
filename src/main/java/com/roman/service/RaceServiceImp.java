package com.roman.service;

import com.roman.domain.Horse;
import com.roman.domain.Race;

import java.util.ArrayList;
import java.util.List;

public class RaceServiceImp implements RaceService {

    private Race race;
    private int numOfHorsesInRace;
    private int trackLength;
    private HorseServiceImp horseServiceImp;

    public RaceServiceImp() {
    }

    public Race getRace() {
        Race race = new Race();
        race.setNumOfHorsesInRace(numOfHorsesInRace);
        race.setTrackLength(trackLength);
        race.setHorsesListInRace(generateHorsesListInRace());
        return race;
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

    public HorseServiceImp getHorseServiceImp() {
        return horseServiceImp;
    }

    public void setHorseServiceImp(HorseServiceImp horseServiceImp) {
        this.horseServiceImp = horseServiceImp;
    }

    @Override
    public void getRaceInfo() {
        List<Horse> horsesListInRace = generateHorsesListInRace();
        System.out.printf("%-10s%-10s%-10s%-10s%n","Number","Horse","Rider","Breed");
        int count = 1;
        for (Horse horse : horsesListInRace) {
            System.out.printf("%-10d%-10s%-10s%-10s%n",count++,horse.getHorseName(),horse.getRider(),horse.getBreed());
        }
        System.out.println();
    }
    public List<Horse> generateHorsesListInRace () {
        int randomNumOfHorse;
        int count = 0;
        List<Horse> horsesListInRace = new ArrayList<>();
        while (count != this.numOfHorsesInRace) {
            randomNumOfHorse = (int) (Math.random() * horseServiceImp.getHorsesList().size());
            if (!horsesListInRace.contains(horseServiceImp.getHorsesList().get(randomNumOfHorse))) {
                horsesListInRace.add(horseServiceImp.getHorsesList().get(randomNumOfHorse));
                count++;
            }
        }
        horsesListInRace.sort((o1,o2)-> o1.getHorseName().compareTo(o2.getHorseName()));
       return horsesListInRace;
    }
}
