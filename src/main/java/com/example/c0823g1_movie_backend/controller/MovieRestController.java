
package com.example.c0823g1_movie_backend.controller;

import com.example.c0823g1_movie_backend.dto.MovieDTO;
import com.example.c0823g1_movie_backend.model.Movie;
import com.example.c0823g1_movie_backend.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/home")
public class MovieRestController {
    @Autowired
    private IMovieService movieService;

    @GetMapping("/statistics")
    private ResponseEntity<Page<Movie>> movieStatistics(@PageableDefault(value = 10) Pageable pageable) {
        Page<Movie> movieList = movieService.getMovieStatistic(pageable);
        if (movieList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(movieList, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<MovieDTO>> getAllMovieHot() {
        List<MovieDTO> list = movieService.getAllMovieHot();
        if (list == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/movie/current")
    public ResponseEntity<List<Movie>> getAllMovieCurrent() {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        List<Movie> list = movieService.getAll();
        System.out.println(list.size());
        List<Movie> newList = new ArrayList<>();
        if (list == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        for (Movie movie : list) {
            if (movie.getStartDate().plusDays(7).isAfter(localDate) == true || movie.getStartDate() == localDate) {
                newList.add(movie);
            }
        }
        return new ResponseEntity<>(newList, HttpStatus.OK);
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
}
