package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.model.Ticket;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITicketService {
    List<Ticket> findAllTicketByScheduleId(Long scheduleId);
}
