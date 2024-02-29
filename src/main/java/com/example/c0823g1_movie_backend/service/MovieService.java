package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.model.Movie;
import com.example.c0823g1_movie_backend.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MovieService implements IMovieService {
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
    public Page<Movie> searchMovieByNameAndPublisher(String name, String publisher, Pageable pageable) {
        return movieRepository.searchMovieByNameAndPublisher("%" + name + "%", "%" + publisher + "%", pageable);
    }

    @Override
    public Page<Movie> searchMovieByStartDate(Date startDate, Pageable pageable) {
        return movieRepository.searchMovieByStartDate(startDate, pageable);
    }

    @Override
    public void deleteMovieById(long id) {

    }
}
