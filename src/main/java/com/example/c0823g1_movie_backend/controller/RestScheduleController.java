package com.example.c0823g1_movie_backend.controller;

import com.example.c0823g1_movie_backend.model.Hall;
import com.example.c0823g1_movie_backend.model.Schedule;
import com.example.c0823g1_movie_backend.model.ScheduleTime;
import com.example.c0823g1_movie_backend.service.IScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api-schedule")
public class RestScheduleController {
    @Autowired
    IScheduleService scheduleService;
    @GetMapping("/date")
    public ResponseEntity<List<LocalDate>> findDateByMovieId(@RequestParam Long movieId){
         List<LocalDate> dateList = scheduleService.findDateByMovieId(movieId);
         if(dateList == null){
             return new ResponseEntity<>( HttpStatus.OK);
         }
         return new ResponseEntity<>(dateList,HttpStatus.OK);
    }
    @GetMapping("/time")
    public ResponseEntity<List<ScheduleTime>> findScheduleTimeByMovieAndDate(@RequestParam Long movieId,
                                                                             @RequestParam LocalDate date){
        List<ScheduleTime> scheduleTimes = scheduleService.findScheduleTimeByMovieAndDate(movieId,date);
        if(scheduleTimes == null){
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(scheduleTimes,HttpStatus.OK);
    }
    @GetMapping("/schedule")
    public ResponseEntity<Schedule> getScheduleByMovieIdAndDateAndScheduleTimeId(@RequestParam Long movieId,
                                                                                 @RequestParam LocalDate date,
                                                                                 @RequestParam Long scheduleTimeId){
        Schedule schedule = scheduleService.getScheduleByMovieIdAndDateAndScheduleTimeId(movieId,date,scheduleTimeId);
        if(schedule == null){
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(schedule,HttpStatus.OK);
    }
    @GetMapping("/hall")
    public ResponseEntity<Hall> getHallByScheduleId(@RequestParam Long scheduleId){
        Hall hall = scheduleService.getHallByScheduleId(scheduleId);
        if(hall == null){
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(hall,HttpStatus.OK);
    }
}
