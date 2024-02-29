package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.Optional;

public interface IMovieService extends IGeneralService {
    Page<Movie> searchMovieByNameAndPublisher(String name, String publisher
            , LocalDate startDate, LocalDate endDate, Pageable pageable);

    void deleteMovieById(long id);

    Movie findMovieById(long id);
}
