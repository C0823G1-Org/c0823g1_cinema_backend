package com.example.c0823g1_movie_backend.controller;


import com.example.c0823g1_movie_backend.dto.AccountDTO;
import com.example.c0823g1_movie_backend.model.Account;
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
public class AccountRestController_login {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /* Create by: BaoNDT
     * Date created: 01/03/2024
     * Test: user enters the correct account name and password and the result is HttpStatus.OK
     */
    @Test
    public void login_accountDTO_1() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountName("aaa");
        accountDTO.setPassword("aaa");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/account/login")
                        .content(this.objectMapper.writeValueAsString(accountDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /* Create by: BaoNDT
     * Date created: 01/03/2024
     * Test: user entered an incorrect password and the result is HttpStatus.BAD_REQUEST
     */
    @Test
    public void login_accountDTO_2() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountName("aaa");
        accountDTO.setPassword("bbb");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/account/login")
                        .content(this.objectMapper.writeValueAsString(accountDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /* Create by: BaoNDT
     * Date created: 01/03/2024
     * Test: user entered an incorrect password and account name. The result is HttpStatus.BAD_REQUEST
     */
    @Test
    public void login_accountDTO_3() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountName("bbb");
        accountDTO.setPassword("bbb");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/account/login")
                        .content(this.objectMapper.writeValueAsString(accountDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /* Create by: BaoNDT
     * Date created: 01/03/2024
     * Test: user entered an incorrect account name and the result is HttpStatus.BAD_REQUEST
     */
    @Test
    public void login_accountDTO_4() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountName("bbb");
        accountDTO.setPassword("aaa");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/account/login")
                        .content(this.objectMapper.writeValueAsString(accountDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
