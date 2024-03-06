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
    /**
     * Create by HuuPT
     * Date create: 29/02/2024
     * Function: to find list ticket by schedule id
     * Return: HttpStatus.NO_CONTENT if ticket not found/ HttpStatus.OK and date list
     */
    @GetMapping("/ticket")
    public ResponseEntity<List<Ticket>> findAllTicketByScheduleId(@RequestParam Long scheduleId){
        List<Ticket> ticketList = ticketService.findAllTicketByScheduleId(scheduleId);
        if(ticketList.isEmpty()){
            return new ResponseEntity<>(ticketList ,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ticketList,HttpStatus.OK);
    }
}
