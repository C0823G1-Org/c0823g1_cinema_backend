package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.model.Genre;

import java.util.List;

public interface IGenreService {
    Iterable<Genre> getListMovieHasGenreById(Long id);

    List<Genre> getAll();
}
