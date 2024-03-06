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
public class TicketRestController_findAllTicketByScheduleId {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Create by: HuuPT
     * Date: 01/03/2024
     * Test case: this function use to test the validation of hall more specific is null scheduleId parameter
     */
    @Test
    public void findDateByMovieId_scheduleId_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api-ticket/ticket"))
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
    public void findDateByMovieId_movieId_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api-ticket/ticket?scheduleId=110"))
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
     * Specifically, movieId parameter is in the database
     */
    @Test
    public void findDateByMovieId_movieId_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api-ticket/ticket?scheduleId=1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
