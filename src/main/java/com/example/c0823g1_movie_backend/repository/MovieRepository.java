package com.example.c0823g1_movie_backend.repository;

import com.example.c0823g1_movie_backend.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query(value = "SELECT m.name AS movie_name, COUNT(b.id) AS ticket_count " +
            "FROM movie m " +
            "JOIN schedule s ON m.id = s.movie_id " +
            "JOIN booking b ON s.id = b.schedule_id " +
            "WHERE s.is_deleted = 0 AND m.is_deleted = 0 AND b.is_deleted = 0 " +
            "GROUP BY m.name " +
            "ORDER BY ticket_count DESC " +
            "LIMIT 20", nativeQuery = true)
    Page<Movie> findTop20MoviesByRevenue(Pageable pageable);
}
