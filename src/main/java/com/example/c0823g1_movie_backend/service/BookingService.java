package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.dto.HistoryBookingDTO;
import com.example.c0823g1_movie_backend.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingService implements IBookingService{
    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public List<HistoryBookingDTO> historyBooking(Long id) {
        return bookingRepository.getListMovieByHistoryBooking(id);
    }

    @Override
    public List<HistoryBookingDTO> searchBookingByDate(LocalDateTime startDate, LocalDateTime endDate) {
        return bookingRepository.searchMovieBookingByDate(startDate, endDate);
    }
}
