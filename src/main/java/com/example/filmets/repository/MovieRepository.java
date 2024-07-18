package com.example.filmets.repository;

import com.example.filmets.entity.Genre;
import com.example.filmets.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Movie findByTitle(String title);
    List<Movie> findAllByOrderByReleaseDateAsc();
    List<Movie> findAllByOrderByDurationAsc();
    List<Movie> findByGenreOrderByReleaseDateAsc(Genre genre);
}
