package com.gcash.movie.service;

import com.gcash.movie.model.Genre;
import com.gcash.movie.model.Movie;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface MovieService {

    List<Movie> getAllMovie();
    List<Movie> getMoviesByYearReleased(int year);
    List<Movie> getAllMoviesByOrderByYearReleased();
    List<Movie> getMoviesByGenreAndIsSequel(String genre);

    @PreAuthorize("isAuthenticated()")
    String getSecurity();
}
