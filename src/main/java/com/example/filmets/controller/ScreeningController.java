package com.example.filmets.controller;

import com.example.filmets.dto.ScreeningRequest;
import com.example.filmets.entity.Movie;
import com.example.filmets.entity.Screening;
import com.example.filmets.service.serviceInterface.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/screening")
public class ScreeningController {
    @Autowired
    ScreeningService screeningService;

    @GetMapping
    public ResponseEntity<List<Screening>> getAllScreening(){
        return new ResponseEntity<>(screeningService.getAllScreenings(), HttpStatus.OK);
    }

    @GetMapping("/{screeningId}")
    public ResponseEntity<Screening> getScreeningById(@PathVariable int screeningId){
        return new ResponseEntity<>(screeningService.getScreeningById(screeningId), HttpStatus.OK);
    }

    @GetMapping("/screening/{movieId}")
    public ResponseEntity<List<Screening>> getScreeningByMovieId(@PathVariable int movieId){
        Movie movie = new Movie();
        movie.setId(movieId);
        List<Screening> screeningList = screeningService.getScreeningByMovie(movie);

        return new ResponseEntity<>(screeningList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Screening> createScreening(@RequestBody ScreeningRequest screeningRequest){
        return new ResponseEntity<>(screeningService.saveScreening(screeningRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{screeningId}")
    public ResponseEntity<Screening> updateScreening(@PathVariable int screeningId,
                                                     @RequestBody ScreeningRequest screeningRequest){
        return new ResponseEntity<>(screeningService.updateScreening(screeningRequest, screeningId), HttpStatus.OK);
    }

    @DeleteMapping("/{screeningId}")
    public ResponseEntity<Void> deleteScreening(@PathVariable int screeningId){
        screeningService.deleteScreeningById(screeningId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
