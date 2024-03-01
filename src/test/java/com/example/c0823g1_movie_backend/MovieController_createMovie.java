package com.example.c0823g1_movie_backend;

import com.example.c0823g1_movie_backend.dto.MovieDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc

public class MovieController_createMovie {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    /**
     * Created by: LamNT
     * Created date: 01/03/2024
     * Test field name validation with null value
     */
    @Test
    public void createMovie_name1() throws Exception {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setName("");
        movieDTO.setActor("Christian Bale, Heath Ledger");
        movieDTO.setCountry("USA");
        movieDTO.setDuration(120);
        movieDTO.setDirector("Christopher Nolan");
        movieDTO.setPoster("[Poster link]");
        movieDTO.setPublisher("Warner Bros.");
        movieDTO.setTicketPrice(150000);
        movieDTO.setDescription("When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/create")
                        .content(this.objectMapper.writeValueAsString(movieDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
