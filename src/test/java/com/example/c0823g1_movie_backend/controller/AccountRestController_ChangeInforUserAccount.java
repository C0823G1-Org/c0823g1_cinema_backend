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

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountRestController_ChangeInforUserAccount
{
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

//    /**
//     * Creator : TuanTA
//     * accountDTO.id = null
//     * Goal : HttpStatus = 404
//     * date create : 01-03-2024
//     * @throws Exception
//     */
//    @Test
//    public void changeInforUserAccount_id_99() throws Exception {
//        AccountDTO accountDTO = new AccountDTO();
//        accountDTO.setAccountName(null);
//        accountDTO.setFullName("Trần Anh Tuấn");
//        accountDTO.setPassword("czczxczxcz");
//        accountDTO.setPhoneNumber("0387274038");
//        accountDTO.setGender(false);
//        accountDTO.setEmail("tatuan08122k4@gmail.com");
//        accountDTO.setAddress("295 Trần Hưng Đạo");
//        accountDTO.setMemberCode("TV-1");
//        accountDTO.setPoint(0);
//        accountDTO.setIsDeleted(false);
//        accountDTO.setVerificationCode("123456");
//        LocalDate localDate = LocalDate.now();
//        accountDTO.setBirthday(localDate);
//
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.patch("/account/changeInfoUser").content(this.objectMapper.writeValueAsString(accountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().isBadRequest());
//    }
    /**
     * Creator : TuanTA
     * accountDTO.fullName = null
     * Goal : HttpStatus = 400
     * date create : 01-03-2024
     * @throws Exception
     */
    @Test
    public void changeInforUserAccount_FullName_19() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountName("tuan123456");
        accountDTO.setFullName(null);
        accountDTO.setPassword("czczxczxcz");
        accountDTO.setPhoneNumber("0387274038");
        accountDTO.setGender(false);
        accountDTO.setEmail("tatuan08122k4@gmail.com");
        accountDTO.setAddress("295 Trần Hưng Đạo");
        accountDTO.setMemberCode("TV-1");
        accountDTO.setPoint(0);
        accountDTO.setIsDeleted(false);
        accountDTO.setVerificationCode("123456");
        LocalDate localDate = LocalDate.now();
        accountDTO.setBirthday(localDate);

        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/account/changeInfoUser").content(this.objectMapper.writeValueAsString(accountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * Creator : TuanTA
     * accountDTO.fullName = ""
     * Goal : HttpStatus = 400
     * date create : 01-03-2024
     * @throws Exception
     */
    @Test
    public void changeInforUserAccount_FullName_20() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(1);
        accountDTO.setAccountName("tuan12345");
        accountDTO.setFullName("");
        accountDTO.setPassword("czczxczxcz");
        accountDTO.setPhoneNumber("0387274038");
        accountDTO.setGender(false);
        accountDTO.setEmail("tatuan08122k4@gmail.com");
        accountDTO.setAddress("295 Trần Hưng Đạo");
        accountDTO.setMemberCode("TV-1");
        accountDTO.setPoint(0);
        accountDTO.setIsDeleted(false);
        accountDTO.setVerificationCode("123456");
        LocalDate localDate = LocalDate.now();
        accountDTO.setBirthday(localDate);

        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/account/changeInfoUser").content(this.objectMapper.writeValueAsString(accountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    /**
     * Creator : TuanTA
     * accountDTO.fullName is not in correct format
     * Goal : HttpStatus = 400
     * date create : 01-03-2024
     * @throws Exception
     */
    @Test
    public void changeInforUserAccount_FullName_21() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountName("tuan12345");
        accountDTO.setFullName("Tuấn@23!");
        accountDTO.setPassword("czczxczxcz");
        accountDTO.setPhoneNumber("0387274038");
        accountDTO.setGender(false);
        accountDTO.setEmail("tatuan08122k4@gmail.com");
        accountDTO.setAddress("295 Trần Hưng Đạo");
        accountDTO.setMemberCode("TV-1");
        accountDTO.setPoint(0);
        accountDTO.setIsDeleted(false);
        accountDTO.setVerificationCode("123456");
        LocalDate localDate = LocalDate.now();
        accountDTO.setBirthday(localDate);

        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/account/changeInfoUser").content(this.objectMapper.writeValueAsString(accountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * Creator : TuanTA
     * accountDTO.phoneNumber = null
     * Goal : HttpStatus = 400
     * date create : 01-03-2024
     * @throws Exception
     */
    @Test
    public void changeInforUserAccount_PhoneNumber_19() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountName("tuan123456");
        accountDTO.setFullName("Trần Anh Tuấn");
        accountDTO.setPassword("zxczxczx");
        accountDTO.setPhoneNumber(null);
        accountDTO.setGender(false);
        accountDTO.setEmail("tatuan08122k4@gmail.com");
        accountDTO.setAddress("295 Trần Hưng Đạo");
        accountDTO.setMemberCode("TV-1");
        accountDTO.setPoint(0);
        accountDTO.setIsDeleted(false);
        accountDTO.setVerificationCode("123456");
        LocalDate localDate = LocalDate.now();
        accountDTO.setBirthday(localDate);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/account/changeInfoUser").content(this.objectMapper.writeValueAsString(accountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * Creator : TuanTA
     * accountDTO.phoneNumber = ""
     * Goal : HttpStatus = 400
     * date create : 01-03-2024
     * @throws Exception
     */
    @Test
    public void changeInforUserAccount_PhoneNumber_20() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountName("tuan123456");
        accountDTO.setFullName("Trần Anh Tuấn");
        accountDTO.setPassword("cxzcxzcx");
        accountDTO.setPhoneNumber("");
        accountDTO.setGender(false);
        accountDTO.setEmail("tatuan08122k4@gmail.com");
        accountDTO.setAddress("295 Trần Hưng Đạo");
        accountDTO.setMemberCode("TV-1");
        accountDTO.setPoint(0);
        accountDTO.setIsDeleted(false);
        accountDTO.setVerificationCode("123456");
        LocalDate localDate = LocalDate.now();
        accountDTO.setBirthday(localDate);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/account/changeInfoUser").content(this.objectMapper.writeValueAsString(accountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * Creator : TuanTA
     * accountDTO.phoneNumber is not in correct format
     * Goal : HttpStatus = 400
     * date create : 01-03-2024
     * @throws Exception
     */
    @Test
    public void changeInforUserAccount_PhoneNumber_21() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountName("tuan123456");
        accountDTO.setFullName("Trần Anh Tuấn");
        accountDTO.setPassword("cxzcxzcx");
        accountDTO.setPhoneNumber("0387274d232");
        accountDTO.setGender(false);
        accountDTO.setEmail("tatuan08122k4@gmail.com");
        accountDTO.setAddress("295 Trần Hưng Đạo");
        accountDTO.setMemberCode("TV-1");
        accountDTO.setPoint(0);
        accountDTO.setIsDeleted(false);
        accountDTO.setVerificationCode("123456");
        LocalDate localDate = LocalDate.now();
        accountDTO.setBirthday(localDate);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/account/changeInfoUser").content(this.objectMapper.writeValueAsString(accountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * Creator : TuanTA
     * accountDTO.gender = null
     * Goal : HttpStatus = 400
     * date create : 01-03-2024
     * @throws Exception
     */
    @Test
    public void changeInforUserAccount_Gender_19() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountName("tuan123456");
        accountDTO.setFullName("Trần Anh Tuấn");
        accountDTO.setPassword("cxzcxzcx");
        accountDTO.setPhoneNumber("0387274038");
        accountDTO.setGender(null);
        accountDTO.setEmail("tatuan08122k4@gmail.com");
        accountDTO.setAddress("295 Trần Hưng Đạo");
        accountDTO.setMemberCode("TV-1");
        accountDTO.setPoint(0);
        accountDTO.setIsDeleted(false);
        accountDTO.setVerificationCode("123456");
        LocalDate localDate = LocalDate.now();
        accountDTO.setBirthday(localDate);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/account/changeInfoUser").content(this.objectMapper.writeValueAsString(accountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * Creator : TuanTA
     * accountDTO.email = null
     * Goal : HttpStatus = 400
     * date create : 01-03-2024
     * @throws Exception
     */
    @Test
    public void changeInforUserAccount_email_19() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountName("tuan123456");
        accountDTO.setFullName("Trần Anh Tuấn");
        accountDTO.setPassword("cxzcxzcx");
        accountDTO.setPhoneNumber("0387274038");
        accountDTO.setGender(false);
        accountDTO.setEmail(null);
        accountDTO.setAddress("295 Trần Hưng Đạo");
        accountDTO.setMemberCode("TV-1");
        accountDTO.setPoint(0);
        accountDTO.setIsDeleted(false);
        accountDTO.setVerificationCode("123456");
        LocalDate localDate = LocalDate.now();
        accountDTO.setBirthday(localDate);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/account/changeInfoUser").content(this.objectMapper.writeValueAsString(accountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * Creator : TuanTA
     * accountDTO.email = ""
     * Goal : HttpStatus = 400
     * date create : 01-03-2024
     * @throws Exception
     */
    @Test
    public void changeInforUserAccount_email_20() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountName("tuan123456");
        accountDTO.setFullName("Trần Anh Tuấn");
        accountDTO.setPassword("cxzcxzcx");
        accountDTO.setPhoneNumber("0387274038");
        accountDTO.setGender(false);
        accountDTO.setEmail("");
        accountDTO.setAddress("295 Trần Hưng Đạo");
        accountDTO.setMemberCode("TV-1");
        accountDTO.setPoint(0);
        accountDTO.setIsDeleted(false);
        accountDTO.setVerificationCode("123456");
        LocalDate localDate = LocalDate.now();
        accountDTO.setBirthday(localDate);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/account/changeInfoUser").content(this.objectMapper.writeValueAsString(accountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * Creator : TuanTA
     * accountDTO.email is not in correct format
     * Goal : HttpStatus = 400
     * date create : 01-03-2024
     * @throws Exception
     */
    @Test
    public void changeInforUserAccount_email_21() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountName("tuan123456");
        accountDTO.setFullName("Trần Anh Tuấn");
        accountDTO.setPassword("cxzcxzcx");
        accountDTO.setPhoneNumber("0387274038");
        accountDTO.setGender(false);
        accountDTO.setEmail("cxzcxzdsa");
        accountDTO.setAddress("295 Trần Hưng Đạo");
        accountDTO.setMemberCode("TV-1");
        accountDTO.setPoint(0);
        accountDTO.setIsDeleted(false);
        accountDTO.setVerificationCode("123456");
        LocalDate localDate = LocalDate.now();
        accountDTO.setBirthday(localDate);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/account/changeInfoUser").content(this.objectMapper.writeValueAsString(accountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * Creator : TuanTA
     * accountDTO.address = null
     * Goal : HttpStatus = 400
     * date create : 01-03-2024
     * @throws Exception
     */
    @Test
    public void changeInforUserAccount_address_19() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountName("tuan123456");
        accountDTO.setFullName("Trần Anh Tuấn");
        accountDTO.setPassword("cxzcxzcx");
        accountDTO.setPhoneNumber("0387274038");
        accountDTO.setGender(false);
        accountDTO.setEmail("tatuan08122k4@gmail.com");
        accountDTO.setAddress(null);
        accountDTO.setMemberCode("TV-1");
        accountDTO.setPoint(0);
        accountDTO.setIsDeleted(false);
        accountDTO.setVerificationCode("123456");
        LocalDate localDate = LocalDate.now();
        accountDTO.setBirthday(localDate);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/account/changeInfoUser").content(this.objectMapper.writeValueAsString(accountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * Creator : TuanTA
     * accountDTO.address = ""
     * Goal : HttpStatus = 400
     * date create : 01-03-2024
     * @throws Exception
     */
    @Test
    public void changeInforUserAccount_address_20() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountName("tuan123456");
        accountDTO.setFullName("Trần Anh Tuấn");
        accountDTO.setPassword("cxzcxzcx");
        accountDTO.setPhoneNumber("0387274038");
        accountDTO.setGender(false);
        accountDTO.setEmail("tatuan08122k4@gmail.com");
        accountDTO.setAddress("");
        accountDTO.setMemberCode("TV-1");
        accountDTO.setPoint(0);
        accountDTO.setIsDeleted(false);
        accountDTO.setVerificationCode("123456");
        LocalDate localDate = LocalDate.now();
        accountDTO.setBirthday(localDate);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/account/changeInfoUser").content(this.objectMapper.writeValueAsString(accountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * Creator : TuanTA
     * accountDTO.birthday = null
     * Goal : HttpStatus = 400
     * date create : 01-03-2024
     * @throws Exception
     */
    @Test
    public void changeInforUserAccount_birthday_19() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountName("tuan123456");
        accountDTO.setFullName("Trần Anh Tuấn");
        accountDTO.setPassword("cxzcxzcx");
        accountDTO.setPhoneNumber("0387274038");
        accountDTO.setGender(false);
        accountDTO.setEmail("tatuan08122k4@gmail.com");
        accountDTO.setAddress("");
        accountDTO.setMemberCode("TV-1");
        accountDTO.setPoint(0);
        accountDTO.setIsDeleted(false);
        accountDTO.setVerificationCode("123456");
        accountDTO.setBirthday(null);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/account/changeInfoUser").content(this.objectMapper.writeValueAsString(accountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * Creator : TuanTA
     * accountDTO.birthday = null
     * Goal : HttpStatus = 200
     * date create : 01-03-2024
     * @throws Exception
     */
    @Test
    public void changeInforUserAccount_Success_24() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountName("tuan123456");
        accountDTO.setFullName("Trần Anh Tuấn");
        accountDTO.setPassword("cxzcxzcx");
        accountDTO.setPhoneNumber("0387274038");
        accountDTO.setGender(false);
        accountDTO.setEmail("tatuan08122k4@gmail.com");
        accountDTO.setAddress("");
        accountDTO.setMemberCode("TV-1");
        accountDTO.setPoint(0);
        accountDTO.setIsDeleted(false);
        accountDTO.setVerificationCode("123456");
        LocalDate localDate = LocalDate.now();
        accountDTO.setBirthday(localDate);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/account/changeInfoUser").content(this.objectMapper.writeValueAsString(accountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk());
    }


}
