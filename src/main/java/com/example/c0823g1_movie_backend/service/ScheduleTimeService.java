package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.repository.ScheduleTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleTimeService implements IScheduleTimeService{
    @Autowired
    ScheduleTimeRepository scheduleTimeRepository;

    @Override
    public List<com.example.c0823g1_movie_backend.model.ScheduleTime> getAll() {
        return scheduleTimeRepository.findAll();
    }
}
