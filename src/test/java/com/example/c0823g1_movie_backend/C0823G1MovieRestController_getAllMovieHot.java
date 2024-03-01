package com.example.c0823g1_movie_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class C0823G1MovieRestController_getAllMovieHot {
    @Autowired
    private MockMvc mockMvc;
}
