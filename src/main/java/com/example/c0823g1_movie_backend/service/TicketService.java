package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.model.Ticket;
import com.example.c0823g1_movie_backend.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService implements ITicketService{
    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public void saveTicket(Integer seat, Long id, Long scheduleId) {
        ticketRepository.saveTicket(seat,id,scheduleId);
    }

    @Override
    public List<Ticket> checkExist(Integer seat, Long scheduleId) {
        return ticketRepository.checkExist(seat,scheduleId);
    }

    @Override
    public void removeTicket(Long bookingId, Long scheduleId) {
        ticketRepository.removeTicket(bookingId,scheduleId);
    }
}
