package com.example.c0823g1_movie_backend.repository;

import com.example.c0823g1_movie_backend.dto.IScheduleDTO;
import com.example.c0823g1_movie_backend.dto.IScheduleTimeDTO;
import com.example.c0823g1_movie_backend.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    @Query(value = "select * from schedule where date>=current_date and hall_id=:id", nativeQuery = true)
    List<IScheduleDTO> getScheduleByHallId(@Param("id") Long id);

    @Query(value = "select * from schedule where id=:id", nativeQuery = true)
    Schedule getScheduleById(@Param("id") Long id);

    @Query(value = "SELECT * FROM schedule WHERE movie_id = :movieId AND date >= CURRENT_DATE order by schedule_time_id", nativeQuery = true)
    List<Schedule> getScheduleByMovieId(@Param("movieId") Long movieId);
}
