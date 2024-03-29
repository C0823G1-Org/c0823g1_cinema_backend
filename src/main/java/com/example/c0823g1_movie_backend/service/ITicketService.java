package com.example.c0823g1_movie_backend.service;


import com.example.c0823g1_movie_backend.dto.ITicketDTO;
import com.example.c0823g1_movie_backend.model.Ticket;


import java.util.List;
import java.util.Optional;

public interface ITicketService {
    void saveTicket(Integer seat, Long id, Long scheduleId);

    List<Ticket> checkExist(Long bookingId, Long scheduleId,Integer seat);

    void removeTicket(Long bookingId,Long scheduleId);

    List<Ticket> findAllTicketByScheduleId(Long scheduleId);

    List<ITicketDTO> findAllByStatus();

    void deleteById(Long id);

    Optional<ITicketDTO> findBySeatAndScheduleId(Integer seatN, Long scheduleId);

    Optional<ITicketDTO> findAllTicketByBookingId(Integer seatN, Long bookingId);

    void updateTicketStatus(Long bookingId, Long scheduleId, Integer seatN);

    void removeTicketByBookingId(Long bookingId);

    void updateTicket(Long bookingId, Long scheduleId, Integer seatN);
}
