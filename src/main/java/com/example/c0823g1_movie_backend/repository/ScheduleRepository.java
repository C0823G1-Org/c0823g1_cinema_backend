package com.example.c0823g1_movie_backend.repository;

import com.example.c0823g1_movie_backend.dto.ScheduleDTO;
import com.example.c0823g1_movie_backend.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    @Query(value = "select * from schedule where date between curdate() and curdate() + interval 7 day and hall_id=:id and is_deleted=0", nativeQuery = true)
    List<Schedule> getScheduleByHallId(@Param("id") Long id);

    @Query(value = "select * from schedule where id=:id", nativeQuery = true)
    Schedule getScheduleById(@Param("id") Long id);

    @Modifying
    @Query(value = "insert into schedule(date, hall_id, movie_id, schedule_time_id) " +
            "values (:#{#schedule.date},:#{#schedule.hall},:#{#schedule.movie},:#{#schedule.scheduleTime})", nativeQuery = true)
    void create(ScheduleDTO schedule);

    @Modifying
    @Query(value = "update schedule " +
            "set date=:#{#schedule.date}, hall_id=:#{#schedule.hall}, movie_id=:#{#schedule.movie}, schedule_time_id=:#{#schedule.scheduleTime} " +
            "where id=:#{#schedule.id}", nativeQuery = true)
    void editSchedule(ScheduleDTO schedule);
}
