package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.dto.IMovieDTO;
import com.example.c0823g1_movie_backend.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.time.LocalDate;

public interface IMovieService extends IGeneralService<Movie> {
    List<IMovieDTO> getAllMovieHot();


    Page<IMovieDTO> searchMovie(@Param("name") String value, Pageable pageable);

    List<IMovieDTO> getAllMovieCurrent();


    void deleteMovieById(long id);

    void createMovie(Movie movie);

    Movie findById(Long id);



    Page<Movie> searchMovieByNameAndPublisher(String name, String publisher
            , LocalDate startDate, LocalDate endDate, Pageable pageable);


    Movie findMovieById(long id);
}
