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
public class AccountRestController_loginByEmail {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /* Create by: BaoNDT
     * Date created: 01/03/2024
     * Test: user enters the correct email and password and the result is HttpStatus.OK
     */
    @Test
    public void loginByEmail_accountDTO_1() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setEmail("nguyendinhthaibao63@gmail.com");
        accountDTO.setPassword("mODL9k");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/account/login-email")
                        .content(this.objectMapper.writeValueAsString(accountDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


    /* Create by: BaoNDT
     * Date created: 01/03/2024
     * Test: user entered an incorrect email and the result is HttpStatus.BAD_REQUEST
     */
    @Test
    public void loginByEmail_accountDTO_2() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setEmail("nguyendinhthaibao@gmail.com");
        accountDTO.setPassword("mODL9k");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/account/login-email")
                        .content(this.objectMapper.writeValueAsString(accountDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /* Create by: BaoNDT
     * Date created: 01/03/2024
     * Test: user entered an incorrect password and email. The result is HttpStatus.BAD_REQUEST
     */
    @Test
    public void loginByEmail_accountDTO_3() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setEmail("nguyendinhthaibao@gmail.com");
        accountDTO.setPassword("mODL9kaaa");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/account/login-email")
                        .content(this.objectMapper.writeValueAsString(accountDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /* Create by: BaoNDT
     * Date created: 01/03/2024
     * Test: user entered an incorrect password and the result is HttpStatus.BAD_REQUEST
     */
    @Test
    public void loginByEmail_accountDTO_4() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setEmail("nguyendinhthaibao63@gmail.com");
        accountDTO.setPassword("mODL9aak");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/account/login-email")
                        .content(this.objectMapper.writeValueAsString(accountDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
