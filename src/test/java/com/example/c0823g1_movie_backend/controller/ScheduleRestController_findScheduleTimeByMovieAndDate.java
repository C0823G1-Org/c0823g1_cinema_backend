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
public class ScheduleRestController_findScheduleTimeByMovieAndDate {
    @Autowired
    private MockMvc mockMvc;
    /**
     * Create by: HuuPT
     * Date: 01/03/2024
     * Test case: this function use to test the validation of dropdown schedule time. Specifically,
     * movieId parameter and date parameter are null
     */
    @Test
    public void findScheduleTimeByMovieAndDate_movieId_date_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/schedule/time"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HuuPT
     * Date: 01/03/2024
     * Test case: this function use to test the validation of dropdown schedule time. Specifically,
     * movieId parameter is null and date parameter has data
     */
    @Test
    public void findScheduleTimeByMovieAndDate_movieId_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/schedule/time?date=2004-02-02"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: HuuPT
     * Date: 01/03/2024
     * Test case: this function use to test the validation of dropdown schedule time. Specifically,
     * movieId parameter has data and date parameter is null
     */
    @Test
    public void findScheduleTimeByMovieAndDate_date_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/schedule/time?movieId=1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Create by: HuuPT
     * Date: 01/03/2024
     * Test case: this function use to test the validation of dropdown schedule time. Specifically,
     * movieId parameter is in database and date parameter isn't in database
     */
    @Test
    public void findScheduleTimeByMovieAndDate_date_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/schedule/time?movieId=1&date=2004-01-01"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: HuuPT
     * Date: 01/03/2024
     * Test case: this function use to test the validation of dropdown schedule time. Specifically,
     * movieId parameter isn't in database and date parameter is in database
     */
    @Test
    public void findScheduleTimeByMovieAndDate_movieId_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/schedule/time?movieId=10&date=2024-02-02"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: HuuPT
     * Date: 01/03/2024
     * Test case: this function use to test the validation of dropdown schedule time. Specifically,
     * movieId parameter and date parameter aren't in database
     */
    @Test
    public void findScheduleTimeByMovieAndDate_movieId_10() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/schedule/time?movieId=10&date=2004-02-02"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: HuuPT
     * Date: 01/03/2024
     * Test case: this function use to test the validation of dropdown schedule time. Specifically,
     * movieId parameter and date parameter are in database
     */
    @Test
    public void findScheduleTimeByMovieAndDate_movieId_date_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/schedule/time?movieId=1&date=2024-02-02"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
