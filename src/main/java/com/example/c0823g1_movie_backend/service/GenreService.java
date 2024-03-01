package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.model.Genre;
import com.example.c0823g1_movie_backend.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreService implements IGenreService {
    @Autowired
    private GenreRepository genreRepository;

    @Override
    public Iterable<Genre> getListMovieHasGenreById(Long id) {
        return genreRepository.getListMovieHasGenreById(id);
    }

}
