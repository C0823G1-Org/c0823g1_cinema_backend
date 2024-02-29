package com.example.c0823g1_movie_backend.repository;

import com.example.c0823g1_movie_backend.model.Booking;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
@Transactional
public interface TicketBookingRepository extends JpaRepository<Booking, Long> {
    @Modifying
    @Query(value = "INSERT INTO booking(account_id,date_booking,print_status,is_deleted) VALUES (:accountId, :date,0,0)", nativeQuery = true)
    void saveBooking(@Param("accountId") Long id, @Param("date") LocalDateTime date);


    @Query(value = "select max(id) from booking", nativeQuery = true)
    Integer getBooking();


}
