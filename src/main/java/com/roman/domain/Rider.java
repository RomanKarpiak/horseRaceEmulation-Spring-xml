package com.roman.domain;

public class Rider {
    private String riderName;

    public Rider() {
    }

    public Rider(String riderName) {
        this.riderName = riderName;
    }

    public String getRiderName() {
        return riderName;
    }

    public void setRiderName(String riderName) {
        this.riderName = riderName;
    }

    @Override
    public String toString() {
        return riderName;
    }
}
