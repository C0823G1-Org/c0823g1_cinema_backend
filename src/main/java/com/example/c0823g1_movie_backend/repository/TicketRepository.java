package com.example.c0823g1_movie_backend.repository;

import com.example.c0823g1_movie_backend.model.Ticket;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Transactional
public interface TicketRepository extends JpaRepository<Ticket,Long> {

    @Modifying
    @Query(value = "INSERT INTO ticket(seat_number,booking_id,schedule_id,is_deleted) VALUES (:seat, :booking,:schedule,1)", nativeQuery = true)
    void saveTicket(@Param("seat") Integer seat, @Param("booking") Long bookId,@Param("schedule") Long scheduleId);


    @Query(value = "select * from ticket where seat_number = :seat and schedule_id = :scheduleId", nativeQuery = true)
    List<Ticket> checkExist(@Param("seat") Integer seat, @Param("scheduleId") Long scheduleId);


    @Modifying
    @Query(value = "delete from ticket where booking_id = :bookingId and schedule_id = :scheduleId", nativeQuery = true)
    void removeTicket(@Param("bookingId") Long bookingId, @Param("scheduleId") Long scheduleId);

    @Query(value = "select * from ticket where schedule_id =:scheduleId and is_deleted=0 ", nativeQuery = true)
    List<Ticket> findAllTicketByScheduleId(@Param("scheduleId") Long scheduleId);

    @Modifying
    @Query(value = "update ticket set is_deleted = 0 where booking_id = :bookingId and schedule_id = :scheduleId", nativeQuery = true)
    void updateTicket(@Param("bookingId") Long bookingId, @Param("scheduleId") Long scheduleId);
}
