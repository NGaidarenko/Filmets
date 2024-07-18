package com.example.filmets.repository;

import com.example.filmets.entity.Movie;
import com.example.filmets.entity.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScreeningRepository extends JpaRepository<Screening, Integer> {
    List<Screening> findScreeningByMovie(Movie movie);
}
