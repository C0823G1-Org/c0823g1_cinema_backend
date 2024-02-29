package com.example.c0823g1_movie_backend.repository;

import com.example.c0823g1_movie_backend.dto.HistoryBookingDTO;
import com.example.c0823g1_movie_backend.model.Booking;
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
public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Modifying
    @Query(value = "SELECT m.name AS nameMovie, b.dateBooking AS dateBooking FROM Booking b INNER JOIN Ticket t ON b.id = t.booking.id INNER JOIN Schedule s ON t.schedule.id = s.id INNER JOIN Movie m ON s.movie.id = m.id WHERE b.account.id = :id ORDER BY b.dateBooking DESC")
    List<HistoryBookingDTO> getListMovieByHistoryBooking(@Param("id") Long id);

    @Modifying
    @Query(value = "SELECT m.name AS nameMovie, b.dateBooking AS dateBooking FROM Booking b INNER JOIN Ticket t ON b.id = t.booking.id INNER JOIN Schedule s ON t.schedule.id = s.id INNER JOIN Movie m ON s.movie.id = m.id WHERE b.account.id = :id and b.dateBooking BETWEEN :dateStart and  :dateEnd ORDER BY b.dateBooking DESC")
    List<HistoryBookingDTO> searchMovieBookingByDate(@Param("dateStart") LocalDateTime dateStart, @Param("dateEnd") LocalDateTime dateEnd);

}
