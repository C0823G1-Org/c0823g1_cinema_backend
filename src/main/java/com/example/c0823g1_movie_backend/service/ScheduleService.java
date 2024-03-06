package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.dto.IScheduleDTO;
import com.example.c0823g1_movie_backend.dto.IScheduleTimeDTO;
import com.example.c0823g1_movie_backend.model.Schedule;
import com.example.c0823g1_movie_backend.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
