package com.nextgen.movieAvailabilityAtTheatre.model;

import java.util.HashMap;

public class MovieTheatres {
    private String name;
    private HashMap<String,MoviePrices[]> showTimesWithPriceStats;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, MoviePrices[]> getShowTimesWithPriceStats() {
        return showTimesWithPriceStats;
    }

    public void setShowTimesWithPriceStats(HashMap<String, MoviePrices[]> showTimesWithPriceStats) {
        this.showTimesWithPriceStats = showTimesWithPriceStats;
    }

    public MovieTheatres(String name, HashMap<String, MoviePrices[]> showTimesWithPriceStats) {
        this.name = name;
        this.showTimesWithPriceStats = showTimesWithPriceStats;
    }

    @Override
    public String toString() {
        return "MovieTheatres{" +
                "name='" + name + '\'' +
                ", showTimesWithPriceStats=" + showTimesWithPriceStats +
                '}';
    }
}
