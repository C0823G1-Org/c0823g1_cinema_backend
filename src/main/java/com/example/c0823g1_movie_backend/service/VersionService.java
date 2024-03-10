package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.model.Version;
import com.example.c0823g1_movie_backend.repository.VersionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VersionService implements IVersionService{
    @Autowired
    VersionRepository versionRepository;
    @Override
    public List<Version> getAll() {
        return versionRepository.getAll();
    }

    @Override
    public void addMovieHasVersion(Long newMovieId, Long versionId) {
        versionRepository.addMovieHasVersion(newMovieId,versionId);
    }

    @Override
    public List<Long> getVersionByMovieId(Long id) {
        return versionRepository.getVersionByMovieId(id);
    }
}
