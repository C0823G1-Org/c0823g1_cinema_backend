package com.example.c0823g1_movie_backend.controller;

import com.example.c0823g1_movie_backend.dto.HallDTO;
import com.example.c0823g1_movie_backend.dto.IScheduleDTO;
import com.example.c0823g1_movie_backend.dto.IScheduleTimeDTO;
import com.example.c0823g1_movie_backend.dto.ScheduleDTO;
import com.example.c0823g1_movie_backend.model.Hall;
import com.example.c0823g1_movie_backend.model.Schedule;
import com.example.c0823g1_movie_backend.service.IHallService;
import com.example.c0823g1_movie_backend.service.IScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/schedule")
public class ScheduleRestController {
    @Autowired
    IScheduleService scheduleService;

    /**
     * Created by: LamNT
     * Date created: 29/2/2024
     * Function: get a list of schedules from today to the next 7 days by hall's id
     *
     * @return HTTPStatus.OK and the list of schedules
     */

    @GetMapping("/hall/{id}")
    public ResponseEntity<List<IScheduleDTO>> getScheduleByHallId(@PathVariable("id") Long id) {
        List<IScheduleDTO> scheduleList = scheduleService.getScheduleByHallId(id);
        System.out.println(scheduleList.get(0).getDate());
        return new ResponseEntity<>(scheduleList, HttpStatus.OK);
    }

    @GetMapping("/movie")
    public ResponseEntity<List<Schedule>> getScheduleByMovieId(@RequestParam Long movieId) {
        List<Schedule> schedule = scheduleService.getScheduleByMovieId(movieId);
        if (schedule.isEmpty()) {
            return new ResponseEntity<>(schedule, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(schedule, HttpStatus.OK);
    }
}
