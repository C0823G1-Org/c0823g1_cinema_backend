package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.model.Ticket;
import com.example.c0823g1_movie_backend.repository.ITicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements ITicketService {
    @Autowired
    ITicketRepository ticketRepository;
    @Override
    public List<Ticket> findAllTicketByScheduleId(Long scheduleId) {
        return ticketRepository.findAllTicketByScheduleId(scheduleId);
    }
}
