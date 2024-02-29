package com.example.c0823g1_movie_backend.repository;

import com.example.c0823g1_movie_backend.dto.HallDTO;
import com.example.c0823g1_movie_backend.model.Hall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HallRepository extends JpaRepository<Hall,Long> {
    @Query(value = "",nativeQuery = true)
    HallDTO findHallById(@Param("id") Long id);
}
