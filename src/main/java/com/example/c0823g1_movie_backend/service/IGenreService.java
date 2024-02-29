package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.model.Genre;

public interface IGenreService {
    Iterable<Genre> getListMovieHasGenreById(Long id);

}
