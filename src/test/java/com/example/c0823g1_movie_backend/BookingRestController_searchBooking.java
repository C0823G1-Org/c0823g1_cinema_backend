package com.example.c0823g1_movie_backend;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class BookingRestController_searchBooking {
    @Autowired
    private MockMvc mockMvc;

    /**
     * This function checks if StartDate, EndDate and Id is null
     *
     * @author: TuanNM
     */
    @Test
    public void getListHistorySearch_99() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/booking/searchMovieBooking/{id}/{start}/{end}", null, null, null))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * This function checks if StartDate , EndDate and Id is empty
     *
     * @author: TuanNM
     */
    @Test
    public void getListHistorySearch_98() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/booking/searchMovieBooking/{id}/{start}/{end}", "", "", ""))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * This function checks if StartDate and EndDate and ID but no data
     *
     * @author: TuanNM
     */
    @Test
    public void getListHistorySearch_97() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/booking/searchMovieBooking/{id}/{start}/{end}", 2, "2024-03-02T09:10:48.829116228", "2024-03-03T09:10:48.829116228"))
                .andDo(print()).andExpect(status().isNoContent());
    }

    /**
     * This function checks if StartDate, EndDate and Id but has data
     *
     * @author: TuanNM
     */
    @Test
    public void getListHistorySearch_96() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/booking/searchMovieBooking/{id}/{start}/{end}", 2, "2024-02-02T09:10:48.829116228", "2024-03-01T09:10:48.829116228"))
                .andDo(print()).andExpect(status().is2xxSuccessful());
    }

    /**
     * This function checks if StartDate, EndDate has date but Id null
     *
     * @author: TuanNM
     */
    @Test
    public void getListHistorySearch_95() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/booking/searchMovieBooking/{id}/{start}/{end}", null, "2024-02-02T09:10:48.829116228", "2024-03-01T09:10:48.829116228"))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * This function checks if id not null but startDate and endDate is empty
     *
     * @author: TuanNM
     */
    @Test
    public void getListHistorySearch_94() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/booking/searchMovieBooking/{id}/{start}/{end}", 2, "", ""))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * This function checks if id not null but startDate and endDate is empty
     *
     * @author: TuanNM
     */
    @Test
    public void getListHistorySearch_93() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/booking/searchMovieBooking/{id}/{start}/{end}", 2, "2024-02-02T09:10:48.829116228", ""))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * This function checks if id not null but startDate and endDate is null
     *
     * @author: TuanNM
     */
    @Test
    public void getListHistorySearch_92() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/booking/searchMovieBooking/{id}/{start}/{end}", 2, null, null))
                .andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     * This function checks if id null but startDate and endDate not null
     *
     * @author: TuanNM
     */
    @Test
    public void getListHistorySearch_91() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/booking/searchMovieBooking/{id}/{start}/{end}", null, "2024-02-02T09:10:48.829116228", "2024-03-02T09:10:48.829116228"))
                .andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     * This function checks if id null startDate null but  endDate not null
     *
     * @author: TuanNM
     */
    @Test
    public void getListHistorySearch_90() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/booking/searchMovieBooking/{id}/{start}/{end}", null, null, "2024-03-02T09:10:48.829116228"))
                .andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     * This function checks if id not null endDate null but  startDate not null
     *
     * @author: TuanNM
     */
    @Test
    public void getListHistorySearch_89() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/booking/searchMovieBooking/{id}/{start}/{end}", 2, null, "2024-03-02T09:10:48.829116228"))
                .andDo(print()).andExpect(status().is4xxClientError());
    }
}
