package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.model.Schedule;
import com.example.c0823g1_movie_backend.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
