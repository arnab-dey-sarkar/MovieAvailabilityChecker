package com.nextgen.movieAvailabilityAtTheatre.controller;

import com.nextgen.movieAvailabilityAtTheatre.model.MovieDetails;
import com.nextgen.movieAvailabilityAtTheatre.model.MovieTheatres;
import com.nextgen.movieAvailabilityAtTheatre.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;

    @RequestMapping(method = RequestMethod.GET, path = "/movies/{movieName}/theatres")
    public List<MovieTheatres> getTheatresForMovie(@PathVariable("movieName") String movieName, @RequestParam String location, @RequestParam String movieType, @RequestParam String movieLanguage, @RequestParam(required = false) Optional<String> theatreName) throws Exception {
        MovieDetails movieDetails = new MovieDetails(location, movieName, movieType, movieLanguage);
        if (theatreName.isPresent())
            return movieService.getTheatres(movieDetails).stream().filter(m -> m.getName().contains(theatreName.get())).collect(Collectors.toList());
        else
            return movieService.getTheatres(movieDetails);
    }
}
