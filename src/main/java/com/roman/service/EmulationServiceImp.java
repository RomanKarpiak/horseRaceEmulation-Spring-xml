package com.roman.service;

import com.roman.domain.Horse;

import java.util.*;
import java.util.stream.Collectors;

public class EmulationServiceImp implements EmulationService {
    private HorseService horseService;
    private RaceService raceService;

    public EmulationServiceImp() {
    }

    public void setHorseServiceImp(HorseServiceImp horseServiceImp) {
        this.horseService = horseServiceImp;
    }

    public void setRaceServiceImp(RaceServiceImp raceServiceImp) {
        this.raceService = raceServiceImp;
    }

    @Override
    public void emulate() {
        System.out.println("====================================");
        System.out.println("Horse List");
        System.out.println("====================================");
        raceService.getRaceInfo();
        horseSelection();
        horseService.startPreparationForRace();
        horseService.finishPreparationForRace();
        System.out.println("");
        System.out.println("====================================");
        System.out.println("HORSE RACE");
        System.out.println("====================================");
        System.out.println("");
        System.out.println("====================================");
        System.out.println("GO!!!");
        System.out.println("====================================");
        startRace();
    }

      private void startRace() {
        List<Horse> horseListInRace = raceService.getRace().getHorsesListInRace();
        int trackLength = raceService.getRace().getTrackLength();
        Horse horseWinner = new Horse();
        boolean isFinished = false;
        int lapCount = 1;
        int move;
        do {
            System.out.println("##### LAP " + lapCount + "####");
            showHorsePosition(sortByDistance(horseListInRace));
            for (Horse horse : horseListInRace) {
                move = 1 + (int) (Math.random() * 6);
                horse.setDistance(horse.getDistance() + move);
                if (horse.getDistance() >= trackLength) {
                    horseWinner = horse;
                    isFinished = true;
                    break;
                }
            }
            lapCount++;

        } while (!isFinished);
        System.out.println("Winner: " + horseWinner.getHorseName());
        if (horseWinner.isSelected()) {
            System.out.println("Congratulation!!! You Win!!!");
        } else {
            System.out.println("You're out of luck, try again");
        }
        showWinnerList(horseListInRace);
    }

    private List<Horse> sortByDistance(List<Horse> horses) {
        List<Horse> sortedHorsesListByDistance = horses.stream()
                .sorted((o1, o2) -> o2.getDistance() - o1.getDistance())
                .collect(Collectors.toList());
        return sortedHorsesListByDistance;
    }

    private void showHorsePosition(List<Horse> horsePosition) {
        int positionHorse = 1;
        for (Horse horse : horsePosition) {
            System.out.println(horse.getHorseName() + " " + positionHorse++);
        }
    }

    private void showWinnerList(List<Horse> winnerList) {
        System.out.println("Winner List: \n");
        System.out.printf("%-10s%-10s%-10s%-10s%n", "Place", "Horse", "Rider", "Breed");
        List<Horse> sortedWinner = sortByDistance(winnerList);
        int place = 1;
        for (Horse horse : sortedWinner) {
            System.out.printf("%-10d%-10s%-10s%-10s%n", place++, horse.getHorseName(), horse.getRider(), horse.getBreed());
        }
        System.out.println();
    }

    private void horseSelection() {
        Scanner input = new Scanner(System.in);
        int horseNum;
        while (true) {
            System.out.println("Enter the horse number: ");
            while (!input.hasNextInt()) {
                System.out.println("Incorrect input,you must enter a number from 1 to " + raceService.getRace().getNumOfHorsesInRace());
                input.next();
                System.out.println("Enter the horse number: ");
            }
            horseNum = input.nextInt();
            if (horseNum < 1 || horseNum > raceService.getRace().getNumOfHorsesInRace()) {
                System.out.println("Incorrect input,you must enter a number from 1 to " + raceService.getRace().getNumOfHorsesInRace());
            } else {
                break;
            }
        }
        List<Horse> horsesListInRace = raceService.getRace().getHorsesListInRace();
        Horse selectedHorse = horsesListInRace.get(horseNum - 1);
        selectedHorse.setSelected(true);
        System.out.println("You choose " + selectedHorse.getHorseName());
    }

}
