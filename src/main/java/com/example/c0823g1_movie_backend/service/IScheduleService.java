package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.dto.ScheduleDTO;
import com.example.c0823g1_movie_backend.model.Schedule;

import java.util.List;
import java.util.Optional;

public interface IScheduleService extends IGeneralService<com.example.c0823g1_movie_backend.model.Schedule> {
    List<Schedule> getScheduleByHallId(Long id);

    Optional<com.example.c0823g1_movie_backend.model.Schedule> getScheduleById(Long scheduleId);

    void createSchedule(ScheduleDTO scheduleDTO);

    boolean editSchedule(ScheduleDTO schedule);
}
