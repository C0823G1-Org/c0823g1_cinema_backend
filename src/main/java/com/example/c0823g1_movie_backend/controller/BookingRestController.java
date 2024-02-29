package com.example.c0823g1_movie_backend.controller;

import com.example.c0823g1_movie_backend.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/booking")
public class BookingRestController {
    @Autowired
    private IBookingService iBookingService;


}
