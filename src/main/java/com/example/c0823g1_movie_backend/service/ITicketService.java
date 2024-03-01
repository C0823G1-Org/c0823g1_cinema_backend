package com.example.c0823g1_movie_backend.service;

import org.springframework.stereotype.Service;

public interface ITicketService {
    void saveTicket(Integer seat, Integer id, Long scheduleId);
}
