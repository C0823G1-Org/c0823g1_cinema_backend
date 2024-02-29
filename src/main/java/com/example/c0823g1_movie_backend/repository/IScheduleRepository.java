package com.example.c0823g1_movie_backend.repository;

import com.example.c0823g1_movie_backend.model.Hall;
import com.example.c0823g1_movie_backend.model.Schedule;
import com.example.c0823g1_movie_backend.model.ScheduleTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IScheduleRepository extends JpaRepository<Schedule, Long> {
    @Query(value = "select date from schedule where movie_id = :movieId ; ", nativeQuery = true)
    List<LocalDate> findDateByMovieId(@Param("movieId") Long movieId);

    @Query(value = "select st.schedule_time on schedule_time st join schedule s on st.id =" +
            "(select schedule_time_id from schedule where movie_id = :movieId and date = :date ;)", nativeQuery = true)
    List<ScheduleTime> findScheduleTimeByMovieAndDate(@Param("movieId")Long movieId,
                                                      @Param("date") LocalDate date);

    @Query(value = "select * from schedule where movie_id = :movieId and date =:date" +
            "and schedule_time_id =:scheduleTimeId", nativeQuery = true)
    Schedule getScheduleByMovieIdAndDateAndScheduleTimeId(@Param("movieId")Long movieId,
                                                          @Param("date") LocalDate date,
                                                          @Param("scheduleTimeId") Long scheduleTimeId);

    @Query(value = "select * from hall join schedule hall_id=(select hall_id from schedule " +
            "where id =:scheduleId)", nativeQuery = true)
    Hall getHallByScheduleId(@Param("scheduleId") Long scheduleId);
}
