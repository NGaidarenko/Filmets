package com.example.filmets.service.serviceInterface;

import com.example.filmets.dto.MovieRequest;
import com.example.filmets.entity.Genre;
import com.example.filmets.entity.Movie;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieService {
    List<Movie> getAllMovies();
    Movie getMovieById(int id);
    Movie addMovie(MovieRequest movieRequest);
    Movie updateMovie(int id, MovieRequest movieRequest);
    void deleteMovie(int id);
    Movie getMovieByTitle(String title);
    List<Movie> getMovieOrderByReleaseDate();
    List<Movie> getMovieOrderByDuration();
    List<Movie> getMovieOrderByReleaseDateAndGenre(Genre genre);
}
