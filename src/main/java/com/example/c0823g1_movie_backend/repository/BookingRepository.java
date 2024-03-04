package com.example.c0823g1_movie_backend.repository;

import com.example.c0823g1_movie_backend.dto.HistoryBookingDTO;
import com.example.c0823g1_movie_backend.dto.IBookingDTO;
import com.example.c0823g1_movie_backend.model.Booking;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Modifying
    @Query(value = "SELECT movie.name AS nameMovie, booking.date_booking AS dateBooking, movie.ticket_price * ticket.seat_number AS price \n" +
            "FROM booking \n" +
            "JOIN ticket ON booking.id = ticket.booking_id \n" +
            "JOIN schedule ON ticket.schedule_id = schedule.id \n" +
            "JOIN movie ON schedule.movie_id = movie.id \n" +
            "WHERE booking.account_id = :id " +
            "limit :number, 5", nativeQuery = true)
    List<HistoryBookingDTO> getListMovieByHistoryBooking(@Param("id") Long id, @Param("number") int number);


    @Modifying
    @Query(value = "select movie.name as nameMovie, booking.date_booking as dateBooking, movie.ticket_price * ticket.seat_number AS price \n" +
            "from booking\n" +
            "join ticket on booking.id = ticket.booking_id\n" +
            "join schedule on ticket.schedule_id = schedule.id\n" +
            "join movie on schedule.movie_id = movie.id\n" +
            "where booking.account_id = :id and booking.date_booking between :dateStart and :dateEnd limit :page,5", nativeQuery = true)
    List<HistoryBookingDTO> searchMovieBookingByDate(@Param("id") Long id, @Param("dateStart") LocalDateTime dateStart, @Param("dateEnd") LocalDateTime dateEnd, @Param("page") int page);

    @Query(value =
            " SELECT booking.id as bookingCode , account.id as accountId, account.full_name as nameCustomer,\n" +
                    " account.id_number as idNumber , account.phone_number as phoneNumber,\n" +
                    " booking.date_booking as dateBooking , MAX(sc.schedule_time) as scheduleTime , MAX(movie.name) as nameMovie\n" +
                    " FROM booking\n" +
                    "  left join account on booking.account_id  = account.id\n" +
                    "  left join ticket on booking.id = ticket.booking_id \n" +
                    "  left join schedule on ticket.schedule_id = schedule.id\n" +
                    "  left join schedule_time as sc on schedule.schedule_time_id = sc.id\n" +
                    "  left join movie on movie.id = schedule.movie_id\n" +
                    "  group by booking.id", nativeQuery = true)
    List<IBookingDTO> findAllBookingTicket(LocalDateTime time);


    @Query(value =
            " SELECT booking.id as bookingCode , account.id as accountId, account.full_name as nameCustomer,\n" +
                    " account.id_number as idNumber , account.phone_number as phoneNumber,\n" +
                    " booking.date_booking as dateBooking , MAX(sc.schedule_time) as scheduleTime , MAX(movie.name) as nameMovie\n" +
                    " FROM booking\n" +
                    "  left join account on booking.account_id  = account.id\n" +
                    "  left join ticket on booking.id = ticket.booking_id \n" +
                    "  left join schedule on ticket.schedule_id = schedule.id\n" +
                    "  left join schedule_time as sc on schedule.schedule_time_id = sc.id\n" +
                    "  left join movie on movie.id = schedule.movie_id\n" +
                    " where ( account.full_name like %:search%  or account.phone_number like %:search% or account.id_number like %:search% or booking.id like %:search% ) and booking.date_booking >= %:dateNow% - INTERVAL 7 DAY" +
                    "  group by booking.id", nativeQuery = true)
    List<IBookingDTO> searchBookingTicketWithParameterSearch(@Param("search") String search, @Param("dateNow") LocalDateTime dateNow);

    @Modifying
    @Query(value = "INSERT INTO booking(account_id,date_booking,print_status,is_deleted) VALUES (:accountId, :date,0,0)", nativeQuery = true)
    void saveBooking(@Param("accountId") Long id, @Param("date") LocalDateTime date);


    @Query(value = "select max(id) from booking", nativeQuery = true)
    Integer getBooking();


}
