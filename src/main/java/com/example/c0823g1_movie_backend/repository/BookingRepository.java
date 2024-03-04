package com.example.c0823g1_movie_backend.repository;

import com.example.c0823g1_movie_backend.dto.HistoryBookingDTO;
import com.example.c0823g1_movie_backend.dto.IBookingDTO;
import com.example.c0823g1_movie_backend.model.Booking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Query(value =
            " SELECT booking.id as bookingCode , account.id as accountId, account.full_name as nameCustomer,\n" +
            " account.id_number as idNumber , account.phone_number as phoneNumber,\n" +
            " booking.date_booking as dateBooking ,MAX(sc.schedule_time) as scheduleTime , MAX(movie.name) as nameMovieFilm\n" +
                    ", booking.print_status as printStatus\n"+
            " FROM booking\n" +
            "  left join account on booking.account_id  = account.id\n" +
            "  left join ticket on booking.id = ticket.booking_id \n" +
            "  left join schedule on ticket.schedule_id = schedule.id\n" +
            "  left join schedule_time as sc on schedule.schedule_time_id = sc.id\n" +
            "  left join movie on movie.id = schedule.movie_id\n" +
                    "where booking.id = 0\n"+
            "  group by booking.id", nativeQuery = true)
    Page<IBookingDTO> findAllBookingTicket(Pageable pageable,LocalDateTime time);


    @Query(value =
            " SELECT booking.id as bookingCode , account.id as accountId, account.full_name as nameCustomer,\n" +
                    " account.id_number as idNumber , account.phone_number as phoneNumber,\n" +
                    " booking.date_booking as dateBooking , MAX(sc.schedule_time) as scheduleTime , MAX(movie.name) as nameMovieFilm\n" +
                    " FROM booking\n" +
                    "  left join account on booking.account_id  = account.id\n" +
                    "  left join ticket on booking.id = ticket.booking_id \n" +
                    "  left join schedule on ticket.schedule_id = schedule.id\n" +
                    "  left join schedule_time as sc on schedule.schedule_time_id = sc.id\n" +
                    "  left join movie on movie.id = schedule.movie_id\n" +
                    " where ( account.full_name like %:search%  or account.phone_number like %:search% or account.id_number like %:search% or booking.id like %:search% ) and booking.date_booking >= %:dateNow% - INTERVAL 7 DAY" +
                    "  group by booking.id", nativeQuery = true)
    Page<IBookingDTO> searchBookingTicketWithParameterSearch(@Param("search") String search,@Param("dateNow")LocalDateTime dateNow,Pageable pageable);

    @Query(value = "SELECT booking.id as bookingCode ,booking.print_status as printStatus, account.id as accountId, account.full_name as nameCustomer,\n" +
            " account.id_number as idNumber , account.phone_number as phoneNumber,\n" +
            " booking.date_booking as dateBooking , MAX(sc.schedule_time) as scheduleTime ,MAX(movie.name) as nameMovieFilm\n" +
            " FROM booking\n" +
            "  left join account on booking.account_id  = account.id\n" +
            "  left join ticket on booking.id = ticket.booking_id \n" +
            "  left join schedule on ticket.schedule_id = schedule.id\n" +
            "  left join schedule_time  as sc on `schedule`.schedule_time_id = sc.id\n" +
            "  left join movie on movie.id = schedule.movie_id\n" +
            "  where ( booking.id = :idBook) \n" +
            "  group by booking.id;",nativeQuery = true)
    IBookingDTO findBookingTicketById(@Param("idBook") Integer idBook);


    @Query(value =
            "SELECT booking.id as bookingCode, booking.print_status as printStatus, account.id as accountId, account.full_name as nameCustomer,\n" +
                    " account.id_number as idNumber, account.phone_number as phoneNumber, movie.ticket_price as ticketPrice,\n" +
                    " booking.date_booking as dateBooking, MAX(sc.schedule_time) as scheduleTime, MAX(movie.name) as nameMovieFilm, ticket.seat_number as seatNumber, MAX(movie.ticket_price) as ticketPrice, MAX(hall.name ) as cinemaHall\n" +
                    " FROM booking\n" +
                    " LEFT JOIN account ON booking.account_id = account.id\n" +
                    " LEFT JOIN ticket ON booking.id = ticket.booking_id \n" +
                    " LEFT JOIN schedule ON ticket.schedule_id = schedule.id\n" +
                    " LEFT JOIN schedule_time as sc ON schedule.schedule_time_id = sc.id\n" +
                    " LEFT JOIN movie ON movie.id = schedule.movie_id\n" +
                    "JOIN hall ON hall.id = schedule.hall_id\n"+
                    " WHERE booking.id = :idBook\n" +
                    " GROUP BY booking.id, booking.print_status, account.id, account.full_name, account.id_number, account.phone_number, movie.ticket_price, booking.date_booking, ticket.seat_number;",
            nativeQuery = true)
    List<IBookingDTO> listBookingTicketDetail(@Param("idBook") Integer idBook);

    @Modifying
    @Query(value = "INSERT INTO booking(account_id,date_booking,print_status,is_deleted) VALUES (:accountId, :date,0,0)", nativeQuery = true)
    void saveBooking(@Param("accountId") Long id, @Param("date") LocalDateTime date);


    @Query(value = "select max(id) from booking", nativeQuery = true)
    Integer getBooking();


@Query(value =
        " SELECT booking.id as bookingCode , account.id as accountId, account.full_name as nameCustomer,\n" +
                " account.id_number as idNumber , account.phone_number as phoneNumber,\n" +
                " booking.date_booking as dateBooking , MAX(sc.schedule_time) as scheduleTime , MAX(movie.name) as nameMovieFilm\n" +
                " FROM booking\n" +
                "  left join account on booking.account_id  = account.id\n" +
                "  left join ticket on booking.id = ticket.booking_id \n" +
                "  left join schedule on ticket.schedule_id = schedule.id\n" +
                "  left join schedule_time as sc on schedule.schedule_time_id = sc.id\n" +
                "  left join movie on movie.id = schedule.movie_id\n" +
                " where ( account.full_name like %:search%  or account.phone_number like %:search% or account.id_number like %:search% or booking.id like %:search% ) and booking.date_booking >= %:dateSearch%" +
                "  group by booking.id", nativeQuery = true)
    Page<IBookingDTO> searchBookingTicketWithParameterSearchAndDate(@Param("search") String search, @Param("dateSearch") LocalDateTime dateNow, Pageable pageable);

    @Query(value =
            " SELECT booking.id as bookingCode , account.id as accountId, account.full_name as nameCustomer,\n" +
                    " account.id_number as idNumber , account.phone_number as phoneNumber,\n" +
                    " booking.date_booking as dateBooking , MAX(sc.schedule_time) as scheduleTime , MAX(movie.name) as nameMovieFilm\n" +
                    " FROM booking\n" +
                    "  left join account on booking.account_id  = account.id\n" +
                    "  left join ticket on booking.id = ticket.booking_id \n" +
                    "  left join schedule on ticket.schedule_id = schedule.id\n" +
                    "  left join schedule_time as sc on schedule.schedule_time_id = sc.id\n" +
                    "  left join movie on movie.id = schedule.movie_id\n" +
                    " where  booking.date_booking >= %:dateSearch%" +
                    "  group by booking.id", nativeQuery = true)
    Page<IBookingDTO> searchBookingTicketWithParameterDate(LocalDateTime dateSearch, Pageable pageable);
}
