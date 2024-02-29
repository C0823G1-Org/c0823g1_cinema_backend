package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.dto.MovieDTO;
import com.example.c0823g1_movie_backend.model.Movie;
import com.example.c0823g1_movie_backend.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Date;

@Service
public class MovieService implements IMovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<MovieDTO> getAllMovieHot() {
        return movieRepository.getAllMovieHot();
    }

    @Override
    public Page<MovieDTO> searchMovie(String value, Pageable pageable) {
        return movieRepository.searchMovie("%"+value+"%",pageable);
    }

    @Override
    public List<MovieDTO> getAllMovieCurrent() {
        return movieRepository.getAllMovieCurrent();
    }


    @Override
    public Movie save(Movie movie) {
        return null;
    }

    @Override
    public Movie create(Movie movie) {
        return null;
    }

    @Override
    public void createMovie(Movie movie) {
        movieRepository.createMovie(movie);
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
