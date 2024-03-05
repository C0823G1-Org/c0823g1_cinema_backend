package com.example.c0823g1_movie_backend.controller;

import com.example.c0823g1_movie_backend.dto.TokenDTO;
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
public class AccountRestController_loginByFacebook {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /* Create by: BaoNDT
     * Date created: 01/03/2024
     * Test: The user login with Facebook and the accessToken code is sent to the server correctly. The result is HttpStatus.OK
     */
    @Test
    public void loginByFacebook_tokenDTO_1() throws Exception {
        TokenDTO tokenDTO = new TokenDTO();
        tokenDTO.setValue("EAAV0GiSzsSsBO7qcBejHf3dbSLcwYG1f8ZCEJ1z9CKHeTJjZCAjzJEZAUn4xeTYlMthXzmFZCkRBjzj8KaxuiLzaPMsENkcfOSUGzzhe7nIomB41PyNEZBEnxTot0xqZALuGB5O4cvi9Csm4QUfMQrILfFKcyt3X6GwxmGxw27uoMDZAVwGbE4lQ0BeZADVBzwwVeWHCxvXhF7dPHQo9YwZDZD");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/account/login-by-fb")
                        .content(this.objectMapper.writeValueAsString(tokenDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /* Create by: BaoNDT
     * Date created: 01/03/2024
     * Test: The user login with Facebook and the accessToken is incorrectly sent to the server. The result is HttpStatus.INTERNAL_SERVER_ERROR
     */
    @Test
    public void loginByFacebook_tokenDTO_2() throws Exception {
        TokenDTO tokenDTO = new TokenDTO();
        tokenDTO.setValue("EAAV0GiSzsSsBO7qcBejHasf8ZCEJ1z9CKHeTJjZCAjzJEZAUn4xeTYlMthXzmFZCkRBjzj8KaxuiLzaPMsENkcfOSUGzzhe7nIomB41PyNEZBEnxTot0xqZALuGB5O4cvi9Csm4QUfMQrILfFKcyt3X6GwxmGxw27uoMDZAVwGbE4lQ0BeZADVBzwwVeWHCxvXhF7dPHQo9YwZDZD");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/account/login-by-fb")
                        .content(this.objectMapper.writeValueAsString(tokenDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is5xxServerError());
    }

    /* Create by: BaoNDT
     * Date created: 01/03/2024
     * Test: The user login with Facebook and the access Token is sent correctly to the server but the user's account is locked on the system. The result is HttpStatus.BAD_REQUEST
     */
    @Test
    public void loginByFacebook_tokenDTO_3() throws Exception {
        TokenDTO tokenDTO = new TokenDTO();
        tokenDTO.setValue("EAAV0GiSzsSsBO7qcBejHf3dbSLcwYG1f8ZCEJ1z9CKHeTJjZCAjzJEZAUn4xeTYlMthXzmFZCkRBjzj8KaxuiLzaPMsENkcfOSUGzzhe7nIomB41PyNEZBEnxTot0xqZALuGB5O4cvi9Csm4QUfMQrILfFKcyt3X6GwxmGxw27uoMDZAVwGbE4lQ0BeZADVBzwwVeWHCxvXhF7dPHQo9YwZDZD");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/account/login-by-fb")
                        .content(this.objectMapper.writeValueAsString(tokenDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
