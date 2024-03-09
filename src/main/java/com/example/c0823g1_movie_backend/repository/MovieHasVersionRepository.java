package com.example.c0823g1_movie_backend.repository;

import com.example.c0823g1_movie_backend.model.MovieHasVersion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieHasVersionRepository extends JpaRepository<MovieHasVersion,Long> {
    List<MovieHasVersion> findAllByMovieId(Long id);

    void deleteAllByMovieId(Long id);
}
