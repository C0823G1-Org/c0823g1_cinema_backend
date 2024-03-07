package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.dto.ScheduleDTO;
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
    public com.example.c0823g1_movie_backend.model.Schedule save(com.example.c0823g1_movie_backend.model.Schedule schedule) {
        return null;
    }

    @Override
    public com.example.c0823g1_movie_backend.model.Schedule create(com.example.c0823g1_movie_backend.model.Schedule schedule) {
        return null;
    }
    @Override
    public List<IScheduleDTO> findDateByMovieId(Long movieId) {
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
    public List<Schedule> getScheduleByHallId(Long id) {
        return scheduleRepository.getScheduleByHallId(id);
    }

    @Override
    public Optional<com.example.c0823g1_movie_backend.model.Schedule> getScheduleById(Long scheduleId) {
        return Optional.ofNullable(scheduleRepository.getScheduleById(scheduleId));
    }

    @Override
    public void createSchedule(ScheduleDTO scheduleDTO) {
        scheduleRepository.create(scheduleDTO);
    }

    @Override
    public boolean editSchedule(ScheduleDTO schedule) {
        if (getScheduleById(schedule.getId()).isPresent()) {
            scheduleRepository.editSchedule(schedule);
            return true;
        }
        return false;
    }
    @Override
    public List<Schedule> getScheduleByMovieId(Long movieId) {
        return scheduleRepository.getScheduleByMovieId(movieId);
    }

}
