package com.example.c0823g1_movie_backend.dto;

import com.example.c0823g1_movie_backend.model.Genre;
import com.example.c0823g1_movie_backend.model.Version;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieAttributeDTO {
    List<Genre> genres;
    List<Version> versions;
}
