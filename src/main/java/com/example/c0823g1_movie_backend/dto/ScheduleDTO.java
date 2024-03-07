package com.example.c0823g1_movie_backend.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDTO {
    private Long id;
    @NotNull(message = "Ngày chiếu không được để rỗng")
    private LocalDate date;
    @NotNull(message = "Thời gian chiếu không được để rỗng")
    private Long scheduleTime;
    @NotNull(message = "Sảnh chiếu không được để rỗng")
    private Long hall;
    private Long movie;

    public ScheduleDTO(LocalDate date, Long scheduleTime, Long hall) {
        this.date = date;
        this.scheduleTime = scheduleTime;
        this.hall = hall;
    }
}
