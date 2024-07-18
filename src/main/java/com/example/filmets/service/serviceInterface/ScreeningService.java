package com.example.filmets.service.serviceInterface;

import com.example.filmets.dto.ScreeningRequest;
import com.example.filmets.entity.Movie;
import com.example.filmets.entity.Screening;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ScreeningService {
    List<Screening> getAllScreenings();
    Screening getScreeningById(int id);
    List<Screening> getScreeningByMovie(Movie movie);
    Screening updateScreening(ScreeningRequest screeningRequest, int id);
    Screening saveScreening(ScreeningRequest screeningRequest);
    void deleteScreeningById(int id);
}
