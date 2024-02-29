package com.example.c0823g1_movie_backend.controller;

import com.example.c0823g1_movie_backend.dto.HistoryBookingDTO;
import com.example.c0823g1_movie_backend.dto.MovieDTO;
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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import java.time.LocalDate;
import java.util.List;
import com.example.c0823g1_movie_backend.dto.MovieDTO;


@RestController
@CrossOrigin("*")
@RequestMapping("/movie")
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

    @GetMapping("/current")
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
    /**
         * Create by TuanNM
         * Date create: 29/02/2024
         * Method: See details of the movie
         * @Param id movie
         * @Return movie information*/
    @GetMapping("/find/{id}")
    public ResponseEntity<Movie> findById(@PathVariable Long id) {
        return new ResponseEntity<>(movieService.findById(id), HttpStatus.OK);
    }




    /**
     * Created by: ThuanTM
     * Date created: 29/2/2024
     * Function:
     * Display movie list combined with search and pagination
     *
     * @return HTTPStatus.OK if have list movie and HTTPStatus.NO_CONTENT if list movie null
     */

    @GetMapping("/list")
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
    /**
     * Created by: ThuanTM
     * Date created: 29/2/2024
     * Function: delete movie by id
     *
     * @return HTTPStatus.OK if movie delete and HTTPStatus.NOT_FOUND if  movie not found
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Movie> deleteMovie(@PathVariable Long id) {
        Movie movie = movieService.findMovieById(id);
        if (movie == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        movieService.deleteMovieById(id);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }
}
