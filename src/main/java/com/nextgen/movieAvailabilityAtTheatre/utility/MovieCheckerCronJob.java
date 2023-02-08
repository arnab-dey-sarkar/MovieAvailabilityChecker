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
    @Autowired SendInBlueMailer sendInBlueMailer;
    @Scheduled(cron = "*    *    5    *    *    *", zone = "IST")
    public void scheduleMovieCheck()
    {
        if(movieController.checkIfMovieInTheatres("Kolkata","Ant-Man"))
            sendInBlueMailer.sendMail("Arnab Dey Sarkar","a.d.sarkar1990@gmail.com","Movie Tickets Available Now In Kolkata For Antman");
        else
            sendInBlueMailer.sendMail("Arnab Dey Sarkar","a.d.sarkar1990@gmail.com","No Movie Tickets Available As Of Now In Kolkata For Antman");
    }
}
