package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.dto.HallDTO;
import com.example.c0823g1_movie_backend.dto.IScheduleTimeDTO;
import com.example.c0823g1_movie_backend.dto.ScheduleDTO;
import com.example.c0823g1_movie_backend.model.Hall;
import com.example.c0823g1_movie_backend.dto.ScheduleDTO;
import com.example.c0823g1_movie_backend.dto.IScheduleDTO;
import com.example.c0823g1_movie_backend.dto.IScheduleTimeDTO;
import com.example.c0823g1_movie_backend.model.Schedule;
import com.example.c0823g1_movie_backend.model.ScheduleTime;
import com.example.c0823g1_movie_backend.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService implements IScheduleService {
    @Autowired
    ScheduleRepository scheduleRepository;

    @Override
    public Schedule save(Schedule schedule) {
        return null;
    }

    @Override
    public Schedule create(Schedule schedule) {
        return null;
    }
    @Override
    public List<ScheduleDTO> findDateByMovieId(Long movieId) {
        return scheduleRepository.findDateByMovieId(movieId);
    }

    @Override
    public List<IScheduleTimeDTO> findScheduleTimeByMovieAndDate(Long movieId, LocalDate date) {
        return scheduleRepository.findScheduleTimeByMovieAndDate(movieId,date);
    }

    @Override
    public Schedule getScheduleByMovieIdAndDateAndScheduleTimeId(Long movieId, LocalDate date, Long scheduleTimeId) {
        return scheduleRepository.getScheduleByMovieIdAndDateAndScheduleTimeId(movieId, date, scheduleTimeId);
    }

    @Override
    public HallDTO getHallByScheduleId(Long scheduleId) {
        return scheduleRepository.getHallByScheduleId(scheduleId);
    }

    @Override
    public List<IScheduleDTO> getScheduleByHallId(Long id) {
        return scheduleRepository.getScheduleByHallId(id);
    }

    @Override
    public Optional<Schedule> getScheduleById(Long scheduleId) {
        return Optional.ofNullable(scheduleRepository.getScheduleById(scheduleId));
    }
    @Override
    public List<Schedule> getScheduleByMovieId(Long movieId) {
        return scheduleRepository.getScheduleByMovieId(movieId);
    }
}
