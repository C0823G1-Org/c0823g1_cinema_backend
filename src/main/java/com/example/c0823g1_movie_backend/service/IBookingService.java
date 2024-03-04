package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.dto.HistoryBookingDTO;
import com.example.c0823g1_movie_backend.dto.IBookingDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.c0823g1_movie_backend.model.Movie;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface IBookingService {

    List<HistoryBookingDTO> historyBooking(Long id, int number);

    Page<IBookingDTO> findAllBookingTicket(Pageable pageable, LocalDateTime time);

    Page<IBookingDTO> searchBookingTicketWithParameterSearch(String search, LocalDateTime time,Pageable pageable);

    IBookingDTO findBookingTicketById(Integer id);

    List<IBookingDTO> listBookingTicketDetail(Integer id);

    List<HistoryBookingDTO> searchBookingByDate(Long id, LocalDateTime startDate, LocalDateTime endDate, int page);

    void saveBooking(Long accountId, LocalDateTime date);

    Integer getBooking();
}
