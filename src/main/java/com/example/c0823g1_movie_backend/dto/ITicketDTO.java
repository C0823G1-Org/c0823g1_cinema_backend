package com.example.c0823g1_movie_backend.dto;

import java.time.LocalDateTime;

public interface ITicketDTO {
    Long getId();
    Boolean getIsDeleted();
    Long getBookingId();
    LocalDateTime getDateBooking();
    Long getScheduleId();
    Boolean getStatus();

}
