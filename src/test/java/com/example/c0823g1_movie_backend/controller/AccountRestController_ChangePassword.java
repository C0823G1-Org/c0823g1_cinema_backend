package com.example.c0823g1_movie_backend.controller;


import com.example.c0823g1_movie_backend.dto.AccountDTO;
import com.example.c0823g1_movie_backend.model.ChangePasswordDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountRestController_ChangePassword {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Creator : TuanTA
     * changePasswordDTO.currentPassword = null
     * Goal : HttpStatus = 400
     * date create : 01-03-2024
     * @throws Exception
     */
    @Test
    public void changePassword_currentPassword_19() throws Exception {
        ChangePasswordDto changePasswordDto = new ChangePasswordDto();
        changePasswordDto.setCurrentPassword(null);
        changePasswordDto.setNewPassword("tuan123456");
        changePasswordDto.setConfirmationPassword("tuan123456");


        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/account/changePassword").content(this.objectMapper.writeValueAsString(changePasswordDto)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * Creator : TuanTA
     * changePasswordDTO.currentPassword = ""
     * Goal : HttpStatus = 400
     * date create : 01-03-2024
     * @throws Exception
     */
    @Test
    public void changePassword_currentPassword_20() throws Exception {
        ChangePasswordDto changePasswordDto = new ChangePasswordDto();
        changePasswordDto.setCurrentPassword("");
        changePasswordDto.setNewPassword("tuan123456");
        changePasswordDto.setConfirmationPassword("tuan123456");


        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/account/changePassword").content(this.objectMapper.writeValueAsString(changePasswordDto)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * Creator : TuanTA
     * changePasswordDTO.currentPassword is not greater than or equal to min length
     * Goal : HttpStatus = 400
     * date create : 01-03-2024
     * @throws Exception
     */
    @Test
    public void changePassword_currentPassword_22() throws Exception {
        ChangePasswordDto changePasswordDto = new ChangePasswordDto();
        changePasswordDto.setCurrentPassword("zxc");
        changePasswordDto.setNewPassword("tuan123456");
        changePasswordDto.setConfirmationPassword("tuan123456");


        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/account/changePassword").content(this.objectMapper.writeValueAsString(changePasswordDto)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * Creator : TuanTA
     * changePasswordDTO.currentPassword is not less than or equal to max length
     * Goal : HttpStatus = 400
     * date create : 01-03-2024
     * @throws Exception
     */
    @Test
    public void changePassword_currentPassword_23() throws Exception {
        ChangePasswordDto changePasswordDto = new ChangePasswordDto();
        changePasswordDto.setCurrentPassword("zxcczxcxzcxzcxzczxczxcxzcxzczxcx");
        changePasswordDto.setNewPassword("tuan123456");
        changePasswordDto.setConfirmationPassword("tuan123456");


        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/account/changePassword").content(this.objectMapper.writeValueAsString(changePasswordDto)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * Creator : TuanTA
     * changePasswordDTO.newPassword = null
     * Goal : HttpStatus = 400
     * date create : 01-03-2024
     * @throws Exception
     */
    @Test
    public void changePassword_newPassword_19() throws Exception {
        ChangePasswordDto changePasswordDto = new ChangePasswordDto();
        changePasswordDto.setCurrentPassword("bao123456");
        changePasswordDto.setNewPassword(null);
        changePasswordDto.setConfirmationPassword("tuan123456");


        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/account/changePassword").content(this.objectMapper.writeValueAsString(changePasswordDto)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * Creator : TuanTA
     * changePasswordDTO.newPassword = ""
     * Goal : HttpStatus = 400
     * date create : 01-03-2024
     * @throws Exception
     */
    @Test
    public void changePassword_newPassword_20() throws Exception {
        ChangePasswordDto changePasswordDto = new ChangePasswordDto();
        changePasswordDto.setCurrentPassword("bao123456");
        changePasswordDto.setNewPassword("");
        changePasswordDto.setConfirmationPassword("tuan123456");


        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/account/changePassword").content(this.objectMapper.writeValueAsString(changePasswordDto)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * Creator : TuanTA
     * changePasswordDTO.newPassword  is not greater than or equal to min length
     * Goal : HttpStatus = 400
     * date create : 01-03-2024
     * @throws Exception
     */
    @Test
    public void changePassword_newPassword_22() throws Exception {
        ChangePasswordDto changePasswordDto = new ChangePasswordDto();
        changePasswordDto.setCurrentPassword("bao123456");
        changePasswordDto.setNewPassword("zxc");
        changePasswordDto.setConfirmationPassword("zxc");


        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/account/changePassword").content(this.objectMapper.writeValueAsString(changePasswordDto)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * Creator : TuanTA
     * changePasswordDTO.newPassword  is not less than or equal to max length
     * Goal : HttpStatus = 400
     * date create : 01-03-2024
     * @throws Exception
     */
    @Test
    public void changePassword_newPassword_23() throws Exception {
        ChangePasswordDto changePasswordDto = new ChangePasswordDto();
        changePasswordDto.setCurrentPassword("bao123456");
        changePasswordDto.setNewPassword("zxczxczxczxczxczxczxc");
        changePasswordDto.setConfirmationPassword("zxczxczxczxczxczxczxc");


        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/account/changePassword").content(this.objectMapper.writeValueAsString(changePasswordDto)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * Creator : TuanTA
     * changePasswordDTO.newPassword  is not equal changePasswordDTO.confirmationPassword
     * Goal : HttpStatus = 400
     * date create : 01-03-2024
     * @throws Exception
     */
    @Test
    public void changePassword_newPassword_99() throws Exception {
        ChangePasswordDto changePasswordDto = new ChangePasswordDto();
        changePasswordDto.setCurrentPassword("bao123456");
        changePasswordDto.setNewPassword("tuan123456");
        changePasswordDto.setConfirmationPassword("tuan98765");


        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/account/changePassword").content(this.objectMapper.writeValueAsString(changePasswordDto)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * Creator : TuanTA
     * changePasswordDTO.newPassword  is not equal changePasswordDTO.confirmationPassword
     * Goal : HttpStatus = 200
     * date create : 01-03-2024
     * @throws Exception
     */
    @Test
    public void changePassword_sucess_24() throws Exception {
        ChangePasswordDto changePasswordDto = new ChangePasswordDto();
        changePasswordDto.setCurrentPassword("bao123456");
        changePasswordDto.setNewPassword("tuan123456");
        changePasswordDto.setConfirmationPassword("tuan123456");


        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/account/changePassword").content(this.objectMapper.writeValueAsString(changePasswordDto)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk());
    }


}
