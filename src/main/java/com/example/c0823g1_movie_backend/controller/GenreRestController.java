package com.example.c0823g1_movie_backend.controller;

import com.example.c0823g1_movie_backend.model.Genre;
import com.example.c0823g1_movie_backend.service.IGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/genre")
public class GenreRestController {
    @Autowired
    protected IGenreService genreService;

    @GetMapping("findMovie/{id}")
    public ResponseEntity<Iterable<Genre>> findMovie(@PathVariable Long id) {
        return new ResponseEntity<>(genreService.getListMovieHasGenreById(id), HttpStatus.OK);
    }
    /**
     * Create by TuanNM
     * Date create: 29/02/2024
     * Method:Search movie genre list
     * @Param id movie
     * @Return list of genres that the movie has
     */
}
