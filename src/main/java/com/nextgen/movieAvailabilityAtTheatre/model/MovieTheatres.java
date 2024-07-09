package com.nextgen.movieAvailabilityAtTheatre.model;

import lombok.*;

import java.util.HashMap;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MovieTheatres {
	private String name;
	private HashMap<String,MoviePrices[]> showTimesWithPriceStats;

}
