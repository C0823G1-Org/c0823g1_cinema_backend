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
public class ScheduleRestController_getHallByScheduleId {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Create by: HuuPT
     * Date: 01/03/2024
     * Test case: this function use to test the validation of hall more specific is null scheduleId parameter
     */
    @Test
    public void findDateByMovieId_getHallByScheduleId_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/schedule/hall"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: HuuPT
     * Date: 01/03/2024
     * Test case:
     * This function use to test the validation of dropdown date.
     * Specifically, scheduleId parameter is not in the database
     */
    @Test
    public void findDateByMovieId_getHallByScheduleId_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/schedule/hall?scheduleId=1100"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Create by: HuuPT
     * Date: 01/03/2024
     * Test case: There are no cases found in the database but an empty list is returned
     */


    /**
     * Create by: HuuPT
     * Date: 01/03/2024
     * Test case:
     * This function use to test the validation of dropdown date.
     * Specifically, scheduleId parameter is in the database
     */
    @Test
    public void findDateByMovieId_getHallByScheduleId_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/schedule/hall?scheduleId=1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}

