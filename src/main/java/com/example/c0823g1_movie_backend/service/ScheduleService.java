package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.dto.IScheduleDTO;
import com.example.c0823g1_movie_backend.dto.IScheduleTimeDTO;
import com.example.c0823g1_movie_backend.dto.ScheduleDTO;
import com.example.c0823g1_movie_backend.model.Schedule;
import com.example.c0823g1_movie_backend.model.ScheduleTime;
import com.example.c0823g1_movie_backend.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService implements IScheduleService {
    @Autowired
    ScheduleRepository scheduleRepository;
    private final int SCHEDULE_TIME_INTERVAL = 150;

    @Override
    public Schedule save(Schedule schedule) {
        return null;
    }

    @Override
    public Schedule create(Schedule schedule) {
        return null;
    }

    @Override
    public List<IScheduleDTO> findDateByMovieId(Long movieId) {
        return scheduleRepository.findDateByMovieId(movieId);
    }

    @Override
    public List<IScheduleTimeDTO> findScheduleTimeByMovieAndDate(Long movieId, LocalDate date) {
        return scheduleRepository.findScheduleTimeByMovieAndDate(movieId, date);
    }

    @Override
    public Schedule getScheduleByMovieIdAndDateAndScheduleTimeId(Long movieId, LocalDate date, Long scheduleTimeId) {
        return scheduleRepository.getScheduleByMovieIdAndDateAndScheduleTimeId(movieId, date, scheduleTimeId);
    }


    @Override
    public List<Schedule> getScheduleByHallId(Long id) {
        List<Schedule> schedules = scheduleRepository.getScheduleByHallId(id);
        List<Schedule> resultSchedules = new ArrayList<>();
        long maxId = scheduleRepository.getscheduleTimeMaxId();
        for (Schedule schedule : schedules) {
            resultSchedules.add(schedule);
            int durationCount = SCHEDULE_TIME_INTERVAL;
            int incrementCount = 1;
            while (schedule.getMovie().getDuration() > durationCount && schedule.getScheduleTime().getId() + incrementCount <= maxId) {
                durationCount *= 2;
                ScheduleTime scheduleTime = new ScheduleTime();
                Schedule intervalSchedule = new Schedule(-1L, schedule.getDate(), scheduleTime, schedule.getHall(), schedule.getMovie());
                intervalSchedule.getScheduleTime().setId(schedule.getScheduleTime().getId() + incrementCount);
                resultSchedules.add(intervalSchedule);
                incrementCount++;
            }
        }
        return resultSchedules;
    }

    @Override
    public Optional<Schedule> getScheduleById(Long scheduleId) {
        return Optional.ofNullable(scheduleRepository.getScheduleById(scheduleId));
    }

    @Override
    public void createSchedule(ScheduleDTO scheduleDTO) {
        scheduleRepository.create(scheduleDTO);
    }

    @Override
    public boolean editSchedule(ScheduleDTO schedule) {
        if (getScheduleById(schedule.getId()).isPresent()) {
            scheduleRepository.updateScheduleStatus(schedule.getId());
            return true;
        }
        return false;
    }

    @Override
    public List<Schedule> getScheduleByMovieId(Long movieId) {
        return scheduleRepository.getScheduleByMovieId(movieId);
    }

    @Override
    public void deleteScheduleByMovieId(Long id) {
        scheduleRepository.deleteByMovieId(id);
    }

}
