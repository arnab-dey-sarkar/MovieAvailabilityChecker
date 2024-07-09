package com.nextgen.movieAvailabilityAtTheatre.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MoviePrices {
	private String price;
	private String desc;
	private String availabilityClass;
	private String availabilityText;
}
