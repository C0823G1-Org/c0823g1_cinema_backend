package com.example.c0823g1_movie_backend.repository;

import com.example.c0823g1_movie_backend.model.Ticket;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
@Repository
@Transactional
public interface TicketRepository extends JpaRepository<Ticket,Long> {

    @Modifying
    @Query(value = "INSERT INTO ticket(seat_number,booking_id,schedule_id,is_deleted) VALUES (:seat, :booking,:schedule,0)", nativeQuery = true)
    void saveTicket(@Param("seat") Integer seat, @Param("booking") Integer id,@Param("schedule") Long scheduleId);
}
