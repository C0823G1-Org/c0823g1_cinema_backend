package com.example.c0823g1_movie_backend.controller;

import com.example.c0823g1_movie_backend.dto.HistoryBookingDTO;
import com.example.c0823g1_movie_backend.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@CrossOrigin("*")
@RequestMapping("/booking")
public class BookingRestController {
    @Autowired
    private IBookingService iBookingService;

    @GetMapping("historyBooking/{id}")
    public ResponseEntity<Iterable<HistoryBookingDTO>> historyMovie(@PathVariable Long id) {
        return new ResponseEntity<>(iBookingService.historyBooking(id), HttpStatus.OK);
    }

    @GetMapping("searchMovieBooking/{start}/{end}")
    public ResponseEntity<Iterable<HistoryBookingDTO>> searchMovieBooking(@PathVariable LocalDateTime startDate, @PathVariable LocalDateTime endDate) {
        return new ResponseEntity<>(iBookingService.searchBookingByDate(startDate, endDate), HttpStatus.OK);
    }
}
