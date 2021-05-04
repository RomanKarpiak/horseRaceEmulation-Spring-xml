package com.roman.service;

import com.roman.domain.Horse;
import com.roman.domain.Race;

import java.util.ArrayList;
import java.util.List;

public class RaceServiceImp implements RaceService {

    private int numOfHorsesInRace;
    private int distance;
    private HorseService horseService;

    public RaceServiceImp() {
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

    //    public void getRaceInfo() {
//        List<Horse> horsesListInRace = generateHorsesListInRace();
//        System.out.printf("%-10s%-10s%-10s%-10s%n","Number","Horse","Rider","Breed");
//        int count = 1;
//        for (Horse horse : horsesListInRace) {
//            System.out.printf("%-10d%-10s%-10s%-10s%n",count++,horse.getHorseName(),horse.getRider(),horse.getBreed());
//        }
//        System.out.println();
//    }

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
