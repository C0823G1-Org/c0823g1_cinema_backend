package com.example.c0823g1_movie_backend.service;


import com.example.c0823g1_movie_backend.model.Ticket;


import java.util.List;

public interface ITicketService {
    void saveTicket(Integer seat, Long id, Long scheduleId);

    List<Ticket> checkExist(Integer seat, Long scheduleId);

    void removeTicket(Long bookingId,Long scheduleId);

    void saveTicket(Integer seat, Integer id, Long scheduleId);
import com.example.c0823g1_movie_backend.model.Ticket;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITicketService {
    List<Ticket> findAllTicketByScheduleId(Long scheduleId);
}
