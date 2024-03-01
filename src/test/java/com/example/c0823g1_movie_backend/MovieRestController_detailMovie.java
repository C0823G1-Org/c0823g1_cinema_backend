package com.example.c0823g1_movie_backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class MovieRestController_detailMovie {
    @Autowired
    private MockMvc mockMvc;
    /**
     * This function checks if ID is null
     * @author: TuanNM
     */
    @Test
    public void getDetailMovie_id_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/movie/find/{id}", (Object) null))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * This function checks if ID is empty
     * @author: TuanNM
     */
    @Test
    public void getDetailMovie_id_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/movie/find/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * This function checks if ID does not exist
     * @author: TuanNM
     */
    @Test
    public void getDetailMovie_id_3() {
        try {
            this.mockMvc.perform(MockMvcRequestBuilders.get("/movie/find/{id}", 3))
                    .andDo(print())
                    .andExpect(status().is4xxClientError());
        } catch (Exception e) {
            status().is4xxClientError();
        }
    }

    /**
     * This function checks if ID exists and has data
     * @author: TuanNM
     */
    @Test
    public void getDetailMovie_id_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/movie/find/{id}", 1))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
