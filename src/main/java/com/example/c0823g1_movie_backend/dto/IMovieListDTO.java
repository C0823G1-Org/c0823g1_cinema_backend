package com.example.c0823g1_movie_backend.dto;

import java.time.LocalDate;

public interface IMovieListDTO {
     Long getId();
     String getName();
     LocalDate getStartDate();
     String getPublisher();
     Integer getDuration();
     String getVersions();
}
