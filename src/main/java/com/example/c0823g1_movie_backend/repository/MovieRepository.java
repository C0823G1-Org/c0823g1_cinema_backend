package com.example.c0823g1_movie_backend.repository;

import com.example.c0823g1_movie_backend.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query(value = "select id, actor, country, description, director, duration, is_deleted, name,poster, publisher, start_date, ticket_price,trailer from movie " +
            "where (name like :name or publisher like :publisher) and start_date BETWEEN :startDate AND :endDate and is_deleted = 0 ", nativeQuery = true)
    Page<Movie> searchMovieByNameAndPublisher(@Param("name") String name, @Param("publisher") String publisher
            , @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate, Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "UPDATE movie SET is_deleted = 1 where id  =:id", nativeQuery = true)
    void deleteMovieById(@Param("id") long id);

    @Query(value = "select id, actor, country, description, director, duration, is_deleted, name,poster, publisher, start_date, ticket_price,trailer from movie " +
            "where id  =:id and is_deleted =0", nativeQuery = true)
    Movie findMovieById(@Param("id") Long id);
}
