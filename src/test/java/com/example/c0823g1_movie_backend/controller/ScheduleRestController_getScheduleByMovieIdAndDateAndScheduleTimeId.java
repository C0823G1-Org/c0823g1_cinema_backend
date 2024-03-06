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
     * Test case: this function use to test the validation of dropdown schedule time. Specifically,
     * movieId parameter,date parameter  and scheduleId parameter are null
     */
    @Test
    public void getScheduleByMovieIdAndDateAndScheduleTimeId_movieId_date_scheduleId_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/schedule/schedule"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: HuuPT
     * Date: 01/03/2024
     * Test case: this function use to test the validation of dropdown schedule time. Specifically,
     * date parameter  and scheduleId parameter are null, movieId parameter has data
     */
    @Test
    public void getScheduleByMovieIdAndDateAndScheduleTimeId_date_schedule_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/schedule/schedule?movieId=1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: HuuPT
     * Date: 01/03/2024
     * Test case: this function use to test the validation of dropdown schedule time. Specifically,
     * movieId parameter and scheduleId parameter are null, date parameter  has data
     */
    @Test
    public void getScheduleByMovieIdAndDateAndScheduleTimeId_movieId_scheduleId_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/schedule/schedule?date=2024-02-02"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: HuuPT
     * Date: 01/03/2024
     * Test case: this function use to test the validation of dropdown schedule time. Specifically,
     * movieId parameter and date parameter  are null, scheduleId parameter has data
     */
    @Test
    public void getScheduleByMovieIdAndDateAndScheduleTimeId_movieId_date_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/schedule/schedule?scheduleTimeId=1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: HuuPT
     * Date: 01/03/2024
     * Test case: this function use to test the validation of dropdown schedule time. Specifically,
     * movieId parameter and date parameter  have data, scheduleId parameter is null
     */
    @Test
    public void getScheduleByMovieIdAndDateAndScheduleTimeId_scheduleId_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/schedule/schedule?movieId=1&date=2024-02-02"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: HuuPT
     * Date: 01/03/2024
     * Test case: this function use to test the validation of dropdown schedule time. Specifically,
     * movieId parameter and scheduleId parameter  have data, date parameter is null
     */
    @Test
    public void getScheduleByMovieIdAndDateAndScheduleTimeId_date_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/schedule/schedule?movieId=1&scheduleTimeId=1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: HuuPT
     * Date: 01/03/2024
     * Test case: this function use to test the validation of dropdown schedule time. Specifically,
     * date parameter and scheduleId parameter  have data, movieId parameter is null
     */
    @Test
    public void getScheduleByMovieIdAndDateAndScheduleTimeId_movieId_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/schedule/schedule?date=2024-02-02&scheduleTimeId=1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: HuuPT
     * Date: 01/03/2024
     * Test case: this function use to test the validation of dropdown schedule time. Specifically,
     * movieId parameter and date aren't in database and scheduleId parameter is in database
     */
    @Test
    public void getScheduleByMovieIdAndDateAndScheduleTimeId_movieId_date_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/schedule/schedule?movieId=10&date=2022-02-02&scheduleTimeId=1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: HuuPT
     * Date: 01/03/2024
     * Test case: this function use to test the validation of dropdown schedule time. Specifically,
     * movieId parameter and scheduleId parameter aren't in database and date parameter is in database
     */
    @Test
    public void getScheduleByMovieIdAndDateAndScheduleTimeId_movieId_scheduleId_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/schedule/schedule?movieId=10&date=2024-02-02&scheduleTimeId=10"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: HuuPT
     * Date: 01/03/2024
     * Test case: this function use to test the validation of dropdown schedule time. Specifically,
     * date parameter and scheduleId parameter aren't in database and movieId parameter is in database
     */
    @Test
    public void getScheduleByMovieIdAndDateAndScheduleTimeId_date_scheduleId_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/schedule/schedule?movieId=1&date=2004-02-02&scheduleTimeId=10"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: HuuPT
     * Date: 01/03/2024
     * Test case: this function use to test the validation of dropdown schedule time. Specifically,
     * date parameter and scheduleId parameter are in database and movieId parameter isn't in database
     */
    @Test
    public void getScheduleByMovieIdAndDateAndScheduleTimeId_movieId_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/schedule/schedule?movieId=10&date=2024-02-02&scheduleTimeId=1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: HuuPT
     * Date: 01/03/2024
     * Test case: this function use to test the validation of dropdown schedule time. Specifically,
     * movieId parameter and date parameter are in database and scheduleId parameter isn't in database
     */
    @Test
    public void getScheduleByMovieIdAndDateAndScheduleTimeId_scheduleId_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/schedule/schedule?movieId=1&date=2024-02-02&scheduleTimeId=10"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: HuuPT
     * Date: 01/03/2024
     * Test case: this function use to test the validation of dropdown schedule time. Specifically,
     * movieId parameter and scheduleId parameter are in database and date parameter isn't in database
     */
    @Test
    public void getScheduleByMovieIdAndDateAndScheduleTimeId_date_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/schedule/schedule?movieId=10&date=2004-02-02&scheduleTimeId=1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: HuuPT
     * Date: 01/03/2024
     * Test case: this function use to test the validation of dropdown schedule time. Specifically,
     * movieId parameter, scheduleId parameter and date parameter aren't in database
     */
    @Test
    public void getScheduleByMovieIdAndDateAndScheduleTimeId_movieId_date_scheduleId_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/schedule/schedule?movieId=10&date=2004-02-02&scheduleTimeId=10"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: HuuPT
     * Date: 01/03/2024
     * Test case: this function use to test the validation of dropdown schedule time. Specifically,
     * movieId parameter, scheduleId parameter and date parameter are in database
     */
    @Test
    public void getScheduleByMovieIdAndDateAndScheduleTimeId_15() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/schedule/schedule?movieId=1&date=2024-02-02&scheduleTimeId=1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
