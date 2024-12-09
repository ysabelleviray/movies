package com.gcash.movie.service;

import com.gcash.movie.model.Genre;
import com.gcash.movie.model.Movie;
import com.gcash.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImp implements MovieService{

    @Autowired
    MovieRepository movieRepository;

    @Override
    public List<Movie> getMoviesByYearReleased(int year) {
        return movieRepository.getMoviesByYearReleased(year);
    }

    @Override
    public List<Movie> getAllMoviesByOrderByYearReleased() {
        return movieRepository.getAllMoviesByOrderByYearReleased();
    }

    @Override
    public List<Movie> getMoviesByGenreAndIsSequel(String genre) {
        List<Movie> filteredMovies = new ArrayList<>();
        List<Movie> movies = movieRepository.findByIsSequelIsTrue();
        for (Movie movie : movies) {
            if(movie.getGenre().contains(Genre.valueOf(genre.toUpperCase()))){
                filteredMovies.add(movie);
            }

        }
        return filteredMovies;
    }

    @Override
    public List<Movie> getAllMovie() {
        List<Movie> movies = new ArrayList<Movie>();
        movieRepository.findAll().forEach(movie -> movies.add(movie));
        return movies;
    }

    @Override
    public String getSecurity() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return "" + auth;
    }
}
