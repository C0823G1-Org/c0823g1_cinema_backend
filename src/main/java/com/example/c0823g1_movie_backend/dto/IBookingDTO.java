package com.example.c0823g1_movie_backend.dto;

import java.time.LocalDateTime;
import java.time.LocalTime;

public interface IBookingDTO {
    Integer getBookingCode();
    Integer getAccountId();
    String getNameCustomer();
    String getIdNumber();
    String getPhoneNumber();
    LocalDateTime getDateBooking();
    String getNameMovieFilm();
    LocalTime getScheduleTime();
    Boolean getPrintStatus();
    Integer getTicketPrice();
    Integer getSeatNumber();
    String getCinemaHall();


}
