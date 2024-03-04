package com.example.c0823g1_movie_backend;

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
public class MovieRestController_getAllMovieCurrent {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Author: BaoLVN.
     * This method is used to test for function getAllMovieCurrent (N/A)
     * @Throws Exception
     */
    @Test
    public void getAllMovieCurrent_5() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/movie/current/")).
                andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Author: BaoLVN.
     * This method is used to test for function getAllMovieCurrent (return list movies)
     * @Throws Exception
     */
    @Test
    public void getAllMovieCurrent_6() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/movie/current"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
