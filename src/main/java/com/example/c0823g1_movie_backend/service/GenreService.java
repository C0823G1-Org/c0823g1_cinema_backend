package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.model.Genre;
import com.example.c0823g1_movie_backend.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService implements IGenreService {
    @Autowired
    private GenreRepository genreRepository;

    @Override
    public Iterable<Genre> getListMovieHasGenreById(Long id) {
        return genreRepository.getListMovieHasGenreById(id);
    }

    @Override
    public List<Genre> getAll() {
        return genreRepository.getAll();
    }

    @Override
    public void addMovieHasGenre(Long newMovieId, Long genreId) {
        genreRepository.addMovieHasGenre(newMovieId,genreId);
    }

}
