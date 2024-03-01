package com.example.c0823g1_movie_backend.dto;

import java.util.List;

public class CheckoutDTO {
    private Long accountId;
    private Long scheduleId;
    private List<Integer> seatNumber;

    public CheckoutDTO() {
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public List<Integer> getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(List<Integer> seatNumber) {
        this.seatNumber = seatNumber;
    }
}
