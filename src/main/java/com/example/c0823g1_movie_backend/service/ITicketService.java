package com.example.c0823g1_movie_backend.service;

public interface ITicketService {
    void saveTicket(Integer seat, Integer id, Long scheduleId);
import com.example.c0823g1_movie_backend.model.Ticket;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITicketService {
    List<Ticket> findAllTicketByScheduleId(Long scheduleId);
}
