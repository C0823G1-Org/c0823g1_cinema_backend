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
    public ResponseEntity<Movie> save(@RequestBody Movie movie) {
        System.out.println(movie.toString());
        Movie result;
        if (movie.getId() == null) {
            result = movieService.create(movie);
        } else {
            result = movieService.save(movie);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
