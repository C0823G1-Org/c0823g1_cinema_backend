package com.example.c0823g1_movie_backend.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.security.Principal;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class AccountRestController_AccountDetail {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Creator : TuanTA
     * Principal is null
     * Goal : HttpStatus = 4xx
     * date create : 01-03-2024
     * @throws Exception
     */
    @Test
    public void AccountDetail_get_1() throws Exception {
        Principal principal = null;
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/detailUser", principal)
                )
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Creator : TuanTA
     * Principal is " "
     * Goal : HttpStatus = 4xx
     * date create : 01-03-2024
     * @throws Exception
     */
    @Test
    public void AccountDetail_get_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/detailUser", " ")
                )
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Creator : TuanTA
     * Principal is Not exits
     * Goal : HttpStatus = 4xx
     * date create : 01-03-2024
     * @throws Exception
     */
    @Test
    public void AccountDetail_get_3() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("detailUser", "NotExits")
                )
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Creator : TuanTA
     * Success
     * Goal : HttpStatus = 200
     * date create : 01-03-2024
     * @throws Exception
     */
    @Test
    public void AccountDetail_get_4() throws Exception {
    Principal principal = new Principal() {
        @Override
        public String getName() {
            return "tuan123456";
        }
    };
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/account/detailUser", principal.getName())
                )
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
