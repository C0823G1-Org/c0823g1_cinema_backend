package com.example.c0823g1_movie_backend.repository;

import com.example.c0823g1_movie_backend.model.MovieHasGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface MovieHasGenreRepository extends JpaRepository<MovieHasGenre,Long> {
    List<MovieHasGenre> findAllByMovieId(Long id);
    void deleteAllByMovieId(Long id);
}
