package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.dto.IScheduleDTO;
import com.example.c0823g1_movie_backend.model.Schedule;

import java.util.List;
import java.util.Optional;

public interface IScheduleService extends IGeneralService<Schedule> {
    List<IScheduleDTO> getScheduleByHallId(Long id);

    Optional<Schedule> getScheduleById(Long scheduleId);
}
