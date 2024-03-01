package com.example.c0823g1_movie_backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;

@SpringBootTest
@AutoConfigureMockMvc
public class C0823G1MovieRestController_movieStatistics {
    @Autowired
    private MockMvc mockMvc;

//    @Test
//    public void movieStatistics_5() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders.get("/movie/statistics"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.);
//    }
//    @Test
//    public void movieStatistics_6() {
//
//    }
}
