package com.gcash.movie.controller;

import com.gcash.movie.model.Movie;
import com.gcash.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping("/movies")
    public List<Movie> getAllStudent(){
        return movieService.getAllMovie();
    }

    @GetMapping("/movie-by-year/{year}")
    public List<Movie> getMoviesByYear(@PathVariable int year){
        return movieService.getMoviesByYearReleased(year);
    }

    @GetMapping("/movie-order-by-year")
    public List<Movie> getAllMoviesOrderByYearReleased(){
        return movieService.getAllMoviesByOrderByYearReleased();
    }

    @GetMapping("/movie-by-genre/{genre}")
    public List<Movie> getMoviesByGenreAndIsSequel(@PathVariable String genre){
        return movieService.getMoviesByGenreAndIsSequel(genre);

    }
}
