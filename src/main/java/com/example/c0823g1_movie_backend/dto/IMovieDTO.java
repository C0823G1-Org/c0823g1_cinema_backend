package com.example.c0823g1_movie_backend.dto;

import java.time.LocalDate;

public interface IMovieDTO {
    Long getAccountId();
    Long getMovieId();
    String getName();
    String getDescription();
    String getPoster();
    LocalDate getStartDate();


}
