package com.example.c0823g1_movie_backend.controller;

import com.example.c0823g1_movie_backend.model.Hall;
import com.example.c0823g1_movie_backend.service.IScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/schedule")
public class ScheduleRestController {
    @Autowired
    IScheduleService scheduleService;
    @GetMapping("/hall/{id}")
    public ResponseEntity<?> getScheduleByHallId(@PathVariable("id") Long id){
        Hall hall;
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
