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
    public List<Ticket> checkExist(Long bookingId, Long scheduleId,Integer seat) {
        return ticketRepository.checkExist(bookingId,scheduleId,seat);
    }

    @Override
    public void removeTicket(Long bookingId, Long scheduleId) {
        ticketRepository.removeTicket(bookingId,scheduleId);
    }
    @Override
    public List<Ticket> findAllTicketByScheduleId(Long scheduleId) {
        return ticketRepository.findAllTicketByScheduleId(scheduleId);
    }

    @Override
    public void updateTicket(Long bookingId, Long scheduleId, Integer seatNumber) {
        ticketRepository.updateTicket(bookingId,scheduleId,seatNumber);
    }
}
