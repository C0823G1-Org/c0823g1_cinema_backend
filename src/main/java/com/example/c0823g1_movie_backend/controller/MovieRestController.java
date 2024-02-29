package com.example.c0823g1_movie_backend.controller;

import com.example.c0823g1_movie_backend.model.Movie;
import com.example.c0823g1_movie_backend.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/movie")
public class MovieRestController {
    @Autowired
    private IMovieService movieService;

    @GetMapping
    public ResponseEntity<Page<Movie>> findAllMovie(@RequestParam(defaultValue = "0") int page,
                                                    @RequestParam(defaultValue = "") String publisher,
                                                    @RequestParam(defaultValue = "") String name,
                                                    @RequestParam(defaultValue = "1990-01-01") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                    @RequestParam(defaultValue = "3000-01-01") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        Pageable pageable = PageRequest.of(page, 6, Sort.by("start_date").descending()
                .and(Sort.by("name").ascending()));
        Page<Movie> moviePage = movieService.searchMovieByNameAndPublisher(name, publisher, startDate, endDate, pageable);
        if (moviePage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(moviePage, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Movie> deleteMovie(@PathVariable Long id) {
        Movie movie = movieService.findMovieById(id);
        if (movie == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        movieService.deleteMovieById(id);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }
}
