package com.example.c0823g1_movie_backend.repository;

import com.example.c0823g1_movie_backend.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
