package com.example.filmets.controller;

import com.example.filmets.dto.MovieRequest;
import com.example.filmets.entity.Genre;
import com.example.filmets.entity.Movie;
import com.example.filmets.service.serviceInterface.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<Movie> getMovieById(@PathVariable int movieId) {
        return new ResponseEntity<>(movieService.getMovieById(movieId), HttpStatus.OK);
    }

    @PostMapping("/movie")
    public ResponseEntity<Movie> addMovie(@RequestBody MovieRequest movieRequest) {
        return new ResponseEntity<>(movieService.addMovie(movieRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{movieId}")
    public ResponseEntity<Movie> updateMovie(@PathVariable int movieId,
                                             @RequestBody MovieRequest movieRequest) {
        return new ResponseEntity<>(movieService.updateMovie(movieId, movieRequest), HttpStatus.OK);
    }

    @DeleteMapping("/{movieId}")
    public ResponseEntity<Void> deleteMovie(@PathVariable int movieId) {
        movieService.deleteMovie(movieId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/byTitle")
    public ResponseEntity<Movie> getMovieByTitle(@RequestParam String title) {
        return new ResponseEntity<>(movieService.getMovieByTitle(title), HttpStatus.OK);
    }

    @GetMapping("/orderByDate")
    public ResponseEntity<List<Movie>> getMovieByDate() {
        return new ResponseEntity<>(movieService.getMovieOrderByReleaseDate(), HttpStatus.OK);
    }

    @GetMapping("/orderByDuration")
    public ResponseEntity<List<Movie>> getMovieByDuration() {
        return new ResponseEntity<>(movieService.getMovieOrderByDuration(), HttpStatus.OK);
    }

    @GetMapping("/getByGenre/{genre}")
    public ResponseEntity<List<Movie>> getMovieByDateAndGenre(@PathVariable String genre) {
        Genre tempGenre = Genre.valueOf(genre);
        return new ResponseEntity<>(movieService.getMovieOrderByReleaseDateAndGenre(tempGenre), HttpStatus.OK);
    }
}
