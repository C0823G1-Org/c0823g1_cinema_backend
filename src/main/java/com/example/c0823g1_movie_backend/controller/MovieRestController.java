package com.example.c0823g1_movie_backend.controller;

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
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/home")
public class MovieRestController {
    @Autowired
    private IMovieService movieService;
    /*    Create by: BaoLVN
     *     Date created : 29/02/2024
     *     Function: Get a list of movies with many views
     *     @return HttpStatus.NO_CONTENT not available if no listing is found/ HttpStatus.OK and list movie found
     * */

    @GetMapping
    public ResponseEntity<List<MovieDTO>> getAllMovieHot() {
        List<MovieDTO> list = movieService.getAllMovieHot();
        if (list == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /*    Create by: BaoLVN
     *     Date created : 29/02/2024
     *     Function: Get the list of movies showing today
     *     @return HttpStatus.NO_CONTENT not available if no listing is found/ HttpStatus.OK and list movie found
     * */
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

    /*    Create by: BaoLVN
     *     Date created : 29/02/2024
     *     Function: Search movie name and pagination
     *     @return HttpStatus.NOT_FOUND movies not found/ HttpStatus.OK movies has been found
     * */
    @GetMapping("/search/{name}")
    public ResponseEntity<Page<MovieDTO>> searchMovies(@RequestParam(name = "name", defaultValue = "") String value,
                                                       @RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 8);
        Page<MovieDTO> searchMovies = movieService.searchMovie(value, pageable);
        if (searchMovies == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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
