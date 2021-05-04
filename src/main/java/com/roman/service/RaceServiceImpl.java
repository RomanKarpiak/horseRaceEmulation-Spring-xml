package com.roman.service;

import com.roman.domain.Horse;
import com.roman.domain.Race;

import java.util.ArrayList;
import java.util.List;

public class RaceServiceImpl implements RaceService {

    private int numOfHorsesInRace;
    private int distance;
    private HorseService horseService;

    public RaceServiceImpl() {
    }

    public int getNumOfHorsesInRace() {
        return numOfHorsesInRace;
    }

    public void setNumOfHorsesInRace(int numOfHorsesInRace) {
        this.numOfHorsesInRace = numOfHorsesInRace;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public HorseService getHorseService() {
        return horseService;
    }

    public void setHorseService(HorseService horseService) {
        this.horseService = horseService;
    }

    public Race getRace() {
        Race race = new Race();
        race.setDistance(distance);
        race.setHorsesList(generateHorsesListInRace());
        return race;
    }

    public List<Horse> generateHorsesListInRace () {
        int randomNumOfHorse;
        int count = 0;
        List<Horse> horsesListInRace = new ArrayList<>();
        while (count != this.numOfHorsesInRace) {
            randomNumOfHorse = (int) (Math.random() * horseService.getHorsesList().size());
            if (!horsesListInRace.contains(horseService.getHorsesList().get(randomNumOfHorse))) {
                horsesListInRace.add(horseService.getHorsesList().get(randomNumOfHorse));
                count++;
            }
        }
        horsesListInRace.sort((o1,o2)-> o1.getHorseName().compareTo(o2.getHorseName()));
       return horsesListInRace;
    }
}
