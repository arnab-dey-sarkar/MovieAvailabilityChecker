package com.nextgen.movieAvailabilityAtTheatre.model;

import lombok.*;

import java.util.HashMap;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MovieTheatres {
	private String name;
	private HashMap<String,MoviePrices[]> showTimesWithPriceStats;

}
