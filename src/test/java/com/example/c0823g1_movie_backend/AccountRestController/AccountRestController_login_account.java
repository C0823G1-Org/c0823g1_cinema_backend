package com.example.c0823g1_movie_backend.AccountRestController;


import com.example.c0823g1_movie_backend.model.Account;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountRestController_login_account {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /* Create by: BaoNDT
     * Date created: 01/03/2024
     * Test: user enters the correct account name and password and the result is HttpStatus.OK
     */
    @Test
    public void login_account_1() throws Exception {
        Account account = new Account();
        account.setAccountName("aaa");
        account.setPassword("aaa");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/account/login")
                        .content(this.objectMapper.writeValueAsString(account))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /* Create by: BaoNDT
     * Date created: 01/03/2024
     * Test: user entered an incorrect password and the result is HttpStatus.BAD_REQUEST
     */
    @Test
    public void login_account_2() throws Exception {
        Account account = new Account();
        account.setAccountName("aaa");
        account.setPassword("bbb");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/account/login")
                        .content(this.objectMapper.writeValueAsString(account))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /* Create by: BaoNDT
     * Date created: 01/03/2024
     * Test: user entered an incorrect password and account name and the result is HttpStatus.BAD_REQUEST
     */
    @Test
    public void login_account_3() throws Exception {
        Account account = new Account();
        account.setAccountName("bbb");
        account.setPassword("bbb");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/account/login")
                        .content(this.objectMapper.writeValueAsString(account))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /* Create by: BaoNDT
     * Date created: 01/03/2024
     * Test: user entered an incorrect account name and the result is HttpStatus.BAD_REQUEST
     */
    @Test
    public void login_account_4() throws Exception {
        Account account = new Account();
        account.setAccountName("bbb");
        account.setPassword("aaa");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/account/login")
                        .content(this.objectMapper.writeValueAsString(account))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
