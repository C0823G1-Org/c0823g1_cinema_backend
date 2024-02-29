package com.example.c0823g1_movie_backend.repository;

import com.example.c0823g1_movie_backend.dto.IBookingDTO;
import com.example.c0823g1_movie_backend.model.Booking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {

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
    Page<IBookingDTO> findAllBookingTicket(Pageable pageable,LocalDateTime time);


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
    Page<IBookingDTO> searchBookingTicketWithParameterSearch(@Param("search") String search,@Param("dateNow")LocalDateTime dateNow,Pageable pageable);
}
