package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.model.Ticket;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ITicketService {
    void saveTicket(Integer seat, Integer id, Long scheduleId);

    List<Ticket> checkExist(Integer seat, Long scheduleId);
}
