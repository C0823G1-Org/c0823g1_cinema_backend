package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.dto.HistoryBookingDTO;
import com.example.c0823g1_movie_backend.dto.IBookingDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.time.LocalDateTime;
import java.util.List;

public interface IBookingService {
    Page<HistoryBookingDTO> getHistory(Long id, LocalDateTime dateStart, LocalDateTime dateEnd, Pageable pageable);

    Page<IBookingDTO> findAllBookingTicket(Pageable pageable, LocalDateTime time);

    Page<IBookingDTO> searchBookingTicketWithParameterSearch(String search, LocalDateTime time, Pageable pageable);

    IBookingDTO findBookingTicketById(Long id);

    List<IBookingDTO> listBookingTicketDetail(Long id);

    void saveBooking(Long accountId, LocalDateTime date);

    Long getBooking();

    void sendMail(Long accountId, Long scheduleId, String seat, Long id, Long total);

    void addAccumulatedPoints(Long id, int accumulatedPoints);

    void removeBooking(Long bookingId);

    Page<IBookingDTO> searchBookingTicketWithParameterSearchAndDate(String search, LocalDateTime dateSearch, Pageable pageable);

    Page<IBookingDTO> searchBookingTicketWithParameterDate(LocalDateTime dateSearch, Pageable pageable);

    void setPrintStatus(Long id);

    Long getBookingById(Long accountId);
}
