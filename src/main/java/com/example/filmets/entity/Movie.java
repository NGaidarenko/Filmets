package com.example.filmets.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "movis", schema = "filmets")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "Title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "Date_of_release")
    private LocalDate releaseDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "Genre")
    private Genre genre;

    @Column(name = "Duration")
    private int duration;
}
