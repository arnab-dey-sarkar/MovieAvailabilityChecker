package com.nextgen.movieAvailabilityAtTheatre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@Configuration
@ComponentScan
public class MovieAvailabilityAtTheatreApplication {
    public static void main(String[] args) {
        SpringApplication.run(MovieAvailabilityAtTheatreApplication.class, args);
    }
}
