package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.dto.ITicketDTO;
import com.example.c0823g1_movie_backend.model.Ticket;
import com.example.c0823g1_movie_backend.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public void updateTicket(Long bookingId) {
        ticketRepository.updateTicket(bookingId);
    }

    @Override
    public List<ITicketDTO> findAllByStatus() {
        return ticketRepository.findAllByStatus();
    }

    @Override
    public void deleteById(Long id) {
        ticketRepository.deleteById(id);
    }

    @Override
    public Optional<ITicketDTO> findBySeatAndScheduleId(Integer seatN, Long scheduleId) {
        return ticketRepository.findBySeatAndScheduleId(seatN,scheduleId);
    }

    @Override
    public Optional<ITicketDTO> findAllTicketByBookingId(Integer seatN, Long bookingId) {
        return ticketRepository.findBySeatAndBookingId(seatN, bookingId);
    }

    @Override
    public void removeTicketByBookingId(Long bookingId) {
        ticketRepository.removeTicketByBookingId(bookingId);
    }

    @Override
    public void updateTicketStatus(Long bookingId, Long scheduleId, Integer seatN) {
        ticketRepository.updateTicketStatus(bookingId,scheduleId,seatN);
    }
}
