package com.nextgen.movieAvailabilityAtTheatre.controller;

import com.nextgen.movieAvailabilityAtTheatre.model.Movie;
import com.nextgen.movieAvailabilityAtTheatre.model.MovieDetails;
import com.nextgen.movieAvailabilityAtTheatre.model.MovieTheatres;
import com.nextgen.movieAvailabilityAtTheatre.service.MovieService;
import com.nextgen.movieAvailabilityAtTheatre.utility.MovieCheckerCronJob;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
public class MovieController {
    @Autowired
    MovieService movieService;
    @Autowired
    MovieCheckerCronJob movieCheckerCronJob;

    @RequestMapping(method = RequestMethod.GET, path = "/movies/{movieName}/theatres")
    public ResponseEntity<?> getTheatresForMovie(@PathVariable("movieName") String movieName, @RequestParam String location, @RequestParam String movieType, @RequestParam String movieLanguage, @RequestParam(required = false) String theatreName) {
        List<MovieTheatres> movieTheatres;
        MovieDetails movieDetails = new MovieDetails(location, movieName, movieType, movieLanguage);
        try {
            if (StringUtils.isNotBlank(theatreName))
                movieTheatres = movieService.getTheatres(movieDetails).stream().filter(m -> m.getName().contains(theatreName)).collect(Collectors.toList());
            else
                movieTheatres = movieService.getTheatres(movieDetails);
            if (movieTheatres.size() == 0)
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(movieTheatres, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error Occurred In Retrieving Theatres For Movie " + movieName, e);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/movies")
    public ResponseEntity<?> getMovies(@RequestParam String location) {
        List<Movie> movieList;
        try {
            movieList = movieService.getMovies(location);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error Occurred In Retrieving Movies", e);
        }
        if (movieList.size() == 0)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        else
            return new ResponseEntity<>(movieList, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/movies/check")
    public void checkIfMovieInTheatres(@RequestParam String location, @RequestParam String movieName) {

        try {
            System.setProperty("movie", movieName);
            System.setProperty("location", location);
            movieCheckerCronJob.scheduleMovieCheck();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error Occurred In Retrieving Movies", e);
        }
    }
}
