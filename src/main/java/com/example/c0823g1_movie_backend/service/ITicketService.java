package com.example.c0823g1_movie_backend.service;


import com.example.c0823g1_movie_backend.model.Ticket;


import java.util.List;

public interface ITicketService {
    void saveTicket(Integer seat, Long id, Long scheduleId);

    List<Ticket> checkExist(Long bookingId, Long scheduleId,Integer seat);

    void removeTicket(Long bookingId,Long scheduleId);

    List<Ticket> findAllTicketByScheduleId(Long scheduleId);

    void updateTicket(Long bookingId, Long scheduleId, Integer seatNumber);

    void removeTicketByBookingId(Long bookingId);

    void updateTicketStatus(Long bookingId, Long scheduleId, Integer seatN);
}
