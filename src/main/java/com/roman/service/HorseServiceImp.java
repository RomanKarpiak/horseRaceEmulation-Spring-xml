package com.roman.service;

import com.roman.domain.Horse;

import java.util.ArrayList;
import java.util.List;

public class HorseServiceImp implements HorseService {

    private List<Horse> horsesList = new ArrayList<>();

    public HorseServiceImp() {
    }

    public HorseServiceImp(List<Horse> horsesList) {
        this.horsesList = horsesList;
    }

    public List<Horse> getHorsesList() {
        return horsesList;
    }

    public void setHorsesList(List<Horse> horsesList) {
        this.horsesList = horsesList;
    }

    @Override
    public void startPreparationForRace() {
        for (Horse horse : horsesList) {
            System.out.println(horse.getHorseName() + " and " + horse.getRider().getRiderName()  + " are being prepared for racing");
        }
    }

    @Override
    public void finishPreparationForRace() {
        for (Horse horse : horsesList) {
            System.out.println(horse.getHorseName() + " and " + horse.getRider().getRiderName() + " are ready for the race");
        }
    }


}
