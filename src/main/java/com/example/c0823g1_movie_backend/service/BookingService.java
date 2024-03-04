package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.dto.HistoryBookingDTO;
import com.example.c0823g1_movie_backend.dto.IBookingDTO;
import com.example.c0823g1_movie_backend.model.Movie;
import com.example.c0823g1_movie_backend.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService implements IBookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public List<HistoryBookingDTO> historyBooking(Long id, int number) {
        return bookingRepository.getListMovieByHistoryBooking(id, number);
    }

    @Override
    public List<HistoryBookingDTO> searchBookingByDate(Long id, LocalDateTime startDate, LocalDateTime endDate, int page) {
        return bookingRepository.searchMovieBookingByDate(id, startDate, endDate, page);
    }

    public List<IBookingDTO> findAllBookingTicket(LocalDateTime time) {
        return bookingRepository.findAllBookingTicket(time);
    }

    @Override
    public List<IBookingDTO> searchBookingTicketWithParameterSearch(String search, LocalDateTime time) {
        return bookingRepository.searchBookingTicketWithParameterSearch(search, time);
    }


    @Override
    public void saveBooking(Long accountId, LocalDateTime date) {
        bookingRepository.saveBooking(accountId, date);
    }

    @Override
    public Integer getBooking() {
        return bookingRepository.getBooking();
    }

}
