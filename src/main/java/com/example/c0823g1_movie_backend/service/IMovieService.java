package com.example.c0823g1_movie_backend.service;


import com.example.c0823g1_movie_backend.dto.IMovieDTO;
import com.example.c0823g1_movie_backend.dto.MovieDTO;
import com.example.c0823g1_movie_backend.dto.IMovieListDTO;
import com.example.c0823g1_movie_backend.dto.MovieStatisticDTO;
import com.example.c0823g1_movie_backend.dto.ScheduleDTO;
import com.example.c0823g1_movie_backend.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface IMovieService extends IGeneralService<Movie> {
    List<IMovieDTO> getAllMovieHot();


    Page<IMovieDTO> searchMovie(@Param("name") String value, Pageable pageable);

    List<IMovieDTO> getAllMovieCurrent();


    void deleteMovieById(long id);

    Movie findById(Long id);

    Long createMovie(MovieDTO movie, List<Long> versions, List<Long> genres);

    Page<IMovieListDTO> searchMovieByNameAndPublisher(String name, String publisher, LocalDate startDate, LocalDate endDate, Pageable pageable);


    Movie findMovieById(long id);

    Page<MovieStatisticDTO> getMovieStatistic(String name,Pageable pageable);

    List<IMovieDTO> getAllMovieCurrentTo3Day();
    boolean editMovie(MovieDTO movie, Set<ScheduleDTO> scheduleDTO, List<Long> versions, List<Long> genres);

    List<Long> checkIfDuplicated(MovieDTO movieDTO);
}
