package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.dto.MovieDTO;
import com.example.c0823g1_movie_backend.dto.MovieStatisticDTO;
import com.example.c0823g1_movie_backend.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;


public interface IMovieService extends IGeneralService {
    Movie save(Movie movie);

    Movie create(Movie movie);

    Page<MovieStatisticDTO> getMovieStatistic(Pageable pageable);

    List<MovieDTO> getAllMovieHot();

    Page<MovieDTO> searchMovie(@Param("name") String value, Pageable pageable);

    List<Movie> getAll();

    Page<Movie> searchMovieByNameAndPublisher(String name, String publisher, Pageable pageable);

    Page<Movie> searchMovieByStartDate(Date startDate, Pageable pageable);

    void deleteMovieById(long id);

    void createMovie(Movie movie);
}
