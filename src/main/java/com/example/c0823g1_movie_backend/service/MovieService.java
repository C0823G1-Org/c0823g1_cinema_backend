package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.model.Movie;
import com.example.c0823g1_movie_backend.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements IMovieService{
    @Autowired
    private MovieRepository movieRepository;
    @Override
    public Object save(Object o) {
        return null;
    }

    @Override
    public Object create(Object o) {
        return null;
    }

    @Override
    public List<Movie> getMovieStatistic() {
        return null;
    }
}
