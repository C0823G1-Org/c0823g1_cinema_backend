package com.example.c0823g1_movie_backend.dto;

import com.example.c0823g1_movie_backend.model.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {
    private Long id;
    private String name;
    private LocalDate startDate;
    private String actor;
    private String director;
    private String publisher;
    private Integer duration;
    private String trailer;
    private String country;
    private String description;
    private String poster;
    private Integer ticketPrice;

    public MovieDTO(String name) {
        this.name = name;
    }
}
