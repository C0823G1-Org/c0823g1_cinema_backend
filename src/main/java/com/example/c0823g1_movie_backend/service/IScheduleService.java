package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.model.Hall;
import com.example.c0823g1_movie_backend.model.Schedule;
import com.example.c0823g1_movie_backend.model.ScheduleTime;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IScheduleService {
    List<LocalDate> findDateByMovieId(Long movieId);
    List<ScheduleTime> findScheduleTimeByMovieAndDate(Long movieId,LocalDate date);
    Schedule getScheduleByMovieIdAndDateAndScheduleTimeId(Long movieId,LocalDate date,Long scheduleTimeId);
    Hall getHallByScheduleId(Long scheduleId);
}
