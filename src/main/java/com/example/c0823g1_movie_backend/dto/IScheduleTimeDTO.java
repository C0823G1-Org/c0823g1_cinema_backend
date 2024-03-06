package com.example.c0823g1_movie_backend.dto;

import java.sql.Time;
import java.time.LocalTime;

public interface IScheduleTimeDTO {
    Long getId();

    LocalTime getDate();

    Time getTime();

}
