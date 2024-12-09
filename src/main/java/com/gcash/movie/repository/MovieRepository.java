package com.gcash.movie.repository;

import com.gcash.movie.model.Genre;
import com.gcash.movie.model.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieRepository extends CrudRepository<Movie,Long>  {

    List<Movie> getMoviesByYearReleased(int year);
    List<Movie> getAllMoviesByOrderByYearReleased();
    List<Movie> findByIsSequelIsTrue();
    List<Movie> findByIsSequelTrueAndGenre(Genre genre);
}
