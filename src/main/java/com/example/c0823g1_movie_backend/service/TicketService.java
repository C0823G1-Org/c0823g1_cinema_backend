package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService implements ITicketService{
    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public void saveTicket(Integer seat, Integer id, Long scheduleId) {
        ticketRepository.saveTicket(seat,id,scheduleId);
    }
}
