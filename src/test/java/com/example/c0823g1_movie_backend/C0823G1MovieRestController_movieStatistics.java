package com.example.c0823g1_movie_backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class C0823G1MovieRestController_movieStatistics {
    @Autowired
    private MockMvc mockMvc;
    /**
     * This function is used to test the return value of records from database
     * @author DuyDD
     * @Time 6:13pm 03/03/24
     */
    @Test
    public void movieStatistics_5() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/movie/statistics"))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }
    /**
     * This function is used to test the return value of records from database
     * @author DuyDD
     * @Time 6:13pm 03/03/24
     */
    @Test
    public void movieStatistics_nonEmptyList() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/movie/statistics"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(20))
                .andExpect(MockMvcResultMatchers.jsonPath("$.page").value(2))
                .andDo(MockMvcResultHandlers.print());
    }
}
