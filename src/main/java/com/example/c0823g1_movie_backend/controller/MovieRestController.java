
package com.example.c0823g1_movie_backend.controller;

import com.example.c0823g1_movie_backend.dto.MovieStatisticDTO;
import com.example.c0823g1_movie_backend.model.Movie;
import com.example.c0823g1_movie_backend.service.IMovieService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    private ResponseEntity<Page<Movie>> movieStatistics(@PageableDefault(value = 10) Pageable pageable) {
        Page<Movie> movieList = movieService.getMovieStatistic(pageable);
        if (movieList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(movieList, HttpStatus.OK);
    }
}
