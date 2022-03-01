package com.nextgen.movieAvailabilityAtTheatre.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MovieInfo {
    private String location;
    private String movieName;
    private String theatreName;
    private String movieType;
    private String movieLanguage;
}
