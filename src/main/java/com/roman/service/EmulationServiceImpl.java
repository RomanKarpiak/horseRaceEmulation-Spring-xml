package com.roman.service;

import com.roman.domain.Horse;
import com.roman.domain.Race;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EmulationServiceImp implements EmulationService {

    private HorseService horseService;
    private RaceService raceService;


    public EmulationServiceImp() {
    }

    public HorseService getHorseService() {
        return horseService;
    }

    public void setHorseService(HorseService horseService) {
        this.horseService = horseService;
    }

    public RaceService getRaceService() {
        return raceService;
    }

    public void setRaceService(RaceService raceService) {
        this.raceService = raceService;
    }

    @Override
    public void emulate() {
        System.out.println("====================================");
        System.out.println("Horse List");
        System.out.println("====================================");
        Race race = raceService.getRace();
        Horse selectedHorse = selectHorse(race.getHorsesList());
        startPreparationForRace(race.getHorsesList());
        finishPreparationForRace(race.getHorsesList());
        System.out.println("");
        System.out.println("====================================");
        System.out.println("HORSE RACE");
        System.out.println("====================================");
        System.out.println("");
        System.out.println("====================================");
        System.out.println("GO!!!");
        System.out.println("====================================");
        startRace(race, selectedHorse);
    }

    private void startRace(Race race, Horse selectedHorse) {
        List<Horse> horseListInRace = race.getHorsesList();
        int distance = race.getDistance();
        Horse horseWinner = null;
        boolean isFinished = false;
        int lapCount = 1;
        while (!isFinished) {
            System.out.println("##### LAP " + lapCount + "####");
            printPositions(sortByDistance(horseListInRace));
            for (Horse horse : horseListInRace) {
                int move = 1 + (int) (Math.random() * 6);
                horse.setDistance(horse.getDistance() + move);
                if (horse.getDistance() >= distance) {
                    horseWinner = horse;
                    isFinished = true;
                    break;
                }
            }
            lapCount++;
        }
        System.out.println("Winner: " + horseWinner.getHorseName());
        if (horseWinner.equals(selectedHorse)) {
            System.out.println("Congratulation!!! You Win!!!");
        } else {
            System.out.println("You're out of luck, try again");
        }
        printLeaderboard(horseListInRace);
    }

    private List<Horse> sortByDistance(List<Horse> horses) {
        List<Horse> sortedHorsesListByDistance = horses.stream()
                .sorted((o1, o2) -> o2.getDistance() - o1.getDistance())
                .collect(Collectors.toList());
        return sortedHorsesListByDistance;
    }

    private void printPositions(List<Horse> horses) {
        int positionHorse = 1;
        for (Horse horse : horses) {
            System.out.println(horse.getHorseName() + " " + positionHorse++);
        }
    }

    private void printLeaderboard(List<Horse> horses) {
        System.out.println("Winner List: \n");
        System.out.printf("%-10s%-10s%-10s%-10s%n", "Place", "Horse", "Rider", "Breed");
        List<Horse> sortedWinner = sortByDistance(horses);
        int place = 1;
        for (Horse horse : sortedWinner) {
            System.out.printf("%-10d%-10s%-10s%-10s%n", place++, horse.getHorseName(), horse.getRider(), horse.getBreed());
        }
        System.out.println();
    }

    private Horse selectHorse(List<Horse> horses) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the horse number: ");
            while (!input.hasNextInt()) {
                System.out.println("Incorrect input,you must enter a number from 1 to " + horses.size());
                input.next();
                System.out.println("Enter the horse number: ");
            }
            int horseNum = input.nextInt();
            if (horseNum < 1 || horseNum > horses.size()) {
                System.out.println("Incorrect input,you must enter a number from 1 to " + horses.size());
            } else {
                Horse selectedHorse = horses.get(horseNum - 1);
                System.out.println("You choose " + selectedHorse.getHorseName());
                return selectedHorse;
            }
        }
    }

    public void startPreparationForRace(List<Horse> horses) {
        for (Horse horse : horses) {
            System.out.println(horse.getHorseName() + " and " + horse.getRider().getRiderName() + " are being prepared for racing");
        }
    }


    public void finishPreparationForRace(List<Horse> horses) {
        for (Horse horse : horses) {
            System.out.println(horse.getHorseName() + " and " + horse.getRider().getRiderName() + " are ready for the race");
        }
    }

}
