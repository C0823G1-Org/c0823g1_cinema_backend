package com.example.c0823g1_movie_backend.controller;

import com.example.c0823g1_movie_backend.dto.HistoryBookingDTO;
import com.example.c0823g1_movie_backend.model.Movie;
import com.example.c0823g1_movie_backend.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@CrossOrigin("*")
@RequestMapping("/movie")
public class MovieRestController {
    @Autowired
    private IMovieService movieService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Movie movie) {
        System.out.println(movie.toString());
        if (movie.getId() == null) {
            movieService.createMovie(movie);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<Movie> findById(@PathVariable Long id) {
        return new ResponseEntity<>(movieService.findById(id), HttpStatus.OK);
    }


}
