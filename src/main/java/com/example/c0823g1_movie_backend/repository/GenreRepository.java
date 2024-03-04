package com.example.c0823g1_movie_backend.repository;

import com.example.c0823g1_movie_backend.model.Genre;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface GenreRepository extends JpaRepository<Genre, Long> {
    @Query(value = "SELECT g.id AS genre_id, g.name AS genre_name FROM Movie AS m INNER JOIN MovieHasGenre AS mh ON mh.movie.id = m.id INNER JOIN Genre AS g ON g.id = mh.genre.id WHERE m.id = :id")
    Iterable<Genre> getListMovieHasGenreById(Long id);
    @Query(value = "select * from genre",nativeQuery = true)
    List<Genre> getAll();
}
