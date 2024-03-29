package com.example.c0823g1_movie_backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class bookingRestControllerGetInformationBooking {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void getInformationBooking_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/booking/exportDetail/" ))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void getInformationBooking_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/booking/exportDetail/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getInformationBooking_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/booking/exportDetail/{id}", 12))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getListBooking_5() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/booking/exportDetail/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getListTicket_6() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/booking/exportDetail/{id}",1))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("[0].nameCustomer").value("van do"))
                .andExpect(jsonPath("[0].cinemaHall").value("ABC"))
                .andExpect(jsonPath("[0].ticketPrice").value(50000))
                .andExpect(jsonPath("[0].nameMovieFilm").value("Mai"))
                .andExpect(jsonPath("[0].scheduleTime").value("10:30:00"))
                .andExpect(jsonPath("[0].bookingCode").value(1))
                .andExpect(jsonPath("[0].seatNumber").value(8))
                .andExpect(jsonPath("[0].printStatus").value(true))
                .andExpect(jsonPath("[0].phoneNumber").value("0982009465"))
                .andExpect(jsonPath("[0].idNumber").value("202687453"))
                .andExpect(jsonPath("[0].dateBooking").value("2024-03-01T20:30:30"))
                .andExpect(jsonPath("[0].accountId").value(1))

                .andExpect(jsonPath("[2].nameCustomer").value("van do"))
                .andExpect(jsonPath("[2].cinemaHall").value("ABC"))
                .andExpect(jsonPath("[2].ticketPrice").value(50000))
                .andExpect(jsonPath("[2].nameMovieFilm").value("Mai"))
                .andExpect(jsonPath("[2].scheduleTime").value("10:30:00"))
                .andExpect(jsonPath("[2].bookingCode").value(1))
                .andExpect(jsonPath("[2].seatNumber").value(12))
                .andExpect(jsonPath("[2].printStatus").value(true))
                .andExpect(jsonPath("[2].phoneNumber").value("0982009465"))
                .andExpect(jsonPath("[2].idNumber").value("202687453"))
                .andExpect(jsonPath("[2].dateBooking").value("2024-03-01T20:30:30"))
                .andExpect(jsonPath("[2].accountId").value(1))
        ;
    }

    // home
    @Test
    public void homeBookingTicket_5() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/booking/list/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void homeBookingTicket_6() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/booking/list?page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[0].nameCustomer").value("van do"))
                .andExpect(jsonPath("content[0].bookingCode").value(1))
                .andExpect(jsonPath("content[0].idNumber").value("202687453"))
                .andExpect(jsonPath("content[0].phoneNumber").value("0982009465"))
                .andExpect(jsonPath("content[0].nameMovieFilm").value("Mai"))
                .andExpect(jsonPath("content[0].scheduleTime").value("10:30:00"))
                .andExpect(jsonPath("content[0].dateBooking").value("2024-03-01T20:30:30"))

                .andExpect(jsonPath("content[1].nameCustomer").value("van do"))
                .andExpect(jsonPath("content[1].bookingCode").value(2))
                .andExpect(jsonPath("content[1].idNumber").value("202687453"))
                .andExpect(jsonPath("content[1].phoneNumber").value("0982009465"))
                .andExpect(jsonPath("content[1].nameMovieFilm").value("The Flash"))
                .andExpect(jsonPath("content[1].scheduleTime").value("08:45:00"))
                .andExpect(jsonPath("content[1].dateBooking").value("2024-04-01T20:30:30"));

    }

    // search
    @Test
    public void searchBookingParameterInput_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/booking/search/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void searchBookingParameterInput_8() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/booking/search/{search}", " "))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[0].nameCustomer").value("van do"))
                .andExpect(jsonPath("content[0].bookingCode").value(1))
                .andExpect(jsonPath("content[0].idNumber").value("202687453"))
                .andExpect(jsonPath("content[0].phoneNumber").value("0982009465"))
                .andExpect(jsonPath("content[0].nameMovieFilm").value("Mai"))
                .andExpect(jsonPath("content[0].scheduleTime").value("10:30:00"))
                .andExpect(jsonPath("content[0].dateBooking").value("2024-03-01T20:30:30"))

                .andExpect(jsonPath("content[1].nameCustomer").value("van do"))
                .andExpect(jsonPath("content[1].bookingCode").value(2))
                .andExpect(jsonPath("content[1].idNumber").value("202687453"))
                .andExpect(jsonPath("content[1].phoneNumber").value("0982009465"))
                .andExpect(jsonPath("content[1].nameMovieFilm").value("The Flash"))
                .andExpect(jsonPath("content[1].scheduleTime").value("08:45:00"))
                .andExpect(jsonPath("content[1].dateBooking").value("2024-04-01T20:30:30"));
    }

