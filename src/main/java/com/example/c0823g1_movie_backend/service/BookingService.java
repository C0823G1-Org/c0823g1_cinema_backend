package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService implements IBookingService{
    @Autowired
    private BookingRepository bookingRepository;

}
