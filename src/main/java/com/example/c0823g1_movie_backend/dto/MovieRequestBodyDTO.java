package com.example.c0823g1_movie_backend.dto;

import jakarta.validation.Valid;
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
    @Valid
    private MovieDTO movieDTO;
    @Valid
    private Set<ScheduleDTO> scheduleDTO;
}
