package com.nextgen.movieAvailabilityAtTheatre.utility;

import com.nextgen.movieAvailabilityAtTheatre.controller.MovieController;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class MovieCheckerCronJob {
    @Autowired
    MovieController movieController;
    @Autowired
    SendInBlueMailer sendInBlueMailer;

    @Scheduled(cron = "*    */10    *    *    *    *", zone = "IST")
    public void scheduleMovieCheck() {
        String movieName = System.getProperty("movie");
        String location = System.getProperty("location");
        if (StringUtils.isNotBlank(movieName) && StringUtils.isNotBlank(location)) {
            if (movieController.checkIfMovieInTheatres(movieName, location))
                sendInBlueMailer.sendMail("Arnab Dey Sarkar", "a.d.sarkar1990@gmail.com", "Movie Tickets Available Now In "+location+" For "+movieName);
            else
                sendInBlueMailer.sendMail("Arnab Dey Sarkar", "a.d.sarkar1990@gmail.com", "No Movie Tickets Available As Of Now In "+location+" For "+movieName);
        }
        else
        {
            if (movieController.checkIfMovieInTheatres("Kolkata", "Ant-Man"))
                sendInBlueMailer.sendMail("Arnab Dey Sarkar", "a.d.sarkar1990@gmail.com", "Movie Tickets Available Now In Kolkata For Antman");
            else
                sendInBlueMailer.sendMail("Arnab Dey Sarkar", "a.d.sarkar1990@gmail.com", "No Movie Tickets Available As Of Now In Kolkata For Antman");
        }
    }
}
