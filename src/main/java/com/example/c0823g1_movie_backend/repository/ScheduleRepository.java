package com.example.c0823g1_movie_backend.repository;

import com.example.c0823g1_movie_backend.dto.IScheduleDTO;
import com.example.c0823g1_movie_backend.dto.ScheduleDTO;
import com.example.c0823g1_movie_backend.dto.HallDTO;
import com.example.c0823g1_movie_backend.dto.IScheduleTimeDTO;
import com.example.c0823g1_movie_backend.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    @Query(value = "select * from schedule where date between curdate() and curdate() + interval 7 day and hall_id=:id and is_deleted=0", nativeQuery = true)
    List<Schedule> getScheduleByHallId(@Param("id") Long id);
    @Query(value = "SELECT date AS dateTime FROM schedule WHERE movie_id = :movieId AND date BETWEEN CURRENT_DATE AND DATE_ADD(CURRENT_DATE, INTERVAL 2 DAY) and is_deleted=0 GROUP BY dateTime ORDER BY dateTime", nativeQuery = true)
    List<IScheduleDTO> findDateByMovieId(@Param("movieId") Long movieId);

    @Query(value = "select st.id, st.schedule_time as scheduleTime\n" +
            "from schedule_time st\n" +
            "join schedule s on st.id in\n" +
            "   (select schedule_time_id from schedule where movie_id = :movieId and date = :dateTime and is_deleted=0)\n" +
            "where \n" +
            "  ( (date >= CURRENT_DATE())and movie_id = :movieId and date = :dateTime and is_deleted=0)\n" +
            "group by st.id\n" +
            "order by st.schedule_time;", nativeQuery = true)
    List<IScheduleTimeDTO> findScheduleTimeByMovieAndDate(@Param("movieId") Long movieId,
                                                          @Param("dateTime") LocalDate dateTime);

    @Query(value = "select * from schedule where movie_id = :movieId and date =:date " +
            " and schedule_time_id =:scheduleTimeId and is_deleted=0", nativeQuery = true)
    Schedule getScheduleByMovieIdAndDateAndScheduleTimeId(@Param("movieId")Long movieId,
                                                          @Param("date") LocalDate date,
                                                          @Param("scheduleTimeId") Long scheduleTimeId);

    @Query(value = "select h.id from hall h join schedule on hall_id=(select hall_id from schedule " +
                   "where id =:scheduleId) group by h.id", nativeQuery = true)
    HallDTO getHallByScheduleId(@Param("scheduleId") Long scheduleId);



    @Query(value = "select * from schedule where id=:id", nativeQuery = true)
    Schedule getScheduleById(@Param("id") Long id);

    @Modifying
    @Query(value = "insert into schedule(date, hall_id, movie_id, schedule_time_id) " +
                   "values (:#{#schedule.date},:#{#schedule.hall},:#{#schedule.movie},:#{#schedule.scheduleTime})", nativeQuery = true)
    void create(ScheduleDTO schedule);

    @Modifying
    @Query(value = "update schedule " +
                   "set is_deleted= false " +
                   "where id=:scheduleId", nativeQuery = true)
    void updateScheduleStatus(Long scheduleId);

    @Query(value = "SELECT * FROM schedule WHERE movie_id = :movieId AND date >= CURRENT_DATE and is_deleted=0 order by schedule_time_id", nativeQuery = true)
    List<Schedule> getScheduleByMovieId(@Param("movieId") Long movieId);

    @Modifying
    @Query(value = "update schedule " +
                   "set is_deleted = true " +
                   "where movie_id=:id", nativeQuery = true)
    void deleteByMovieId(Long id);
@Query(value = "select MAX(id) from schedule_time" ,nativeQuery = true)
    long getscheduleTimeMaxId();
}
