package com.example.c0823g1_movie_backend.controller;

import com.example.c0823g1_movie_backend.model.Ticket;
import com.example.c0823g1_movie_backend.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api-ticket")
public class RestTicketController {
    @Autowired
    ITicketService ticketService;
    @GetMapping("/date")
    public ResponseEntity<List<Ticket>> findAllTicketByScheduleId(@RequestParam Long scheduleId){
        List<Ticket> ticketList = ticketService.findAllTicketByScheduleId(scheduleId);
        if(ticketList == null){
            return new ResponseEntity<>( HttpStatus.OK);
        }
        return new ResponseEntity<>(ticketList,HttpStatus.OK);
    }
}
