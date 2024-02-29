package com.example.c0823g1_movie_backend.controller;

import com.example.c0823g1_movie_backend.dto.HallDTO;
import com.example.c0823g1_movie_backend.dto.ScheduleDTO;
import com.example.c0823g1_movie_backend.model.Hall;
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
    public ResponseEntity<?> getScheduleByHallId(@PathVariable("id") Long id){
        List<ScheduleDTO> scheduleList = scheduleService.getScheduleByHallId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
