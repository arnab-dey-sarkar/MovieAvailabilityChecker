package com.nextgen.movieAvailabilityAtTheatre.utility;

import com.nextgen.movieAvailabilityAtTheatre.controller.MovieController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class MovieCheckerCronJob {
    @Autowired
    MovieController movieController;
    @Scheduled(cron = "* */1 * * * *", zone = "IST")
    public void scheduleMovieCheck()
    {
        movieController.checkIfMovieInTheatres("Kolkata","Ant Man");
    }
}
