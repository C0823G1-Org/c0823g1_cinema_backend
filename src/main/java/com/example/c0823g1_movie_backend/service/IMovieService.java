package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.dto.MovieDTO;
import com.example.c0823g1_movie_backend.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IMovieService extends IGeneralService<Movie>{
    List<MovieDTO> getAllMovieHot();
    Page<MovieDTO> searchMovie(@Param("name") String value, Pageable pageable);
    List<Movie> getAll();
}
