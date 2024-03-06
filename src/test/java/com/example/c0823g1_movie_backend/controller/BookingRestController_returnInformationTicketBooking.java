package com.example.c0823g1_movie_backend.controller;

import com.example.c0823g1_movie_backend.dto.TicketDTO;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BookingRestController_returnInformationTicketBooking {
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
    public void returnInformationTicketBooking_movieId_18() throws Exception {
        TicketDTO ticketDTO = new TicketDTO();
        List<Integer> seatList = new ArrayList<>();
        seatList.add(1);
        seatList.add(2);
        seatList.add(3);
        ticketDTO.setIdMovie(1L);
        ticketDTO.setAccountId(1L);
        ticketDTO.setScheduleId(1L);
        ticketDTO.setSeatList(seatList);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post(
                                "/booking/confirm")
                                .content(this.objectMapper.writeValueAsString(ticketDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))

                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }


    /**
     * Creator: HaiNT
     * ticketDTO = null
     * Goal: HttpStatus = 400
     * date create: 1/3/2024
     */

    @Test
    public void returnInformationTicketBooking_ticket_13() throws Exception {

          TicketDTO ticketDTO = null;

        this.mockMvc.perform(
                          MockMvcRequestBuilders.post(
                                          "/booking/confirm")
                                  .content(this.objectMapper.writeValueAsString(ticketDTO))
                                  .contentType(MediaType.APPLICATION_JSON_VALUE))

                  .andDo(print())
                  .andExpect(status().is4xxClientError());
    }

    /**
     * Creator: HaiNT
     * ticketDTO.movieId = null
     * Goal: HttpStatus = 400
     * date create: 1/3/2024
     */
    @Test
    public void returnInformationTicketBooking_movieId_13() throws Exception {

        TicketDTO ticketDTO = new TicketDTO();
        List<Integer> seatList = new ArrayList<>();
        seatList.add(1);
        seatList.add(2);
        seatList.add(3);

        ticketDTO.setAccountId(1L);
        ticketDTO.setScheduleId(1L);
        ticketDTO.setSeatList(seatList);

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post(
                                        "/booking/confirm")
                                .content(this.objectMapper.writeValueAsString(ticketDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))

                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Creator: HaiNT
     * ticketDTO.accountId = null
     * Goal: HttpStatus = 400
     * date create: 1/3/2024
     */

    @Test
    public void returnInformationTicketBooking_accountId_13() throws Exception {

        TicketDTO ticketDTO = new TicketDTO();
        List<Integer> seatList = new ArrayList<>();
        seatList.add(1);
        seatList.add(2);
        seatList.add(3);
        ticketDTO.setIdMovie(1L);

        ticketDTO.setScheduleId(1L);
        ticketDTO.setSeatList(seatList);

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post(
                                        "/booking/confirm")
                                .content(this.objectMapper.writeValueAsString(ticketDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))

                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Creator: HaiNT
     * ticketDTO.scheduleId = null
     * Goal: HttpStatus = 400
     * date create: 1/3/2024
     */

    @Test
    public void returnInformationTicketBooking_scheduleId_13() throws Exception {

        TicketDTO ticketDTO = new TicketDTO();
        List<Integer> seatList = new ArrayList<>();
        seatList.add(1);
        seatList.add(2);
        seatList.add(3);
        ticketDTO.setIdMovie(1L);
        ticketDTO.setAccountId(1L);

        ticketDTO.setSeatList(seatList);

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post(
                                        "/booking/confirm")
                                .content(this.objectMapper.writeValueAsString(ticketDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))

                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Creator: HaiNT
     * ticketDTO.seatList is Empty
     * Goal: HttpStatus = 400
     * date create: 1/3/2024
     */


    @Test
    public void returnInformationTicketBooking_seatList_14() throws Exception {

        TicketDTO ticketDTO = new TicketDTO();
        List<Integer> seatList = new ArrayList<>();
        ticketDTO.setIdMovie(1L);
        ticketDTO.setAccountId(1L);
        ticketDTO.setSeatList(seatList);
        ticketDTO.setScheduleId(1L);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post(
                                        "/booking/confirm")
                                .content(this.objectMapper.writeValueAsString(ticketDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))

                .andDo(print())
                .andExpect(status().is4xxClientError());
    }





    /**
     * Creator: HaiNT
     * ticketDTO.seatList does exist in hall
     * Goal: HttpStatus = 400
     * date create: 1/3/2024
     */
    @Test
    public void returnInformationTicketBooking_seatList_98() throws Exception {

        TicketDTO ticketDTO = new TicketDTO();
        List<Integer> seatList = new ArrayList<>();
        seatList.add(-11);
        seatList.add(2);
        seatList.add(52);
        ticketDTO.setIdMovie(1L);
        ticketDTO.setAccountId(1L);
        ticketDTO.setScheduleId(1L);
        ticketDTO.setSeatList(seatList);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post(
                                        "/booking/confirm")
                                .content(this.objectMapper.writeValueAsString(ticketDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))

                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Creator: HaiNT
     * ticketDTO.movieId does not exist in database
     * Goal: HttpStatus = 400
     * date create: 1/3/2024
     */

    @Test
    public void returnInformationTicketBooking_movieId_98() throws Exception {

        TicketDTO ticketDTO = new TicketDTO();
        List<Integer> seatList = new ArrayList<>();
        seatList.add(1);
        seatList.add(2);
        seatList.add(3);
        ticketDTO.setIdMovie(2L);
        ticketDTO.setAccountId(1L);
        ticketDTO.setScheduleId(1L);
        ticketDTO.setSeatList(seatList);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post(
                                        "/booking/confirm")
                                .content(this.objectMapper.writeValueAsString(ticketDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))

                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Creator: HaiNT
     * ticketDTO.scheduleId does not exist in database
     * Goal: HttpStatus = 400
     * date create: 1/3/2024
     */


    @Test
    public void returnInformationTicketBooking_scheduleId_98() throws Exception {

        TicketDTO ticketDTO = new TicketDTO();
        List<Integer> seatList = new ArrayList<>();
        seatList.add(1);
        seatList.add(2);
        seatList.add(3);
        ticketDTO.setIdMovie(1L);
        ticketDTO.setAccountId(1L);
        ticketDTO.setScheduleId(2L);
        ticketDTO.setSeatList(seatList);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post(
                                        "/booking/confirm")
                                .content(this.objectMapper.writeValueAsString(ticketDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))

                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Creator: HaiNT
     * ticketDTO.accountId does not exist
     * Goal: HttpStatus = 400
     * date create: 1/3/2024
     */

    @Test
    public void returnInformationTicketBooking_accountId_98() throws Exception {

        TicketDTO ticketDTO = new TicketDTO();
        List<Integer> seatList = new ArrayList<>();
        seatList.add(1);
        seatList.add(2);
        seatList.add(3);
        ticketDTO.setIdMovie(1L);
        ticketDTO.setAccountId(2L);
        ticketDTO.setScheduleId(1L);
        ticketDTO.setSeatList(seatList);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post(
                                        "/booking/confirm")
                                .content(this.objectMapper.writeValueAsString(ticketDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))

                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}
