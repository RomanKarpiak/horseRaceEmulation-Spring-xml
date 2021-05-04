package com.roman.service;

import com.roman.domain.Horse;

import java.util.ArrayList;
import java.util.List;

public class HorseServiceImpl implements HorseService {

    private List<Horse> horsesList = new ArrayList<>();

    public HorseServiceImpl() {
    }

    @Override
    public List<Horse> getHorsesList() {
        return horsesList;
    }

    public void setHorsesList(List<Horse> horsesList) {
        this.horsesList = horsesList;
    }

}
