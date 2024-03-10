package com.example.c0823g1_movie_backend.repository;

import com.example.c0823g1_movie_backend.model.Version;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface VersionRepository extends JpaRepository<Version, Long> {
    @Query(value = "select * from version", nativeQuery = true)
    List<Version> getAll();

    @Modifying
    @Query(value = "insert into movie_has_version(movie_id, version_id) values (:newMovieId,:versionId)", nativeQuery = true)
    void addMovieHasVersion(Long newMovieId, Long versionId);

    @Query(value = "select version_id from movie_has_version where movie_id=:id", nativeQuery = true)
    List<Long> getVersionByMovieId(Long id);
}
