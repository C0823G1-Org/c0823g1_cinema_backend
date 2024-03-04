package com.example.c0823g1_movie_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieRequestBodyDTO {
    private MovieDTO movieDTO;
    private Set<ScheduleDTO> scheduleDTO;
}
