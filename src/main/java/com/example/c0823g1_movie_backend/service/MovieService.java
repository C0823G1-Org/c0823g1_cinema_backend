package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.dto.IMovieDTO;
import com.example.c0823g1_movie_backend.dto.MovieDTO;
import com.example.c0823g1_movie_backend.dto.MovieStatisticDTO;
import com.example.c0823g1_movie_backend.dto.ScheduleDTO;
import com.example.c0823g1_movie_backend.model.Movie;
import com.example.c0823g1_movie_backend.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
public class MovieService implements IMovieService {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private IScheduleService scheduleService;

    @Override
    public List<IMovieDTO> getAllMovieHot() {
        return movieRepository.getAllMovieHot();
    }

    @Override
    public Page<IMovieDTO> searchMovie(String value, Pageable pageable) {
        return movieRepository.searchMovie("%" + value + "%", pageable);
    }

    @Override
    public List<IMovieDTO> getAllMovieCurrent() {
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

    /**
     * Created by DuyDD
     * Date Created: 29/02/2024
     * Function: Get a list of movies that have the highest revenue
     */
    @Override
    public Page<MovieStatisticDTO> getMovieStatistic(Pageable pageable) {
        return movieRepository.findTop20MoviesByRevenue(pageable);
    }

    @Override
    public boolean editMovie(MovieDTO movie, Set<ScheduleDTO> scheduleDTO) {
        Movie currentMovie = findMovieById(movie.getId());
        if (currentMovie != null) {
            for (ScheduleDTO schedule : scheduleDTO) {
                if (schedule.getId() != null) {
                    if (!scheduleService.editSchedule(schedule)) {
                        return false;
                    }
                } else {
                    scheduleService.createSchedule(schedule);
                }
            }
            movieRepository.editMovie(movie);
            return true;
        }
        return false;
    }

    public void createMovie(MovieDTO movie, Set<ScheduleDTO> scheduleDTOS) {
        movieRepository.create(movie);
        Long newMovieId = movieRepository.returnLastInsertId();
        for (ScheduleDTO scheduleDTO : scheduleDTOS) {
            scheduleDTO.setMovie(newMovieId);
            scheduleService.createSchedule(scheduleDTO);
        }
        System.out.println(newMovieId);
    }

    @Override
    public Movie findById(Long id) {
        return movieRepository.findByIdMovie(id).get();
    }


    @Override
    public Page<Movie> searchMovieByNameAndPublisher(String name, String publisher,
                                                     LocalDate startDate, LocalDate endDate, Pageable pageable) {
        return movieRepository.searchMovieByNameAndPublisher("%" + name + "%", "%" + publisher + "%", startDate, endDate, pageable);
    }

    @Override
    public void deleteMovieById(long id) {
        if (movieRepository.existsById(id)) {
            movieRepository.deleteMovieById(id);
        }
    }

    @Override
    public Movie findMovieById(long id) {
        return movieRepository.findMovieById(id);
    }


}
