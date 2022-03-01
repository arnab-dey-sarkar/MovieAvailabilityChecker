package com.nextgen.movieAvailabilityAtTheatre.model;

public class MovieInfo {
    private String location;
    private String movieName;
    private String theatreName;
    private String movieType;
    private String movieLanguage;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public String getMovieLanguage() {
        return movieLanguage;
    }

    public void setMovieLanguage(String movieLanguage) {
        this.movieLanguage = movieLanguage;
    }

    @Override
    public String toString() {
        return "MovieInfo{" +
                "location='" + location + '\'' +
                ", movieName='" + movieName + '\'' +
                ", theatreName='" + theatreName + '\'' +
                ", movieType='" + movieType + '\'' +
                ", movieLanguage='" + movieLanguage + '\'' +
                '}';
    }

    public MovieInfo(String location, String movieName, String theatreName, String movieType, String movieLanguage) {
        this.location = location;
        this.movieName = movieName;
        this.theatreName = theatreName;
        this.movieType = movieType;
        this.movieLanguage = movieLanguage;
    }

}
