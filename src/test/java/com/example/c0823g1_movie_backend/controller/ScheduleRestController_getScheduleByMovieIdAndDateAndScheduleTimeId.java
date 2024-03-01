package com.example.c0823g1_movie_backend.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ScheduleRestController_getScheduleByMovieIdAndDateAndScheduleTimeId {
    @Autowired
    private MockMvc mockMvc;
    /**
     * Create by: HuuPT
     * Date: 01/03/2024
     * Test case: this function use to test the validation of schedule more specific is null movieId parameter
     */
    @Test
    public void getScheduleByMovieIdAndDateAndScheduleTimeId_movieId_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/schedule/schedule?movieId=&date=&scheduleTimeId="))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getScheduleByMovieIdAndDateAndScheduleTimeId_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/schedule/schedule?movieId=1&date=&scheduleTimeId="))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getScheduleByMovieIdAndDateAndScheduleTimeId_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/schedule/schedule?movieId=1&date=2024-02-02&scheduleTimeId="))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getScheduleByMovieIdAndDateAndScheduleTimeId_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/schedule/schedule?movieId=1&date=&scheduleTimeId=1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getScheduleByMovieIdAndDateAndScheduleTimeId_5() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/schedule/schedule?movieId=&date=2024-02-02&scheduleTimeId=1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getScheduleByMovieIdAndDateAndScheduleTimeId_6() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/schedule/schedule?movieId=&date=2024-02-02&scheduleTimeId="))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getScheduleByMovieIdAndDateAndScheduleTimeId_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/schedule/schedule?movieId=&date=&scheduleTimeId=1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getScheduleByMovieIdAndDateAndScheduleTimeId_8() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/schedule/schedule?movieId=10&date=2024-02-02&scheduleTimeId=1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getScheduleByMovieIdAndDateAndScheduleTimeId_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/schedule/schedule?movieId=1&date=2004-02-02&scheduleTimeId=10"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getScheduleByMovieIdAndDateAndScheduleTimeId_10() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/schedule/schedule?movieId=10&date=2024-02-02&scheduleTimeId=10"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getScheduleByMovieIdAndDateAndScheduleTimeId_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/schedule/schedule?movieId=1&date=2024-02-02&scheduleTimeId=10"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getScheduleByMovieIdAndDateAndScheduleTimeId_12() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/schedule/schedule?movieId=1&date=2004-02-02&scheduleTimeId=1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getScheduleByMovieIdAndDateAndScheduleTimeId_13() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/schedule/schedule?movieId=10&date=2024-02-02&scheduleTimeId=1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getScheduleByMovieIdAndDateAndScheduleTimeId_14() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/schedule/schedule?movieId=10&date=2024-02-02&scheduleTimeId=10"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getScheduleByMovieIdAndDateAndScheduleTimeId_15() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/schedule/schedule?movieId=1&date=2024-02-02&scheduleTimeId=1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
