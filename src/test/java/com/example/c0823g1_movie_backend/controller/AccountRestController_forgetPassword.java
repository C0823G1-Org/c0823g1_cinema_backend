package com.example.c0823g1_movie_backend.controller;

import com.example.c0823g1_movie_backend.dto.AccountDTO;
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
public class AccountRestController_forgetPassword {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /* Create by: BaoNDT
     * Date created: 01/03/2024
     * Test: Users enter the correct email to retrieve their password. The result is HttpStatus.OK
     */
    @Test
    public void forgetPassword_accountDTO_1() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setEmail("nguyendinhthaibao63@gmail.com");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/account/forget-password")
                        .content(this.objectMapper.writeValueAsString(accountDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /* Create by: BaoNDT
     * Date created: 01/03/2024
     * Test: Users enter the wrong email to retrieve their password. The result is HttpStatus.BAD_REQUEST
     */
    @Test
    public void forgetPassword_accountDTO_2() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setEmail("nguyendinhthaibao@gmail.com");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/account/forget-password")
                        .content(this.objectMapper.writeValueAsString(accountDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
