package com.example.c0823g1_movie_backend.repository;

import com.example.c0823g1_movie_backend.model.Version;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VersionRepository extends JpaRepository<Version, Long> {
    @Query(value = "select * from version", nativeQuery = true)
    List<Version> getAll();
}
