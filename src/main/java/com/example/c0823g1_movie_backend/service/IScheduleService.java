package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.dto.IScheduleDTO;
import com.example.c0823g1_movie_backend.dto.HallDTO;
import com.example.c0823g1_movie_backend.dto.IScheduleTimeDTO;
import com.example.c0823g1_movie_backend.dto.ScheduleDTO;
import com.example.c0823g1_movie_backend.model.Hall;
import com.example.c0823g1_movie_backend.dto.ScheduleDTO;
import com.example.c0823g1_movie_backend.dto.IScheduleTimeDTO;
import com.example.c0823g1_movie_backend.model.Schedule;
import com.example.c0823g1_movie_backend.model.ScheduleTime;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

import java.util.List;
import java.util.Optional;

public interface IScheduleService extends IGeneralService<Schedule> {
    List<IScheduleDTO> getScheduleByHallId(Long id);

    Optional<Schedule> getScheduleById(Long scheduleId);
    List<ScheduleDTO> findDateByMovieId(Long movieId);
    List<IScheduleTimeDTO> findScheduleTimeByMovieAndDate(Long movieId, LocalDate date);
    Schedule getScheduleByMovieIdAndDateAndScheduleTimeId(Long movieId,LocalDate date,Long scheduleTimeId);
    List<Schedule> getScheduleByMovieId( Long movieId);

}
