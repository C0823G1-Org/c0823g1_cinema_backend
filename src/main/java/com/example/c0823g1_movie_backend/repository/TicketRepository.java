package com.example.c0823g1_movie_backend.repository;

import com.example.c0823g1_movie_backend.dto.ITicketDTO;
import com.example.c0823g1_movie_backend.model.Ticket;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
@Transactional
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Modifying
    @Query(value = "INSERT INTO ticket(seat_number,booking_id,schedule_id,is_deleted,status) VALUES (:seat, :booking,:schedule,0,1)", nativeQuery = true)
    void saveTicket(@Param("seat") Integer seat, @Param("booking") Long bookId,@Param("schedule") Long scheduleId);


    @Query(value = "select * from ticket where booking_id = :bookingId and seat_number = :seat and schedule_id = :scheduleId", nativeQuery = true)
    List<Ticket> checkExist(@Param("bookingId") Long bookingId, @Param("scheduleId") Long scheduleId,@Param("seat") Integer seat);


    @Modifying
    @Query(value = "delete from ticket where booking_id = :bookingId and schedule_id = :scheduleId", nativeQuery = true)
    void removeTicket(@Param("bookingId") Long bookingId, @Param("scheduleId") Long scheduleId);

    @Query(value = "select * from ticket where schedule_id =:scheduleId ", nativeQuery = true)
    List<Ticket> findAllTicketByScheduleId(@Param("scheduleId") Long scheduleId);

    @Modifying
    @Query(value = "update ticket set status = false where booking_id = :bookingId", nativeQuery = true)
    void updateTicket(@Param("bookingId") Long bookingId);


    @Query(value = "select ticket.id as id,\n" +
            "ticket.is_deleted as isDeleted,\n" +
            "ticket.booking_id as bookingId,\n" +
            "booking.date_booking as dateBooking\n" +
            "from ticket join booking where ticket.booking_id = booking.id and ticket.status = true", nativeQuery = true)
    List<ITicketDTO> findAllByStatus();

    @Query(value = "select ticket.id as id,\n" +
            "ticket.is_deleted as isDeleted,\n" +
            "ticket.booking_id as bookingId,\n" +
            "booking.date_booking as dateBooking\n" +
            "from ticket join booking where ticket.booking_id = booking.id and ticket.seat_number = :seatN and ticket.schedule_id = :scheduleId", nativeQuery = true)
    Optional<ITicketDTO> findBySeatAndScheduleId(@Param("seatN") Integer seatN, @Param("scheduleId") Long scheduleId);

    @Query(value = "select ticket.id as id,\n" +
            "ticket.is_deleted as isDeleted,\n" +
            "ticket.booking_id as bookingId,\n" +
            "ticket.status as status,\n" +
            "booking.date_booking as dateBooking\n" +
            "from ticket join booking where ticket.booking_id = booking.id and ticket.seat_number = :seatN and ticket.booking_id = :bookingId", nativeQuery = true)
    Optional<ITicketDTO> findBySeatAndBookingId(@Param("seatN") Integer seatN,@Param("bookingId") Long bookingId);
}
