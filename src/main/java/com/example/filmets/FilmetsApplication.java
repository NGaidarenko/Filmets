package com.example.filmets;

import com.example.filmets.config.JwtCore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FilmetsApplication {

    public static void main(String[] args) {
        SpringApplication.run(FilmetsApplication.class, args);
    }

}
