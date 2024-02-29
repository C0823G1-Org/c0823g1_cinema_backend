package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.model.Hall;
import com.example.c0823g1_movie_backend.model.Schedule;
import com.example.c0823g1_movie_backend.model.ScheduleTime;
import com.example.c0823g1_movie_backend.repository.IScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class ScheduleServiceImpl implements IScheduleService {
    @Autowired
    IScheduleRepository scheduleRepository;
    @Override
    public List<LocalDate> findDateByMovieId(Long movieId) {
        return scheduleRepository.findDateByMovieId(movieId);
    }

    @Override
    public List<ScheduleTime> findScheduleTimeByMovieAndDate(Long movieId, LocalDate date) {
        return scheduleRepository.findScheduleTimeByMovieAndDate(movieId,date);
    }

    @Override
    public Schedule getScheduleByMovieIdAndDateAndScheduleTimeId(Long movieId, LocalDate date, Long scheduleTimeId) {
        return scheduleRepository.getScheduleByMovieIdAndDateAndScheduleTimeId(movieId, date, scheduleTimeId);
    }

    @Override
    public Hall getHallByScheduleId(Long scheduleId) {
        return scheduleRepository.getHallByScheduleId(scheduleId);
    }
}
