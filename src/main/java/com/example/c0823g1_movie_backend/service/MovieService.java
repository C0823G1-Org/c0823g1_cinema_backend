package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.dto.MovieDTO;
import com.example.c0823g1_movie_backend.model.Movie;
import com.example.c0823g1_movie_backend.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
        return movieRepository.searchMovie("%" + value + "%", pageable);
    }

    @Override
    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie save(Movie movie) {
        return null;
    }

    @Override
    public Movie create(Movie movie) {
        return null;
    }
    /**
     * Created by DuyDD
     * Date Created: 29/02/2024
     * Function: Get a list of movies that have the highest revenue
     */
    @Override
    public Page<Movie> getMovieStatistic(Pageable pageable) {
        return movieRepository.findTop20MoviesByRevenue(pageable);
    }

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

    @Override
    public Object save(Object o) {
        return null;
    }

    @Override
    public Object create(Object o) {
        return null;
    }
}
