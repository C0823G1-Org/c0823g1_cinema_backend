package com.example.c0823g1_movie_backend.controller;

import com.example.c0823g1_movie_backend.dto.MovieStatisticDTO;
import com.example.c0823g1_movie_backend.model.Movie;
import com.example.c0823g1_movie_backend.service.IMovieService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/movie")
public class MovieRestController {
    @Autowired
    private IMovieService movieService;

    @GetMapping("/statistics")
    private ResponseEntity<List<Movie>> movieStatistics() {
        List<Movie> movieList = movieService.getMovieStatistic();
        if (movieList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(movieList, HttpStatus.OK);
    }
}
