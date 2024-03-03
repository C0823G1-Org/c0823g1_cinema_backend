package com.example.c0823g1_movie_backend.repository;

import com.example.c0823g1_movie_backend.dto.HallDTO;
import com.example.c0823g1_movie_backend.dto.IScheduleTimeDTO;
import com.example.c0823g1_movie_backend.dto.ScheduleDTO;
import com.example.c0823g1_movie_backend.model.Hall;
import com.example.c0823g1_movie_backend.dto.ScheduleDTO;
import com.example.c0823g1_movie_backend.model.Schedule;
import com.example.c0823g1_movie_backend.model.ScheduleTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDate;
import java.util.List;

import java.util.List;

@Repository
@Transactional
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    @Query(value = "select date as dateTime from schedule where movie_id = :movieId ; ", nativeQuery = true)
    List<ScheduleDTO> findDateByMovieId(@Param("movieId") Long movieId);

    @Query(value = "select st.schedule_time as scheduleTime from schedule_time st join schedule s on st.id in" +
            "(select schedule_time_id from schedule where movie_id = :movieId and date = :dateTime) group by st.id", nativeQuery = true)
    List<IScheduleTimeDTO> findScheduleTimeByMovieAndDate(@Param("movieId")Long movieId,
                                                          @Param("dateTime") LocalDate dateTime);

    @Query(value = "select * from schedule where movie_id = :movieId and date =:date " +
            " and schedule_time_id =:scheduleTimeId", nativeQuery = true)
    Schedule getScheduleByMovieIdAndDateAndScheduleTimeId(@Param("movieId")Long movieId,
                                                          @Param("date") LocalDate date,
                                                          @Param("scheduleTimeId") Long scheduleTimeId);

    @Query(value = "select name from hall h join schedule on hall_id=(select hall_id from schedule " +
            "where id =:scheduleId) group by h.id", nativeQuery = true)
    HallDTO getHallByScheduleId(@Param("scheduleId") Long scheduleId);

    @Query(value = "select * from schedule where date>=current_date and hall_id=:id", nativeQuery = true)
    List<ScheduleDTO> getScheduleByHallId(@Param("id") Long id);
}
