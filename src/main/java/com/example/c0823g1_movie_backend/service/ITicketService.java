package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.model.Ticket;


import java.util.List;
public interface ITicketService {
    void saveTicket(Integer seat, Long id, Long scheduleId);

    List<Ticket> checkExist(Integer seat, Long scheduleId);

    void removeTicket(Long bookingId,Long scheduleId);

}
