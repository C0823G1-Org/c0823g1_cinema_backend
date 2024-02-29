package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.dto.IBookingDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

public interface IBookingService {
    Page<IBookingDTO> findAllBookingTicket(Pageable pageable, LocalDateTime time);

    Page<IBookingDTO> searchBookingTicketWithParameterSearch(String search, LocalDateTime time,Pageable pageable);
}
