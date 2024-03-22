package com.nextgen.movieAvailabilityAtTheatre.utility;

import com.nextgen.movieAvailabilityAtTheatre.service.MovieService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class MovieCheckerCronJob {
	@Autowired
	MovieService movieService;
	@Autowired
	SendInBlueMailer sendInBlueMailer;

	//@Scheduled(cron = "* */10 * * * *", zone = "IST")
	public void scheduleMovieCheck() {
		String movieName = System.getProperty("movie");
		String location = System.getProperty("location");
		if (StringUtils.isNotBlank(movieName) && StringUtils.isNotBlank(location)) {
			if (movieService.checkIfMovieInTheatres(movieName, location))
				sendInBlueMailer.sendMail("Arnab Dey Sarkar", "a.d.sarkar1990@gmail.com", "Movie Tickets Available Now In "+location+" For "+movieName);
			else
				sendInBlueMailer.sendMail("Arnab Dey Sarkar", "a.d.sarkar1990@gmail.com", "No Movie Tickets Available As Of Now In "+location+" For "+movieName);
		}
		else
		{
			if (movieService.checkIfMovieInTheatres("Kolkata", "Ant-Man"))
				sendInBlueMailer.sendMail("Arnab Dey Sarkar", "a.d.sarkar1990@gmail.com", "Movie Tickets Available Now In Kolkata For Antman");
			else
				sendInBlueMailer.sendMail("Arnab Dey Sarkar", "a.d.sarkar1990@gmail.com", "No Movie Tickets Available As Of Now In Kolkata For Antman");
		}
	}
}
