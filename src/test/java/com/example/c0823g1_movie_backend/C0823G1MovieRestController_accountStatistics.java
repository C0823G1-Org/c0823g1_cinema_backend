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
public class C0823G1MovieRestController_accountStatistics {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void movieStatistics_5() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/account/statistics"))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }
    @Test
    public void movieStatistics_nonEmptyList() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/account/statistics"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(50))
                .andExpect(MockMvcResultMatchers.jsonPath("$.page").value(5))
                .andDo(MockMvcResultHandlers.print());
    }
}
