package com.example.c0823g1_movie_backend.dto;

import java.util.List;

public class TicketDTO {
    private List<Integer> seatList;
    private Long idMovie;
    private Long scheduleId;
    private Long accountId;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public TicketDTO() {
    }

    public List<Integer> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<Integer> seatList) {
        this.seatList = seatList;
    }

    public Long getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(Long idMovie) {
        this.idMovie = idMovie;
    }

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }
}