//    @Test
//    public void searchBookingParameterInput_8() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/booking/search/{search}", ""))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }

    @Test
    public void searchBookingParameterInput_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/booking/search/{search}", "kakarot"))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("content[0].nameCustomer").value("van do"))
                .andExpect(jsonPath("content[0].bookingCode").value(1))
                .andExpect(jsonPath("content[0].idNumber").value("202687453"))
                .andExpect(jsonPath("content[0].phoneNumber").value("0982009465"))
                .andExpect(jsonPath("content[0].nameMovieFilm").value("Mai"))
                .andExpect(jsonPath("content[0].scheduleTime").value("10:30:00"))
                .andExpect(jsonPath("content[0].dateBooking").value("2024-03-01T20:30:30"))

                .andExpect(jsonPath("content[1].nameCustomer").value("van do"))
                .andExpect(jsonPath("content[1].bookingCode").value(2))
                .andExpect(jsonPath("content[1].idNumber").value("202687453"))
                .andExpect(jsonPath("content[1].phoneNumber").value("0982009465"))
                .andExpect(jsonPath("content[1].nameMovieFilm").value("The Flash"))
                .andExpect(jsonPath("content[1].scheduleTime").value("08:45:00"))
                .andExpect(jsonPath("content[1].dateBooking").value("2024-04-01T20:30:30"));
    }

    @Test
    public void searchBookingParameterInput_10() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/booking/search/{search}", "Tuấn Thành"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void searchBookingParameterInput_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/booking/search/{search}", "van do"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[0].nameCustomer").value("van do"))
                .andExpect(jsonPath("content[0].bookingCode").value(1))
                .andExpect(jsonPath("content[0].idNumber").value("202687453"))
                .andExpect(jsonPath("content[0].phoneNumber").value("0982009465"))
                .andExpect(jsonPath("content[0].nameMovieFilm").value("Mai"))
                .andExpect(jsonPath("content[0].scheduleTime").value("10:30:00"))
                .andExpect(jsonPath("content[0].dateBooking").value("2024-03-01T20:30:30"))

                .andExpect(jsonPath("content[1].nameCustomer").value("van do"))
                .andExpect(jsonPath("content[1].bookingCode").value(2))
                .andExpect(jsonPath("content[1].idNumber").value("202687453"))
                .andExpect(jsonPath("content[1].phoneNumber").value("0982009465"))
                .andExpect(jsonPath("content[1].nameMovieFilm").value("The Flash"))
                .andExpect(jsonPath("content[1].scheduleTime").value("08:45:00"))
                .andExpect(jsonPath("content[1].dateBooking").value("2024-04-01T20:30:30"));
    }


    // search with date and parameter search
    @Test
    public void searchBookingParameterInputAndDate_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/booking/search//"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

        @Test
    public void searchBookingParameterInputAndDate_8() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/booking/search/{search}/{date}", "",""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void searchBookingParameterInputAndDate_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/booking/search/{search}/{date}", "viet nam","2023-01-01"))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("content[0].nameCustomer").value("van do"))
                .andExpect(jsonPath("content[0].bookingCode").value(1))
                .andExpect(jsonPath("content[0].idNumber").value("202687453"))
                .andExpect(jsonPath("content[0].phoneNumber").value("0982009465"))
                .andExpect(jsonPath("content[0].nameMovieFilm").value("Mai"))
                .andExpect(jsonPath("content[0].scheduleTime").value("10:30:00"))
                .andExpect(jsonPath("content[0].dateBooking").value("2024-03-01T20:30:30"))

                .andExpect(jsonPath("content[1].nameCustomer").value("van do"))
                .andExpect(jsonPath("content[1].bookingCode").value(2))
                .andExpect(jsonPath("content[1].idNumber").value("202687453"))
                .andExpect(jsonPath("content[1].phoneNumber").value("0982009465"))
                .andExpect(jsonPath("content[1].nameMovieFilm").value("The Flash"))
                .andExpect(jsonPath("content[1].scheduleTime").value("08:45:00"))
                .andExpect(jsonPath("content[1].dateBooking").value("2024-04-01T20:30:30"));
    }
    @Test
    public void searchBookingParameterInputAndDate_10() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/booking/search/{search}/{date}", "Tuấn Thành","2023-03-03"))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("content[0].nameCustomer").value("van do"))
                .andExpect(jsonPath("content[0].bookingCode").value(1))
                .andExpect(jsonPath("content[0].idNumber").value("202687453"))
                .andExpect(jsonPath("content[0].phoneNumber").value("0982009465"))
                .andExpect(jsonPath("content[0].nameMovieFilm").value("Mai"))
                .andExpect(jsonPath("content[0].scheduleTime").value("10:30:00"))
                .andExpect(jsonPath("content[0].dateBooking").value("2024-03-01T20:30:30"))

                .andExpect(jsonPath("content[1].nameCustomer").value("van do"))
                .andExpect(jsonPath("content[1].bookingCode").value(2))
                .andExpect(jsonPath("content[1].idNumber").value("202687453"))
                .andExpect(jsonPath("content[1].phoneNumber").value("0982009465"))
                .andExpect(jsonPath("content[1].nameMovieFilm").value("The Flash"))
                .andExpect(jsonPath("content[1].scheduleTime").value("08:45:00"))
                .andExpect(jsonPath("content[1].dateBooking").value("2024-04-01T20:30:30"));
    }


    @Test
    public void searchBookingParameterInputAndDate_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/booking/search/{search}/{date}", "van do","2024-03-01"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[0].nameCustomer").value("van do"))
                .andExpect(jsonPath("content[0].bookingCode").value(1))
                .andExpect(jsonPath("content[0].idNumber").value("202687453"))
                .andExpect(jsonPath("content[0].phoneNumber").value("0982009465"))
                .andExpect(jsonPath("content[0].nameMovieFilm").value("Mai"))
                .andExpect(jsonPath("content[0].scheduleTime").value("10:30:00"))
                .andExpect(jsonPath("content[0].dateBooking").value("2024-03-01T20:30:30"))

                .andExpect(jsonPath("content[1].nameCustomer").value("van do"))
                .andExpect(jsonPath("content[1].bookingCode").value(2))
                .andExpect(jsonPath("content[1].idNumber").value("202687453"))
                .andExpect(jsonPath("content[1].phoneNumber").value("0982009465"))
                .andExpect(jsonPath("content[1].nameMovieFilm").value("The Flash"))
                .andExpect(jsonPath("content[1].scheduleTime").value("08:45:00"))
                .andExpect(jsonPath("content[1].dateBooking").value("2024-04-01T20:30:30"));
    }


    @Test
    public void searchBookingParameterDate_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/booking/searchDate/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void searchBookingParameterDate_8() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/booking/searchDate/{date}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void searchBookingParameterDate_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/booking/searchDate/{date}", "2025-05-05"))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("content[0].nameCustomer").value("van do"))
                .andExpect(jsonPath("content[0].bookingCode").value(1))
                .andExpect(jsonPath("content[0].idNumber").value("202687453"))
                .andExpect(jsonPath("content[0].phoneNumber").value("0982009465"))
                .andExpect(jsonPath("content[0].nameMovieFilm").value("Mai"))
                .andExpect(jsonPath("content[0].scheduleTime").value("10:30:00"))
                .andExpect(jsonPath("content[0].dateBooking").value("2024-03-01T20:30:30"))

                .andExpect(jsonPath("content[1].nameCustomer").value("van do"))
                .andExpect(jsonPath("content[1].bookingCode").value(2))
                .andExpect(jsonPath("content[1].idNumber").value("202687453"))
                .andExpect(jsonPath("content[1].phoneNumber").value("0982009465"))
                .andExpect(jsonPath("content[1].nameMovieFilm").value("The Flash"))
                .andExpect(jsonPath("content[1].scheduleTime").value("08:45:00"))
                .andExpect(jsonPath("content[1].dateBooking").value("2024-04-01T20:30:30"));
    }
    @Test
    public void searchBookingParameter_10() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/booking/searchDate/{date}", "2024-06-04"))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("content[0].nameCustomer").value("van do"))
                .andExpect(jsonPath("content[0].bookingCode").value(1))
                .andExpect(jsonPath("content[0].idNumber").value("202687453"))
                .andExpect(jsonPath("content[0].phoneNumber").value("0982009465"))
                .andExpect(jsonPath("content[0].nameMovieFilm").value("Mai"))
                .andExpect(jsonPath("content[0].scheduleTime").value("10:30:00"))
                .andExpect(jsonPath("content[0].dateBooking").value("2024-03-01T20:30:30"))

                .andExpect(jsonPath("content[1].nameCustomer").value("van do"))
                .andExpect(jsonPath("content[1].bookingCode").value(2))
                .andExpect(jsonPath("content[1].idNumber").value("202687453"))
                .andExpect(jsonPath("content[1].phoneNumber").value("0982009465"))
                .andExpect(jsonPath("content[1].nameMovieFilm").value("The Flash"))
                .andExpect(jsonPath("content[1].scheduleTime").value("08:45:00"))
                .andExpect(jsonPath("content[1].dateBooking").value("2024-04-01T20:30:30"));
    }

    @Test
    public void searchBookingParameterDate_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/booking/searchDate/{date}", "2024-03-01"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
