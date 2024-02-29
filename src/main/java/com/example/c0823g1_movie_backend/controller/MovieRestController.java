package com.example.c0823g1_movie_backend.controller;

import com.example.c0823g1_movie_backend.model.Movie;
import com.example.c0823g1_movie_backend.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/movie")
public class MovieRestController {
    @Autowired
    IMovieService movieService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Movie movie) {
        System.out.println(movie.toString());
        if (movie.getId() == null) {
            movieService.createMovie(movie);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
