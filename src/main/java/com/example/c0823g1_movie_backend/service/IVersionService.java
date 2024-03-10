package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.model.Version;

import java.util.List;

public interface IVersionService {
    List<Version> getAll();

    void addMovieHasVersion(Long newMovieId, Long versionId);

    List<Long> getVersionByMovieId(Long id);
}
