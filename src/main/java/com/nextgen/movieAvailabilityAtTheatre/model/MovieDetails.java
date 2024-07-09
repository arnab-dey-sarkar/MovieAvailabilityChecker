package com.nextgen.movieAvailabilityAtTheatre.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MovieDetails {
	private String location;
	private String movieName;
	private String movieType;
	private String movieLanguage;
}
