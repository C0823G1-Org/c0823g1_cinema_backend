package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.model.Movie;

import java.util.List;

public interface IMovieService extends IGeneralService{
    List<Movie> getAllMovieHot();
}
