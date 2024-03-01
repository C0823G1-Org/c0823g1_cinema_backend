package com.example.c0823g1_movie_backend.model;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.Set;

@Entity
public class ScheduleTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    LocalTime scheduleTime;


    public ScheduleTime() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(LocalTime scheduleTime) {
        this.scheduleTime = scheduleTime;
    }


}
