package com.example.c0823g1_movie_backend.repository;

import com.example.c0823g1_movie_backend.model.Hall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HallRepository extends JpaRepository<Hall,Long> {
}
