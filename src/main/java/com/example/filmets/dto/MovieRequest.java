package com.example.filmets.dto;

import com.example.filmets.entity.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieRequest {
    private String title;
    private String description;
    private LocalDate releaseDate;
    private Genre genre;
    private int duration;
}
