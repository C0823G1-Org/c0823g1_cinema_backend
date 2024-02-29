package com.example.c0823g1_movie_backend.repository;

import com.example.c0823g1_movie_backend.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITicketRepository extends JpaRepository<Ticket,Long> {
    @Query(value = "select * from ticket where schedule_id =:scheduleId ", nativeQuery = true)
    List<Ticket> findAllTicketByScheduleId(@Param("scheduleId") Long scheduleId);
}
