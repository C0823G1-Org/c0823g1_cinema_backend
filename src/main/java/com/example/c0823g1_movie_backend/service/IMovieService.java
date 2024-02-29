package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.c0823g1_movie_backend.dto.MovieDTO;
import org.springframework.data.repository.query.Param;
import java.util.Date;
import java.util.List;


public interface IMovieService extends IGeneralService {
    Page<Movie> getMovieStatistic(Pageable pageable);

    public interface IMovieService extends IGeneralService<Movie> {
        List<MovieDTO> getAllMovieHot();

        Page<MovieDTO> searchMovie(@Param("name") String value, Pageable pageable);

        List<Movie> getAll();

        Page<Movie> searchMovieByNameAndPublisher(String name, String publisher, Pageable pageable);

        Page<Movie> searchMovieByStartDate(Date startDate, Pageable pageable);

        void deleteMovieById(long id);

        void createMovie(Movie movie);
    }
}