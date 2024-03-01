package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.dto.HistoryBookingDTO;
import com.example.c0823g1_movie_backend.dto.IBookingDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface IBookingService {
    List<HistoryBookingDTO> historyBooking(Long id);

    List<HistoryBookingDTO> searchBookingByDate(LocalDateTime startDate, LocalDateTime endDate);

    List<IBookingDTO> findAllBookingTicket(LocalDateTime time);

    List<IBookingDTO> searchBookingTicketWithParameterSearch(String search, LocalDateTime time);
    

    void saveBooking(Long accountId, LocalDateTime date);

    Integer getBooking();
}
