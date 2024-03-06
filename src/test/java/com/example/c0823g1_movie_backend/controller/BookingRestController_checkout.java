package com.example.c0823g1_movie_backend.controller;

import com.example.c0823g1_movie_backend.dto.CheckoutDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BookingRestController_checkout {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    /**
     * Creator: HaiNT
     * Goal: HttpStatus = 200
     * date create: 1/3/2024
     */

    @Test
    public void checkout_18() throws Exception {

        CheckoutDTO checkoutDTO = new CheckoutDTO();
        List<Integer> seatList = new ArrayList<>();
        seatList.add(1);
        seatList.add(2);
        seatList.add(3);
        checkoutDTO.setTotalAmount(135000L);
        checkoutDTO.setAccountId(1L);
        checkoutDTO.setScheduleId(1L);
        checkoutDTO.setSeatNumber(seatList);

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post(
                                        "/booking/checkout")
                                .content(this.objectMapper.writeValueAsString(checkoutDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))

                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Creator: HaiNT
     * checkoutDTO = null
     * Goal: HttpStatus = 400
     * date create: 1/3/2024
     */

    @Test
    public void checkout_13() throws Exception {

        CheckoutDTO checkoutDTO = new CheckoutDTO();

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post(
                                        "/booking/checkout")
                                .content(this.objectMapper.writeValueAsString(checkoutDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))

                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Creator: HaiNT
     * checkoutDTO.accountId = null
     * Goal: HttpStatus = 400
     * date create: 1/3/2024
     */


    @Test
    public void checkout_accountId_13() throws Exception {

        CheckoutDTO checkoutDTO = new CheckoutDTO();
        List<Integer> seatList = new ArrayList<>();
        seatList.add(1);
        seatList.add(2);
        seatList.add(3);
        checkoutDTO.setTotalAmount(135000L);

        checkoutDTO.setScheduleId(1L);
        checkoutDTO.setSeatNumber(seatList);

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post(
                                        "/booking/checkout")
                                .content(this.objectMapper.writeValueAsString(checkoutDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))

                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Creator: HaiNT
     * checkoutDTO.scheduleId = null
     * Goal: HttpStatus = 400
     * date create: 1/3/2024
     */


    @Test
    public void checkout_scheduleId_13() throws Exception {

        CheckoutDTO checkoutDTO = new CheckoutDTO();
        List<Integer> seatList = new ArrayList<>();
        seatList.add(1);
        seatList.add(2);
        seatList.add(3);
        checkoutDTO.setAccountId(1L);
        checkoutDTO.setTotalAmount(135000L);

        checkoutDTO.setSeatNumber(seatList);

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post(
                                        "/booking/checkout")
                                .content(this.objectMapper.writeValueAsString(checkoutDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))

                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Creator: HaiNT
     * checkoutDTO.seatList is Empty
     * Goal: HttpStatus = 400
     * date create: 1/3/2024
     */

    @Test
    public void checkout_seatList_14() throws Exception {

        CheckoutDTO checkoutDTO= new CheckoutDTO();
        List<Integer> seatList = new ArrayList<>();
        checkoutDTO.setScheduleId(1L);
        checkoutDTO.setSeatNumber(seatList);
        checkoutDTO.setTotalAmount(135000L);

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post(
                                        "/booking/checkout")
                                .content(this.objectMapper.writeValueAsString(checkoutDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))

                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Creator: HaiNT
     * checkoutDTO.seatList == null
     * Goal: HttpStatus = 400
     * date create: 1/3/2024
     */

    @Test
    public void checkout_seatList_13() throws Exception {

        CheckoutDTO checkoutDTO= new CheckoutDTO();

        checkoutDTO.setScheduleId(1L);

        checkoutDTO.setTotalAmount(135000L);

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post(
                                        "/booking/checkout")
                                .content(this.objectMapper.writeValueAsString(checkoutDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))

                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Creator: HaiNT
     * checkoutDTO.seatNumber does not exist in hall
     * Goal: HttpStatus = 400
     * date create: 1/3/2024
     */

    @Test
    public void checkout_seatList_98() throws Exception {

        CheckoutDTO checkoutDTO = new CheckoutDTO();
        List<Integer> seatList = new ArrayList<>();
        seatList.add(-1);
        seatList.add(2);
        seatList.add(52);
        checkoutDTO.setTotalAmount(135000L);

        checkoutDTO.setAccountId(1L);
        checkoutDTO.setScheduleId(1L);
        checkoutDTO.setSeatNumber(seatList);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post(
                                        "/booking/checkout")
                                .content(this.objectMapper.writeValueAsString(checkoutDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))

                .andDo(print())
                .andExpect(status().is4xxClientError());
    }



    /**
     * Creator: HaiNT
     * checkoutDTO.scheduleId does not exist
     * Goal: HttpStatus = 400
     * date create: 1/3/2024
     */

    @Test
    public void checkout_scheduleId_98() throws Exception {

        CheckoutDTO checkoutDTO = new CheckoutDTO();
        List<Integer> seatList = new ArrayList<>();
        seatList.add(1);
        seatList.add(2);
        seatList.add(3);
        checkoutDTO.setTotalAmount(135000L);
        checkoutDTO.setAccountId(1L);
        checkoutDTO.setScheduleId(2L);
        checkoutDTO.setSeatNumber(seatList);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post(
                                        "/booking/checkout")
                                .content(this.objectMapper.writeValueAsString(checkoutDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))

                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Creator: HaiNT
     * checkoutDTO.accountId does not exist in database
     * Goal: HttpStatus = 400
     * date create: 1/3/2024
     */


    @Test
    public void checkout_accountId_98() throws Exception {

        CheckoutDTO checkoutDTO = new CheckoutDTO();
        List<Integer> seatList = new ArrayList<>();
        seatList.add(1);
        seatList.add(2);
        seatList.add(3);
        checkoutDTO.setTotalAmount(135000L);

        checkoutDTO.setAccountId(2L);
        checkoutDTO.setScheduleId(1L);
        checkoutDTO.setSeatNumber(seatList);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post(
                                        "/booking/checkout")
                                .content(this.objectMapper.writeValueAsString(checkoutDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))

                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Creator: HaiNT
     * checkoutDTO.seatList: seatNumber is existed in database
     * Goal: HttpStatus = 400
     * date create: 1/3/2024
     */

    @Test
    public void checkout_seatNumber_98() throws Exception {

        CheckoutDTO checkoutDTO = new CheckoutDTO();
        List<Integer> seatList = new ArrayList<>();
        seatList.add(1);
        seatList.add(2);
        seatList.add(3);
        checkoutDTO.setAccountId(1L);
        checkoutDTO.setScheduleId(1L);
        checkoutDTO.setSeatNumber(seatList);
        checkoutDTO.setTotalAmount(135000L);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post(
                                        "/booking/checkout")
                                .content(this.objectMapper.writeValueAsString(checkoutDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))

                .andDo(print())
                .andExpect(status().is4xxClientError());
    }



    /**
     * Creator: HaiNT
     * checkoutDTO.totalPrice <= 0
     * Goal: HttpStatus = 400
     * date create: 1/3/2024
     */

    @Test
    public void checkout_totalAmount_96() throws Exception {

        CheckoutDTO checkoutDTO = new CheckoutDTO();
        List<Integer> seatList = new ArrayList<>();
        seatList.add(1);
        seatList.add(2);
        seatList.add(3);
        checkoutDTO.setAccountId(1L);
        checkoutDTO.setScheduleId(1L);
        checkoutDTO.setSeatNumber(seatList);
        checkoutDTO.setTotalAmount(-135000L);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post(
                                        "/booking/checkout")
                                .content(this.objectMapper.writeValueAsString(checkoutDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))

                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Creator: HaiNT
     * checkoutDTO.totalAmount = null
     * Goal: HttpStatus = 400
     * date create: 1/3/2024
     */

    @Test
    public void checkout_totalAmount_95() throws Exception {

        CheckoutDTO checkoutDTO = new CheckoutDTO();
        List<Integer> seatList = new ArrayList<>();
        seatList.add(1);
        seatList.add(2);
        seatList.add(3);
        checkoutDTO.setAccountId(1L);
        checkoutDTO.setScheduleId(1L);
        checkoutDTO.setSeatNumber(seatList);
//        checkoutDTO.setTotalAmount(null);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post(
                                        "/booking/checkout")
                                .content(this.objectMapper.writeValueAsString(checkoutDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))

                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


}
