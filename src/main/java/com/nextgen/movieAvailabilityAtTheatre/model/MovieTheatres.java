package com.nextgen.movieAvailabilityAtTheatre.model;

import java.util.List;

public class MovieTheatres {
    String name;
    List<String> showTimes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getShowTimes() {
        return showTimes;
    }

    public void setShowTimes(List<String> showTimes) {
        this.showTimes = showTimes;
    }

    public MovieTheatres(String name, List<String> showTimes) {
        this.name = name;
        this.showTimes = showTimes;
    }

    @Override
    public String toString() {
        return "MovieTheatres{" +
                "name='" + name + '\'' +
                ", showTimes=" + showTimes +
                '}';
    }
}
