package com.example.filmets.service.serviceImpl;

import com.example.filmets.dto.ScreeningRequest;
import com.example.filmets.entity.Movie;
import com.example.filmets.entity.Screening;
import com.example.filmets.repository.MovieRepository;
import com.example.filmets.repository.ScreeningRepository;
import com.example.filmets.service.serviceInterface.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ScreeningServiceImpl implements ScreeningService {
    @Autowired
    ScreeningRepository screeningRepository;

    @Autowired
    MovieRepository movieRepository;

    @Override
    public List<Screening> getAllScreenings() {
        return screeningRepository.findAll();
    }

    //Обработать ошибку, если ну будет сеанса с ID
    @Override
    public Screening getScreeningById(int id) {
        return screeningRepository.findById(id).orElseThrow(() -> new NoSuchElementException("No screening found with id: " + id));
    }

    //Обработать ошибку, если не будет фильма с Id
    @Override
    public List<Screening> getScreeningByMovieTitle(String movieTitle) {
        Movie movie = movieRepository.findByTitle(movieTitle);
        return screeningRepository.findScreeningByMovie(movie);
    }

    @Override
    public Screening saveScreening(ScreeningRequest screeningRequest) {
        Screening screening = new Screening();
        Movie movie = movieRepository.findByTitle(screeningRequest.getTitle());
        screening.setMovie(movie);
        screening.setStartDate(screeningRequest.getStartTime());

        return screeningRepository.save(screening);
    }

    @Override
    public Screening updateScreening(ScreeningRequest screeningRequest, int id) {
        Screening screening = getScreeningById(id);
        Movie movie = movieRepository.findByTitle(screeningRequest.getTitle());

        screening.setMovie(movie);
        screening.setStartDate(screeningRequest.getStartTime());

        return screeningRepository.save(screening);
    }

    @Override
    public void deleteScreeningById(int id) {
        screeningRepository.deleteById(id);
    }
}
