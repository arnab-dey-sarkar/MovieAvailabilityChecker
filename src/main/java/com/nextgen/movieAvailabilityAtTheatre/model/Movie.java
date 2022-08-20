package com.nextgen.movieAvailabilityAtTheatre.model;

public class Movie {
    private String movieName;
    private String language;

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Movie(String movieName, String language) {
        this.movieName = movieName;
        this.language = language;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieName='" + movieName + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
