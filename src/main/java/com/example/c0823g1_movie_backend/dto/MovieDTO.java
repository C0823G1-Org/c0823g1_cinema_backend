package com.example.c0823g1_movie_backend.dto;

import com.example.c0823g1_movie_backend.model.Schedule;
import com.example.c0823g1_movie_backend.model.Ticket;

import java.time.LocalDate;
import java.util.Set;

public interface MovieDTO {
    Long getAccountId();
    Long getMovieId();
    String getName();
    String getDescription();
    String getPoster();


}
