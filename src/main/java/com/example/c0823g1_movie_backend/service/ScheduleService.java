package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.dto.ScheduleDTO;
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
    public com.example.c0823g1_movie_backend.model.Schedule save(com.example.c0823g1_movie_backend.model.Schedule schedule) {
        return null;
    }

    @Override
    public com.example.c0823g1_movie_backend.model.Schedule create(com.example.c0823g1_movie_backend.model.Schedule schedule) {
        return null;
    }

    @Override
    public List<Schedule> getScheduleByHallId(Long id) {
        List<Schedule> schedules = scheduleRepository.getScheduleByHallId(id);
        for (Schedule schedule : schedules) {
            System.out.println(schedule.getId());
        }

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
}
