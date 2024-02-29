package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.dto.IBookingDTO;
import com.example.c0823g1_movie_backend.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingService implements IBookingService{
    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Page<IBookingDTO> findAllBookingTicket(Pageable pageable, LocalDateTime time) {
        return bookingRepository.findAllBookingTicket(pageable,time);
    }

    @Override
    public Page<IBookingDTO> searchBookingTicketWithParameterSearch(String search, LocalDateTime time , Pageable pageable) {
        return bookingRepository.searchBookingTicketWithParameterSearch(search,time,pageable);
    }
}
