package com.nextgen.movieAvailabilityAtTheatre.controller;

import com.nextgen.movieAvailabilityAtTheatre.model.MovieInfo;
import com.nextgen.movieAvailabilityAtTheatre.model.MovieInfo1;
import com.nextgen.movieAvailabilityAtTheatre.model.MovieTheatres;
import com.nextgen.movieAvailabilityAtTheatre.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;

    @RequestMapping(method=RequestMethod.POST,path="/getMovieAvailability",consumes = "application/json")
    public List<MovieTheatres> getMovieAvailability(@RequestBody MovieInfo movieInfo) throws Exception {

        return movieService.getMovieInfo(movieInfo);
    }
    @RequestMapping(method=RequestMethod.POST,path="/getAvailableTheatres",consumes = "application/json")
    public List<MovieTheatres> getAvailableTheatres(@RequestBody MovieInfo1 movieInfo) throws Exception {

        return movieService.getAvailableTheatres(movieInfo);
    }
}
