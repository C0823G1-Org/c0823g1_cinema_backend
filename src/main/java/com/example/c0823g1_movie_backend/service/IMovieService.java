package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.dto.HistoryBookingDTO;
import com.example.c0823g1_movie_backend.dto.MovieDTO;
import com.example.c0823g1_movie_backend.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;
import java.util.Optional;

public interface IMovieService extends IGeneralService<Movie> {
    List<MovieDTO> getAllMovieHot();


    Page<MovieDTO> searchMovie(@Param("name") String value, Pageable pageable);

    List<MovieDTO> getAllMovieCurrent();


    void deleteMovieById(long id);

    void createMovie(Movie movie);

    Movie findById(Long id);



    Page<Movie> searchMovieByNameAndPublisher(String name, String publisher
            , LocalDate startDate, LocalDate endDate, Pageable pageable);


    Movie findMovieById(long id);
}
