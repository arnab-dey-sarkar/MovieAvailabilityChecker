package com.nextgen.movieAvailabilityAtTheatre.controller;

import com.nextgen.movieAvailabilityAtTheatre.model.MovieInfo;
import com.nextgen.movieAvailabilityAtTheatre.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;

    @RequestMapping(method=RequestMethod.POST,path="/getMovieAvailability",consumes = "application/json")
    public List<String> getMovieAvailability(@RequestBody MovieInfo movieInfo) throws Exception {

        return movieService.getMovieInfo(movieInfo);
    }
}
