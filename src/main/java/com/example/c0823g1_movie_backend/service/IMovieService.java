package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.dto.HistoryBookingDTO;
import com.example.c0823g1_movie_backend.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface IMovieService extends IGeneralService<Movie> {
    Page<Movie> searchMovieByNameAndPublisher(String name, String publisher, Pageable pageable);

    Page<Movie> searchMovieByStartDate(Date startDate, Pageable pageable);

    void deleteMovieById(long id);

    void createMovie(Movie movie);

    Movie findById(Long id);


}
