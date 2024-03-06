package com.example.c0823g1_movie_backend.controller;

import com.example.c0823g1_movie_backend.dto.AccountDTO;
import com.example.c0823g1_movie_backend.model.Account;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcBuilderCustomizer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountRestController_register {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;


    /**
     * Creator : TuanTA
     * accountDTO.accountName = null
     * Goal : HttpStatus = 400
     * date create : 01-03-2024
     * @throws Exception
     */
    @Test
    public void register_accountName_13() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountName(null);
        accountDTO.setFullName("Trần Anh Tuấn");
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
            MockMvcRequestBuilders.post("/account/register").content(this.objectMapper.writeValueAsString(accountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
            .andDo(print())
            .andExpect(status().isBadRequest());
}
    /**
     * Creator : TuanTA
     * accountDTO.accountName = ""
     * Goal : HttpStatus = 400
     * date create : 01-03-2024
     * @throws Exception
     */
    @Test
    public void register_accountName_14() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountName("");
        accountDTO.setFullName("Trần Anh Tuấn");
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
                        MockMvcRequestBuilders.post("/account/register").content(this.objectMapper.writeValueAsString(accountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * Creator : TuanTA
     * accountDTO.accountName is not in correct format
     * Goal : HttpStatus = 400
     * date create : 01-03-2024
     * @throws Exception
     */
    @Test
    public void register_accountName_15() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountName("Tuấn12345");
        accountDTO.setFullName("Trần Anh Tuấn");
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
                        MockMvcRequestBuilders.post("/account/register").content(this.objectMapper.writeValueAsString(accountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * Creator : TuanTA
     * accountDTO.accountName is not greater than or equal to min length
     * Goal : HttpStatus = 400
     * date create : 01-03-2024
     * @throws Exception
     */
    @Test
    public void register_accountName_16() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountName("zxc");
        accountDTO.setFullName("Trần Anh Tuấn");
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
                        MockMvcRequestBuilders.post("/account/register").content(this.objectMapper.writeValueAsString(accountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * Creator : TuanTA
     * accountDTO.accountName is not less than or equal to max length
     * Goal : HttpStatus = 400
     * date create : 01-03-2024
     * @throws Exception
     */
    @Test
    public void register_accountName_17() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountName("zxczxcxzczxczxczxczxczxczxcz321");
        accountDTO.setFullName("Trần Anh Tuấn");
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
                        MockMvcRequestBuilders.post("/account/register").content(this.objectMapper.writeValueAsString(accountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * Creator : TuanTA
     * accountDTO.fullName = null
     * Goal : HttpStatus = 400
     * date create : 01-03-2024
     * @throws Exception
     */
    @Test
    public void register_FullName_13() throws Exception {
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
                        MockMvcRequestBuilders.post("/account/register").content(this.objectMapper.writeValueAsString(accountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
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
    public void register_FullName_14() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
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
                        MockMvcRequestBuilders.post("/account/register").content(this.objectMapper.writeValueAsString(accountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * Creator : TuanTA
     * accountDTO.fullName is not in correct format
     * Goal : HttpStatus = 400
     * date create : 01-03-2024
     * @throws Exception
     */
    @Test
    public void register_FullName_15() throws Exception {
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
                        MockMvcRequestBuilders.post("/account/register").content(this.objectMapper.writeValueAsString(accountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * Creator : TuanTA
     * accountDTO.password = null
     * Goal : HttpStatus = 400
     * date create : 01-03-2024
     * @throws Exception
     */
    @Test
    public void register_PassWord_13() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountName("tuan123456");
        accountDTO.setFullName("Trần Anh Tuấn");
        accountDTO.setPassword("dsadsadsa");
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
                        MockMvcRequestBuilders.post("/account/register").content(this.objectMapper.writeValueAsString(accountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * Creator : TuanTA
     * accountDTO.password = ""
     * Goal : HttpStatus = 400
     * date create : 01-03-2024
     * @throws Exception
     */
    @Test
    public void register_PassWord_14() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountName("tuan123456");
        accountDTO.setFullName("Trần Anh Tuấn");
        accountDTO.setPassword("");
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
                        MockMvcRequestBuilders.post("/account/register").content(this.objectMapper.writeValueAsString(accountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * Creator : TuanTA
     * accountDTO.password is not greater than or equal to min length
     * Goal : HttpStatus = 400
     * date create : 01-03-2024
     * @throws Exception
     */
    @Test
    public void register_PassWord_16() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountName("tuan123456");
        accountDTO.setFullName("Trần Anh Tuấn");
        accountDTO.setPassword("zxc");
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
                        MockMvcRequestBuilders.post("/account/register").content(this.objectMapper.writeValueAsString(accountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * Creator : TuanTA
     * accountDTO.password is not less than or equal to max length
     * Goal : HttpStatus = 400
     * date create : 01-03-2024
     * @throws Exception
     */
    @Test
    public void register_PassWord_17() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountName("tuan123456");
        accountDTO.setFullName("Trần Anh Tuấn");
        accountDTO.setPassword("zxcczxczxczxczxczxczxczx");
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
                        MockMvcRequestBuilders.post("/account/register").content(this.objectMapper.writeValueAsString(accountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
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
    public void register_PhoneNumber_13() throws Exception {
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
                        MockMvcRequestBuilders.post("/account/register").content(this.objectMapper.writeValueAsString(accountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
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
    public void register_PhoneNumber_14() throws Exception {
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
                        MockMvcRequestBuilders.post("/account/register").content(this.objectMapper.writeValueAsString(accountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
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
    public void register_PhoneNumber_15() throws Exception {
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
                        MockMvcRequestBuilders.post("/account/register").content(this.objectMapper.writeValueAsString(accountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
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
    public void register_Gender_13() throws Exception {
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
                        MockMvcRequestBuilders.post("/account/register").content(this.objectMapper.writeValueAsString(accountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
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
    public void register_email_13() throws Exception {
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
                        MockMvcRequestBuilders.post("/account/register").content(this.objectMapper.writeValueAsString(accountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
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
    public void register_email_14() throws Exception {
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
                        MockMvcRequestBuilders.post("/account/register").content(this.objectMapper.writeValueAsString(accountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
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
    public void register_email_15() throws Exception {
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
                        MockMvcRequestBuilders.post("/account/register").content(this.objectMapper.writeValueAsString(accountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
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
    public void register_address_13() throws Exception {
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
                        MockMvcRequestBuilders.post("/account/register").content(this.objectMapper.writeValueAsString(accountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
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
    public void register_address_14() throws Exception {
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
                        MockMvcRequestBuilders.post("/account/register").content(this.objectMapper.writeValueAsString(accountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * Creator : TuanTA
     * accountDTO.memberCode = null
     * Goal : HttpStatus = 400
     * date create : 01-03-2024
     * @throws Exception
     */
    @Test
    public void register_memberCode_13() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountName("tuan123456");
        accountDTO.setFullName("Trần Anh Tuấn");
        accountDTO.setPassword("cxzcxzcx");
        accountDTO.setPhoneNumber("0387274038");
        accountDTO.setGender(false);
        accountDTO.setEmail("tatuan08122k4@gmail.com");
        accountDTO.setAddress("");
        accountDTO.setMemberCode(null);
        accountDTO.setPoint(0);
        accountDTO.setIsDeleted(false);
        accountDTO.setVerificationCode("123456");
        LocalDate localDate = LocalDate.now();
        accountDTO.setBirthday(localDate);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/account/register").content(this.objectMapper.writeValueAsString(accountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * Creator : TuanTA
     * accountDTO.memberCode = ""
     * Goal : HttpStatus = 400
     * date create : 01-03-2024
     * @throws Exception
     */
    @Test
    public void register_memberCode_14() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountName("tuan123456");
        accountDTO.setFullName("Trần Anh Tuấn");
        accountDTO.setPassword("cxzcxzcx");
        accountDTO.setPhoneNumber("0387274038");
        accountDTO.setGender(false);
        accountDTO.setEmail("tatuan08122k4@gmail.com");
        accountDTO.setAddress("");
        accountDTO.setMemberCode("");
        accountDTO.setPoint(0);
        accountDTO.setIsDeleted(false);
        accountDTO.setVerificationCode("123456");
        LocalDate localDate = LocalDate.now();
        accountDTO.setBirthday(localDate);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/account/register").content(this.objectMapper.writeValueAsString(accountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * Creator : TuanTA
     * accountDTO.point = null
     * Goal : HttpStatus = 400
     * date create : 01-03-2024
     * @throws Exception
     */
    @Test
    public void register_point_13() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountName("tuan123456");
        accountDTO.setFullName("Trần Anh Tuấn");
        accountDTO.setPassword("cxzcxzcx");
        accountDTO.setPhoneNumber("0387274038");
        accountDTO.setGender(false);
        accountDTO.setEmail("tatuan08122k4@gmail.com");
        accountDTO.setAddress("");
        accountDTO.setMemberCode("TV-1");
        accountDTO.setPoint(null);
        accountDTO.setIsDeleted(false);
        accountDTO.setVerificationCode("123456");
        LocalDate localDate = LocalDate.now();
        accountDTO.setBirthday(localDate);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/account/register").content(this.objectMapper.writeValueAsString(accountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * Creator : TuanTA
     * accountDTO.VerificationCode = null
     * Goal : HttpStatus = 400
     * date create : 01-03-2024
     * @throws Exception
     */
    @Test
    public void register_VerificationCode_13() throws Exception {
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
        accountDTO.setVerificationCode(null);
        LocalDate localDate = LocalDate.now();
        accountDTO.setBirthday(localDate);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/account/register").content(this.objectMapper.writeValueAsString(accountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * Creator : TuanTA
     * accountDTO.VerificationCode = ""
     * Goal : HttpStatus = 400
     * date create : 01-03-2024
     * @throws Exception
     */
    @Test
    public void register_VerificationCode_14() throws Exception {
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
        accountDTO.setVerificationCode("");
        LocalDate localDate = LocalDate.now();
        accountDTO.setBirthday(localDate);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/account/register").content(this.objectMapper.writeValueAsString(accountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
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
    public void register_birthday_13() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountName("tuan123456");
        accountDTO.setFullName("Trần Anh Tuấn");
        accountDTO.setPassword("cxzcxzcx");
        accountDTO.setPhoneNumber("0387274038");
        accountDTO.setGender(false);
        accountDTO.setEmail("tatuan08122k4@gmail.com");
        accountDTO.setAddress("cxz");
        accountDTO.setMemberCode("TV-1");
        accountDTO.setPoint(0);
        accountDTO.setIsDeleted(false);
        accountDTO.setVerificationCode("123456");
        accountDTO.setBirthday(null);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/account/register").content(this.objectMapper.writeValueAsString(accountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * Creator : TuanTA
     * Register Success
     * Goal : HttpStatus = 200
     * date create : 01-03-2024
     * @throws Exception
     */
    @Test
    public void register_Success_18() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountName("tuan98765");
        accountDTO.setFullName("Trần Anh Tuấn");
        accountDTO.setPassword("cxzcxzcx");
        accountDTO.setPhoneNumber("0387276789");
        accountDTO.setGender(false);
        accountDTO.setEmail("cx@gmail.com");
        accountDTO.setAddress("cxzcxz");
        accountDTO.setMemberCode("TV-1");
        accountDTO.setPoint(0);
        accountDTO.setIsDeleted(false);
        accountDTO.setVerificationCode("123456");
        LocalDate localDate = LocalDate.now();
        accountDTO.setBirthday(localDate);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/account/register").content(this.objectMapper.writeValueAsString(accountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk());
    }
    /**
     * Creator : TuanTA
     * Duplicate AccountName
     * Goal : HttpStatus = 400
     * date create : 01-03-2024
     * @throws Exception
     */
    @Test
    public void register_DuplicateAccountName_100() throws Exception {
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
                        MockMvcRequestBuilders.post("/account/register").content(this.objectMapper.writeValueAsString(accountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * Creator : TuanTA
     * Duplicate Email
     * Goal : HttpStatus = 400
     * date create : 01-03-2024
     * @throws Exception
     */
    @Test
    public void register_DuplicateEmail_101() throws Exception {
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
                        MockMvcRequestBuilders.post("/account/register").content(this.objectMapper.writeValueAsString(accountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * Creator : TuanTA
     * Duplicate Phone Number
     * Goal : HttpStatus = 400
     * date create : 01-03-2024
     * @throws Exception
     */
    @Test
    public void register_DuplicatePhoneNumber_102() throws Exception {
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
                        MockMvcRequestBuilders.post("/account/register").content(this.objectMapper.writeValueAsString(accountDTO)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

}
