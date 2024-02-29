package com.example.c0823g1_movie_backend.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface IBookingDTO {
    Integer getBookingCode();
    Integer getAccountId();
    String getNameCustomer();
    String getIdNumber();
    String getPhoneNumber();
    LocalDateTime getDateBooking();
    String getNameMovie();
    LocalDate getScheduleTime();
    Boolean getPrintStatus();

}
