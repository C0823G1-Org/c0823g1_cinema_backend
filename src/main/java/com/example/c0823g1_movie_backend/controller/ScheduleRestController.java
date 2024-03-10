package com.example.c0823g1_movie_backend.controller;

import com.example.c0823g1_movie_backend.dto.HallDTO;
import com.example.c0823g1_movie_backend.dto.IScheduleTimeDTO;
import com.example.c0823g1_movie_backend.dto.IScheduleDTO;
import com.example.c0823g1_movie_backend.dto.IScheduleTimeDTO;
import com.example.c0823g1_movie_backend.dto.ScheduleDTO;
import com.example.c0823g1_movie_backend.model.Schedule;
import com.example.c0823g1_movie_backend.model.Hall;
import com.example.c0823g1_movie_backend.model.Schedule;
import com.example.c0823g1_movie_backend.service.IHallService;
import com.example.c0823g1_movie_backend.service.IScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/schedule")
public class ScheduleRestController {
    @Autowired
    IScheduleService scheduleService;

    @Autowired
    IHallService hallService;

    /**
     * Created by: LamNT
     * Date created: 29/2/2024
     * Function: get a list of schedules from today to the next 7 days by hall's id
     *
     * @return HTTPStatus.OK and the list of schedules
     */

    @GetMapping("/hall/{id}")
    public ResponseEntity<List<Schedule>> getListScheduleByHallId(@PathVariable("id") Long id) {
        List<Schedule> scheduleList = scheduleService.getScheduleByHallId(id);
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

    /**
     * Create by HuuPT
     * Date create: 29/02/2024
     * Function: to find list date by movie id
     * Return: HttpStatus.BAD_REQUEST if date not found/ HttpStatus.OK and date list
     */
    @GetMapping("/date")
    public ResponseEntity<List<ScheduleDTO>> findDateByMovieId(@RequestParam Long movieId) {
        List<ScheduleDTO> dateList = scheduleService.findDateByMovieId(movieId);
        if (dateList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(dateList, HttpStatus.OK);
    }

    /**
     * Create by HuuPT
     * Date create: 29/02/2024
     * Function: to find schedule time by movie id and date
     * Return: HttpStatus.BAD_REQUEST if schedule time not found/ HttpStatus.OK and schedule time list
     */
    @GetMapping("/time")
    public ResponseEntity<List<IScheduleTimeDTO>> findScheduleTimeByMovieAndDate(@RequestParam Long movieId,
                                                                                 @RequestParam LocalDate date) {
        List<IScheduleTimeDTO> scheduleTimes = scheduleService.findScheduleTimeByMovieAndDate(movieId, date);
        if (scheduleTimes.isEmpty()) {
            return new ResponseEntity<>(scheduleTimes, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(scheduleTimes, HttpStatus.OK);
    }

    /**
     * Create by HuuPT
     * Date create: 29/02/2024
     * Function: to find an object schedule by movie id, date and schedule time id
     * Return: HttpStatus.BAD_REQUEST if schedule not found/ HttpStatus.OK and an object schedule
     */
    @GetMapping("/schedule")
    public ResponseEntity<Schedule> getScheduleByMovieIdAndDateAndScheduleTimeId(@RequestParam Long movieId,
                                                                                 @RequestParam LocalDate date,
                                                                                 @RequestParam Long scheduleTimeId) {
        Schedule schedule = scheduleService.getScheduleByMovieIdAndDateAndScheduleTimeId(movieId, date, scheduleTimeId);
        if (schedule == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(schedule, HttpStatus.OK);
    }

    /**
     * Create by HuuPT
     * Date create: 29/02/2024
     * Function: to find an object hall by schedule id
     * Return: HttpStatus.BAD_REQUEST if hall not found/ HttpStatus.OK and an object hall
     */
//    @GetMapping("/hall")
//    public ResponseEntity<Hall> getHallByScheduleId(@RequestParam Long scheduleId) {
//        HallDTO hallDTO = scheduleService.getHallByScheduleId(scheduleId);
//        Hall hall = hallService.getHallById(hallDTO.getId());
//        if (hall == null) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        return new ResponseEntity<>(hall, HttpStatus.OK);
//    }
}
