package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.dto.*;
import com.example.c0823g1_movie_backend.model.Movie;
import com.example.c0823g1_movie_backend.repository.MovieHasGenreRepository;
import com.example.c0823g1_movie_backend.repository.MovieHasVersionRepository;
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
    @Autowired
    private IVersionService versionService;
    @Autowired
    private IGenreService genreService;
    @Autowired
    private MovieHasGenreRepository movieHasGenreRepository;
    @Autowired
    private MovieHasVersionRepository movieHasVersionRepository;

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
    public Page<MovieStatisticDTO> getMovieStatistic(String name,Pageable pageable) {
        return movieRepository.findTop20MoviesByRevenue("%"+ name.trim() +"%",pageable);
    }

    @Override
    public boolean editMovie(MovieDTO movie, Set<ScheduleDTO> scheduleDTO, List<Long> versions, List<Long> genres) {
        Movie currentMovie = findMovieById(movie.getId());
        if (currentMovie == null) return false;
        movieRepository.editMovie(movie);

        //replace with new genres and versions
        movieHasGenreRepository.deleteAllByMovieId(currentMovie.getId());
        movieHasVersionRepository.deleteAllByMovieId(currentMovie.getId());
        for (Long versionId : versions) {
            versionService.addMovieHasVersion(currentMovie.getId(), versionId);
        }
        for (Long genreId : genres) {
            genreService.addMovieHasGenre(currentMovie.getId(), genreId);
        }

        //remove current schedules
        scheduleService.deleteScheduleByMovieId(currentMovie.getId());

        //update movie schedule
        for (ScheduleDTO schedule : scheduleDTO) {
            schedule.setMovie(movie.getId());
            if (schedule.getId() != null) {
                if (schedule.getId() < 0) continue;
                scheduleService.editSchedule(schedule);
            } else {
                scheduleService.createSchedule(schedule);
            }
        }

        return true;
    }

    public void createMovie(MovieDTO movie, Set<ScheduleDTO> scheduleDTOS, List<Long> versions, List<Long> genres) {
        movieRepository.create(movie);
        Long newMovieId = movieRepository.returnLastInsertId();
        for (ScheduleDTO scheduleDTO : scheduleDTOS) {
            scheduleDTO.setMovie(newMovieId);
            scheduleService.createSchedule(scheduleDTO);
        }
        for (Long versionId : versions) {
            versionService.addMovieHasVersion(newMovieId, versionId);
        }
        for (Long genreId : genres) {
            genreService.addMovieHasGenre(newMovieId, genreId);
        }
        System.out.println(newMovieId);
    }

    @Override
    public Movie findById(Long id) {
        return movieRepository.findByIdMovie(id).orElse(null);
    }

    @Override
    public Page<IMovieListDTO> searchMovieByNameAndPublisher(String name, String publisher,
                                                             LocalDate startDate, LocalDate endDate, Pageable pageable) {
        return movieRepository.searchMovieByNameAndPublisher("%" + name.trim() + "%", "%" + publisher.trim() + "%", startDate, endDate, pageable);
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

    @Override
    public List<IMovieDTO> getAllMovieCurrentTo3Day() {
        return movieRepository.getAllMovieCurrentTo3Day();
    }
}
