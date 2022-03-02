package com.nextgen.movieAvailabilityAtTheatre.model;

public class MovieTheatres {
    String availabilty;

    public String getAvailabilty() {
        return availabilty;
    }

    public void setAvailabilty(String availabilty) {
        this.availabilty = availabilty;
    }

    @Override
    public String toString() {
        return "MovieTheatres{" +
                "availabilty='" + availabilty + '\'' +
                '}';
    }

    public MovieTheatres(String availabilty) {
        this.availabilty = availabilty;
    }
}
