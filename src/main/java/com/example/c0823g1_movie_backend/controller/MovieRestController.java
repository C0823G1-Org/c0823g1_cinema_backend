package com.example.c0823g1_movie_backend.controller;

import com.example.c0823g1_movie_backend.dto.HistoryBookingDTO;
import com.example.c0823g1_movie_backend.dto.MovieDTO;
import com.example.c0823g1_movie_backend.model.Movie;
import com.example.c0823g1_movie_backend.service.IMovieService;
import com.example.c0823g1_movie_backend.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/home")
public class MovieRestController {
    @Autowired
    private IMovieService movieService;

    @GetMapping
    public ResponseEntity<List<MovieDTO>> getAllMovieHot() {
        List<MovieDTO> list = movieService.getAllMovieHot();
        if (list == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/movie/current")
    public ResponseEntity<List<MovieDTO>> getAllMovieCurrent() {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        List<MovieDTO> list = movieService.getAllMovieCurrent();
        System.out.println(list.size());
        if (list == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<MovieDTO>> searchMovies(@RequestParam(name = "search", defaultValue = "a") String value,
                                                       @RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 8);
        Page<MovieDTO> searchMovies = movieService.searchMovie(value, pageable);
        if (searchMovies == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(searchMovies, HttpStatus.OK);
    }

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
    /**
     * Create by TuanNM
     * Date create: 29/02/2024
     * Method: See details of the movie
     * @Param id movie
     * @Return movie information*/
}
