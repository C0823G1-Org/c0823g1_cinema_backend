package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.dto.IBookingDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface IBookingService {
    List<IBookingDTO> findAllBookingTicket(LocalDateTime time);

    List<IBookingDTO> searchBookingTicketWithParameterSearch(String search, LocalDateTime time);
}
