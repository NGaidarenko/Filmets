package com.example.filmets.service.serviceImpl;

import com.example.filmets.dto.MovieRequest;
import com.example.filmets.entity.Genre;
import com.example.filmets.entity.Movie;
import com.example.filmets.repository.MovieRepository;
import com.example.filmets.service.serviceInterface.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovieById(int id) {
        return movieRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Элемент с id:" + id + " - не найден"));
    }

    @Override
    public Movie addMovie(MovieRequest movieRequest) {
        Movie movie = new Movie();
        movie.setTitle(movieRequest.getTitle());
        movie.setDescription(movieRequest.getDescription());
        movie.setReleaseDate(movieRequest.getReleaseDate());
        movie.setGenre(movieRequest.getGenre());
        movie.setDuration(movieRequest.getDuration());

        return movieRepository.save(movie);
    }

    @Override
    public Movie updateMovie(int id, MovieRequest movieRequest) {
        Movie movie = getMovieById(id);
        movie.setTitle(movieRequest.getTitle());
        movie.setDescription(movieRequest.getDescription());
        movie.setReleaseDate(movieRequest.getReleaseDate());
        movie.setGenre(movieRequest.getGenre());
        movie.setDuration(movieRequest.getDuration());

        return movieRepository.save(movie);
    }

    @Override
    public void deleteMovie(int id) {
        movieRepository.deleteById(id);
    }

    @Override
    public Movie getMovieByTitle(String title) {
        return movieRepository.findByTitle(title);
    }

    @Override
    public List<Movie> getMovieOrderByReleaseDate() {
        return movieRepository.findAllByOrderByReleaseDateAsc();
    }

    @Override
    public List<Movie> getMovieOrderByDuration() {
        return movieRepository.findAllByOrderByDurationAsc();
    }

    @Override
    public List<Movie> getMovieOrderByReleaseDateAndGenre(Genre genre) {
        return movieRepository.findByGenreOrderByReleaseDateAsc(genre);
    }
}
