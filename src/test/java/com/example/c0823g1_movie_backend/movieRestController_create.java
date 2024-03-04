package com.example.c0823g1_movie_backend;

import com.example.c0823g1_movie_backend.dto.MovieDTO;
import com.example.c0823g1_movie_backend.dto.MovieRequestBodyDTO;
import com.example.c0823g1_movie_backend.dto.ScheduleDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc

public class movieRestController_create {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    /**
     * Created by: LamNT
     * Created date: 01/03/2024
     * Test field name validation with null value
     */
    @Test
    public void createMovie_name1() throws Exception {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setActor("Christian Bale, Heath Ledger");
        movieDTO.setCountry("USA");
        movieDTO.setDuration(120);
        movieDTO.setDirector("Christopher Nolan");
        movieDTO.setPoster("[Poster link]");
        movieDTO.setPublisher("Warner Bros.");
        movieDTO.setStartDate(LocalDate.of(2024, 3, 9));
        movieDTO.setTrailer("[Trailer link]");
        movieDTO.setTicketPrice(150000);
        movieDTO.setDescription("When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.");
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/create")
                        .content(this.objectMapper.writeValueAsString(movieRequestBodyDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Created by: LamNT
     * Created date: 01/03/2024
     * Test field name validation with blank value
     */
    @Test
    public void createMovie_name2() throws Exception {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setName("");
        movieDTO.setActor("Christian Bale, Heath Ledger");
        movieDTO.setCountry("USA");
        movieDTO.setDuration(120);
        movieDTO.setDirector("Christopher Nolan");
        movieDTO.setPoster("[Poster link]");
        movieDTO.setPublisher("Warner Bros.");
        movieDTO.setStartDate(LocalDate.of(2024, 3, 9));
        movieDTO.setTrailer("[Trailer link]");
        movieDTO.setTicketPrice(150000);
        movieDTO.setDescription("When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.");
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/create")
                        .content(this.objectMapper.writeValueAsString(movieRequestBodyDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: LamNT
     * Created date: 01/03/2024
     * Test field name validation with min length
     */
    @Test
    public void createMovie_name3() throws Exception {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setName("a");
        movieDTO.setActor("Christian Bale, Heath Ledger");
        movieDTO.setCountry("USA");
        movieDTO.setDuration(120);
        movieDTO.setDirector("Christopher Nolan");
        movieDTO.setPoster("[Poster link]");
        movieDTO.setPublisher("Warner Bros.");
        movieDTO.setStartDate(LocalDate.of(2024, 3, 9));
        movieDTO.setTrailer("[Trailer link]");
        movieDTO.setTicketPrice(150000);
        movieDTO.setDescription("When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.");
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/create")
                        .content(this.objectMapper.writeValueAsString(movieRequestBodyDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: LamNT
     * Created date: 01/03/2024
     * Test field name validation with max length
     */
    @Test
    public void createMovie_name4() throws Exception {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        movieDTO.setActor("Christian Bale, Heath Ledger");
        movieDTO.setCountry("USA");
        movieDTO.setDuration(120);
        movieDTO.setDirector("Christopher Nolan");
        movieDTO.setPoster("[Poster link]");
        movieDTO.setPublisher("Warner Bros.");
        movieDTO.setStartDate(LocalDate.of(2024, 3, 9));
        movieDTO.setTrailer("[Trailer link]");
        movieDTO.setTicketPrice(150000);
        movieDTO.setDescription("When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.");
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/create")
                        .content(this.objectMapper.writeValueAsString(movieRequestBodyDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: LamNT
     * Created date: 04/03/2024
     * Test field startDate validation with null value
     */
    @Test
    public void createMovie_name5() throws Exception {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setName("The Dark Knight");
        movieDTO.setActor("Christian Bale, Heath Ledger");
        movieDTO.setCountry("USA");
        movieDTO.setDuration(120);
        movieDTO.setDirector("Christopher Nolan");
        movieDTO.setPoster("[Poster link]");
        movieDTO.setPublisher("Warner Bros.");
        movieDTO.setTrailer("[Trailer link]");
//        movieDTO.setStartDate(LocalDate.of(2024, 3, 9));
        movieDTO.setTicketPrice(150000);
        movieDTO.setDescription("When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.");
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/create")
                        .content(this.objectMapper.writeValueAsString(movieRequestBodyDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: LamNT
     * Created date: 04/03/2024
     * Test field actor validation with null value
     */
    @Test
    public void createMovie_name6() throws Exception {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setName("The Dark Knight");
//        movieDTO.setActor("Christian Bale, Heath Ledger");
        movieDTO.setCountry("USA");
        movieDTO.setDuration(120);
        movieDTO.setDirector("Christopher Nolan");
        movieDTO.setPoster("[Poster link]");
        movieDTO.setPublisher("Warner Bros.");
        movieDTO.setTrailer("[Trailer link]");
        movieDTO.setStartDate(LocalDate.of(2024, 3, 9));
        movieDTO.setTicketPrice(150000);
        movieDTO.setDescription("When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.");
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/create")
                        .content(this.objectMapper.writeValueAsString(movieRequestBodyDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: LamNT
     * Created date: 04/03/2024
     * Test field actor validation with blank value
     */
    @Test
    public void createMovie_name7() throws Exception {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setName("The Dark Knight");
        movieDTO.setActor("");
        movieDTO.setCountry("USA");
        movieDTO.setDuration(120);
        movieDTO.setDirector("Christopher Nolan");
        movieDTO.setPoster("[Poster link]");
        movieDTO.setPublisher("Warner Bros.");
        movieDTO.setTrailer("[Trailer link]");
        movieDTO.setStartDate(LocalDate.of(2024, 3, 9));
        movieDTO.setTicketPrice(150000);
        movieDTO.setDescription("When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.");
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/create")
                        .content(this.objectMapper.writeValueAsString(movieRequestBodyDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: LamNT
     * Created date: 04/03/2024
     * Test field actor validation with min value
     */
    @Test
    public void createMovie_name8() throws Exception {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setName("The Dark Knight");
        movieDTO.setActor("a");
        movieDTO.setCountry("USA");
        movieDTO.setDuration(120);
        movieDTO.setDirector("Christopher Nolan");
        movieDTO.setPoster("[Poster link]");
        movieDTO.setPublisher("Warner Bros.");
        movieDTO.setTrailer("[Trailer link]");
        movieDTO.setStartDate(LocalDate.of(2024, 3, 9));
        movieDTO.setTicketPrice(150000);
        movieDTO.setDescription("When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.");
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/create")
                        .content(this.objectMapper.writeValueAsString(movieRequestBodyDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: LamNT
     * Created date: 04/03/2024
     * Test field actor validation with max value
     */
    @Test
    public void createMovie_name9() throws Exception {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setName("The Dark Knight");
        movieDTO.setActor("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaad");
        movieDTO.setCountry("USA");
        movieDTO.setDuration(120);
        movieDTO.setDirector("Christopher Nolan");
        movieDTO.setPoster("[Poster link]");
        movieDTO.setPublisher("Warner Bros.");
        movieDTO.setTrailer("[Trailer link]");
        movieDTO.setStartDate(LocalDate.of(2024, 3, 9));
        movieDTO.setTicketPrice(150000);
        movieDTO.setDescription("When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.");
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/create")
                        .content(this.objectMapper.writeValueAsString(movieRequestBodyDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: LamNT
     * Created date: 04/03/2024
     * Test field director validation with null value
     */
    @Test
    public void createMovie_name10() throws Exception {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setName("The Dark Knight");
        movieDTO.setActor("Christian Bale, Heath Ledger");
        movieDTO.setCountry("USA");
        movieDTO.setDuration(120);
//        movieDTO.setDirector("Christopher Nolan");
        movieDTO.setPoster("[Poster link]");
        movieDTO.setPublisher("Warner Bros.");
        movieDTO.setTrailer("[Trailer link]");
        movieDTO.setStartDate(LocalDate.of(2024, 3, 9));
        movieDTO.setTicketPrice(150000);
        movieDTO.setDescription("When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.");
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/create")
                        .content(this.objectMapper.writeValueAsString(movieRequestBodyDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: LamNT
     * Created date: 04/03/2024
     * Test field director validation with blank value
     */
    @Test
    public void createMovie_name11() throws Exception {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setName("The Dark Knight");
        movieDTO.setActor("Christian Bale, Heath Ledger");
        movieDTO.setCountry("USA");
        movieDTO.setDuration(120);
        movieDTO.setDirector("");
        movieDTO.setPoster("[Poster link]");
        movieDTO.setPublisher("Warner Bros.");
        movieDTO.setTrailer("[Trailer link]");
        movieDTO.setStartDate(LocalDate.of(2024, 3, 9));
        movieDTO.setTicketPrice(150000);
        movieDTO.setDescription("When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.");
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/create")
                        .content(this.objectMapper.writeValueAsString(movieRequestBodyDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: LamNT
     * Created date: 04/03/2024
     * Test field director validation with min value
     */
    @Test
    public void createMovie_name12() throws Exception {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setName("The Dark Knight");
        movieDTO.setActor("Christian Bale, Heath Ledger");
        movieDTO.setCountry("USA");
        movieDTO.setDuration(120);
        movieDTO.setDirector("a");
        movieDTO.setPoster("[Poster link]");
        movieDTO.setPublisher("Warner Bros.");
        movieDTO.setTrailer("[Trailer link]");
        movieDTO.setStartDate(LocalDate.of(2024, 3, 9));
        movieDTO.setTicketPrice(150000);
        movieDTO.setDescription("When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.");
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/create")
                        .content(this.objectMapper.writeValueAsString(movieRequestBodyDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: LamNT
     * Created date: 04/03/2024
     * Test field director validation with max value
     */
    @Test
    public void createMovie_name13() throws Exception {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setName("The Dark Knight");
        movieDTO.setActor("Christian Bale, Heath Ledger");
        movieDTO.setCountry("USA");
        movieDTO.setDuration(120);
        movieDTO.setDirector("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean ma");
        movieDTO.setPoster("[Poster link]");
        movieDTO.setPublisher("Warner Bros.");
        movieDTO.setTrailer("[Trailer link]");
        movieDTO.setStartDate(LocalDate.of(2024, 3, 9));
        movieDTO.setTicketPrice(150000);
        movieDTO.setDescription("When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.");
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/create")
                        .content(this.objectMapper.writeValueAsString(movieRequestBodyDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: LamNT
     * Created date: 04/03/2024
     * Test field publisher validation with null value
     */
    @Test
    public void createMovie_name14() throws Exception {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setName("The Dark Knight");
        movieDTO.setActor("Christian Bale, Heath Ledger");
        movieDTO.setCountry("USA");
        movieDTO.setDuration(120);
        movieDTO.setDirector("Christopher Nolan");
        movieDTO.setPoster("[Poster link]");
//        movieDTO.setPublisher("Warner Bros.");
        movieDTO.setTrailer("[Trailer link]");
        movieDTO.setStartDate(LocalDate.of(2024, 3, 9));
        movieDTO.setTicketPrice(150000);
        movieDTO.setDescription("When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.");
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/create")
                        .content(this.objectMapper.writeValueAsString(movieRequestBodyDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: LamNT
     * Created date: 04/03/2024
     * Test field publisher validation with blank value
     */
    @Test
    public void createMovie_name15() throws Exception {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setName("The Dark Knight");
        movieDTO.setActor("Christian Bale, Heath Ledger");
        movieDTO.setCountry("USA");
        movieDTO.setDuration(120);
        movieDTO.setDirector("Christopher Nolan");
        movieDTO.setPoster("[Poster link]");
        movieDTO.setPublisher("");
        movieDTO.setTrailer("[Trailer link]");
        movieDTO.setStartDate(LocalDate.of(2024, 3, 9));
        movieDTO.setTicketPrice(150000);
        movieDTO.setDescription("When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.");
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/create")
                        .content(this.objectMapper.writeValueAsString(movieRequestBodyDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: LamNT
     * Created date: 04/03/2024
     * Test field publisher validation with min value
     */
    @Test
    public void createMovie_name16() throws Exception {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setName("The Dark Knight");
        movieDTO.setActor("Christian Bale, Heath Ledger");
        movieDTO.setCountry("USA");
        movieDTO.setDuration(120);
        movieDTO.setDirector("Christopher Nolan");
        movieDTO.setPoster("[Poster link]");
        movieDTO.setPublisher("a");
        movieDTO.setTrailer("[Trailer link]");
        movieDTO.setStartDate(LocalDate.of(2024, 3, 9));
        movieDTO.setTicketPrice(150000);
        movieDTO.setDescription("When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.");
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/create")
                        .content(this.objectMapper.writeValueAsString(movieRequestBodyDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: LamNT
     * Created date: 04/03/2024
     * Test field publisher validation with max value
     */
    @Test
    public void createMovie_name17() throws Exception {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setName("The Dark Knight");
        movieDTO.setActor("Christian Bale, Heath Ledger");
        movieDTO.setCountry("USA");
        movieDTO.setDuration(120);
        movieDTO.setDirector("Christopher Nolan");
        movieDTO.setPoster("[Poster link]");
        movieDTO.setPublisher("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        movieDTO.setTrailer("[Trailer link]");
        movieDTO.setStartDate(LocalDate.of(2024, 3, 9));
        movieDTO.setTicketPrice(150000);
        movieDTO.setDescription("When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.");
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/create")
                        .content(this.objectMapper.writeValueAsString(movieRequestBodyDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: LamNT
     * Created date: 04/03/2024
     * Test field duration validation with null value
     */
    @Test
    public void createMovie_name18() throws Exception {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setName("The Dark Knight");
        movieDTO.setActor("Christian Bale, Heath Ledger");
        movieDTO.setCountry("USA");
//        movieDTO.setDuration(120);
        movieDTO.setDirector("Christopher Nolan");
        movieDTO.setPoster("[Poster link]");
        movieDTO.setPublisher("Warner Bros.");
        movieDTO.setTrailer("[Trailer link]");
        movieDTO.setStartDate(LocalDate.of(2024, 3, 9));
        movieDTO.setTicketPrice(150000);
        movieDTO.setDescription("When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.");
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/create")
                        .content(this.objectMapper.writeValueAsString(movieRequestBodyDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: LamNT
     * Created date: 04/03/2024
     * Test field duration validation with min value
     */
    @Test
    public void createMovie_name19() throws Exception {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setName("The Dark Knight");
        movieDTO.setActor("Christian Bale, Heath Ledger");
        movieDTO.setCountry("USA");
        movieDTO.setDuration(0);
        movieDTO.setDirector("Christopher Nolan");
        movieDTO.setPoster("[Poster link]");
        movieDTO.setPublisher("Warner Bros.");
        movieDTO.setTrailer("[Trailer link]");
        movieDTO.setStartDate(LocalDate.of(2024, 3, 9));
        movieDTO.setTicketPrice(150000);
        movieDTO.setDescription("When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.");
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/create")
                        .content(this.objectMapper.writeValueAsString(movieRequestBodyDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: LamNT
     * Created date: 04/03/2024
     * Test field trailer validation with null value
     */
    @Test
    public void createMovie_name20() throws Exception {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setName("The Dark Knight");
        movieDTO.setActor("Christian Bale, Heath Ledger");
        movieDTO.setCountry("USA");
        movieDTO.setDuration(120);
        movieDTO.setDirector("Christopher Nolan");
        movieDTO.setPoster("[Poster link]");
        movieDTO.setPublisher("Warner Bros.");
//        movieDTO.setTrailer("[Trailer link]");
        movieDTO.setStartDate(LocalDate.of(2024, 3, 9));
        movieDTO.setTicketPrice(150000);
        movieDTO.setDescription("When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.");
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/create")
                        .content(this.objectMapper.writeValueAsString(movieRequestBodyDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Created by: LamNT
     * Created date: 04/03/2024
     * Test field trailer validation with blank value
     */
    @Test
    public void createMovie_name21() throws Exception {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setName("The Dark Knight");
        movieDTO.setActor("Christian Bale, Heath Ledger");
        movieDTO.setCountry("USA");
        movieDTO.setDuration(120);
        movieDTO.setDirector("Christopher Nolan");
        movieDTO.setPoster("[Poster link]");
        movieDTO.setPublisher("Warner Bros.");
        movieDTO.setTrailer("");
        movieDTO.setStartDate(LocalDate.of(2024, 3, 9));
        movieDTO.setTicketPrice(150000);
        movieDTO.setDescription("When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.");
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/create")
                        .content(this.objectMapper.writeValueAsString(movieRequestBodyDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: LamNT
     * Created date: 04/03/2024
     * Test field country validation with null value
     */
    @Test
    public void createMovie_name22() throws Exception {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setName("The Dark Knight");
        movieDTO.setActor("Christian Bale, Heath Ledger");
//        movieDTO.setCountry("USA");
        movieDTO.setDuration(120);
        movieDTO.setDirector("Christopher Nolan");
        movieDTO.setPoster("[Poster link]");
        movieDTO.setPublisher("Warner Bros.");
        movieDTO.setTrailer("[Trailer]");
        movieDTO.setStartDate(LocalDate.of(2024, 3, 9));
        movieDTO.setTicketPrice(150000);
        movieDTO.setDescription("When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.");
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/create")
                        .content(this.objectMapper.writeValueAsString(movieRequestBodyDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: LamNT
     * Created date: 04/03/2024
     * Test field country validation with blank value
     */
    @Test
    public void createMovie_name23() throws Exception {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setName("The Dark Knight");
        movieDTO.setActor("Christian Bale, Heath Ledger");
        movieDTO.setCountry("");
        movieDTO.setDuration(120);
        movieDTO.setDirector("Christopher Nolan");
        movieDTO.setPoster("[Poster link]");
        movieDTO.setPublisher("Warner Bros.");
        movieDTO.setTrailer("[Trailer]");
        movieDTO.setStartDate(LocalDate.of(2024, 3, 9));
        movieDTO.setTicketPrice(150000);
        movieDTO.setDescription("When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.");
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/create")
                        .content(this.objectMapper.writeValueAsString(movieRequestBodyDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: LamNT
     * Created date: 04/03/2024
     * Test field country validation with min value
     */
    @Test
    public void createMovie_name24() throws Exception {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setName("The Dark Knight");
        movieDTO.setActor("Christian Bale, Heath Ledger");
        movieDTO.setCountry("a");
        movieDTO.setDuration(120);
        movieDTO.setDirector("Christopher Nolan");
        movieDTO.setPoster("[Poster link]");
        movieDTO.setPublisher("Warner Bros.");
        movieDTO.setTrailer("[Trailer]");
        movieDTO.setStartDate(LocalDate.of(2024, 3, 9));
        movieDTO.setTicketPrice(150000);
        movieDTO.setDescription("When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.");
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/create")
                        .content(this.objectMapper.writeValueAsString(movieRequestBodyDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: LamNT
     * Created date: 04/03/2024
     * Test field country validation with max value
     */
    @Test
    public void createMovie_name25() throws Exception {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setName("The Dark Knight");
        movieDTO.setActor("Christian Bale, Heath Ledger");
        movieDTO.setCountry("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        movieDTO.setDuration(120);
        movieDTO.setDirector("Christopher Nolan");
        movieDTO.setPoster("[Poster link]");
        movieDTO.setPublisher("Warner Bros.");
        movieDTO.setTrailer("[Trailer]");
        movieDTO.setStartDate(LocalDate.of(2024, 3, 9));
        movieDTO.setTicketPrice(150000);
        movieDTO.setDescription("When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.");
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/create")
                        .content(this.objectMapper.writeValueAsString(movieRequestBodyDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: LamNT
     * Created date: 04/03/2024
     * Test field poster validation with null value
     */
    @Test
    public void createMovie_name26() throws Exception {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setName("The Dark Knight");
        movieDTO.setActor("Christian Bale, Heath Ledger");
        movieDTO.setCountry("USA");
        movieDTO.setDuration(120);
        movieDTO.setDirector("Christopher Nolan");
//        movieDTO.setPoster("[Poster link]");
        movieDTO.setPublisher("Warner Bros.");
        movieDTO.setTrailer("[Trailer]");
        movieDTO.setStartDate(LocalDate.of(2024, 3, 9));
        movieDTO.setTicketPrice(150000);
        movieDTO.setDescription("When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.");
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/create")
                        .content(this.objectMapper.writeValueAsString(movieRequestBodyDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: LamNT
     * Created date: 04/03/2024
     * Test field poster validation with blank value
     */
    @Test
    public void createMovie_name27() throws Exception {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setName("The Dark Knight");
        movieDTO.setActor("Christian Bale, Heath Ledger");
        movieDTO.setCountry("USA");
        movieDTO.setDuration(120);
        movieDTO.setDirector("Christopher Nolan");
        movieDTO.setPoster("");
        movieDTO.setPublisher("Warner Bros.");
        movieDTO.setTrailer("[Trailer]");
        movieDTO.setStartDate(LocalDate.of(2024, 3, 9));
        movieDTO.setTicketPrice(150000);
        movieDTO.setDescription("When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.");
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/create")
                        .content(this.objectMapper.writeValueAsString(movieRequestBodyDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: LamNT
     * Created date: 04/03/2024
     * Test schedule's field date validation with null value
     */
    @Test
    public void createMovie_name28() throws Exception {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setName("The Dark Knight");
        movieDTO.setActor("Christian Bale, Heath Ledger");
        movieDTO.setCountry("USA");
        movieDTO.setDuration(120);
        movieDTO.setDirector("Christopher Nolan");
        movieDTO.setPoster("");
        movieDTO.setPublisher("Warner Bros.");
        movieDTO.setTrailer("[Trailer]");
        movieDTO.setStartDate(LocalDate.of(2024, 3, 9));
        movieDTO.setTicketPrice(150000);
        movieDTO.setDescription("When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.");
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setScheduleTime(1L);
//        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/create")
                        .content(this.objectMapper.writeValueAsString(movieRequestBodyDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: LamNT
     * Created date: 04/03/2024
     * Test schedule's field schedule time validation with null value
     */
    @Test
    public void createMovie_name29() throws Exception {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setName("The Dark Knight");
        movieDTO.setActor("Christian Bale, Heath Ledger");
        movieDTO.setCountry("USA");
        movieDTO.setDuration(120);
        movieDTO.setDirector("Christopher Nolan");
        movieDTO.setPoster("");
        movieDTO.setPublisher("Warner Bros.");
        movieDTO.setTrailer("[Trailer]");
        movieDTO.setStartDate(LocalDate.of(2024, 3, 9));
        movieDTO.setTicketPrice(150000);
        movieDTO.setDescription("When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.");
        ScheduleDTO scheduleDTO = new ScheduleDTO();
//        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/create")
                        .content(this.objectMapper.writeValueAsString(movieRequestBodyDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: LamNT
     * Created date: 04/03/2024
     * Test schedule's field hall validation with null value
     */
    @Test
    public void createMovie_name30() throws Exception {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setName("The Dark Knight");
        movieDTO.setActor("Christian Bale, Heath Ledger");
        movieDTO.setCountry("USA");
        movieDTO.setDuration(120);
        movieDTO.setDirector("Christopher Nolan");
        movieDTO.setPoster("");
        movieDTO.setPublisher("Warner Bros.");
        movieDTO.setTrailer("[Trailer]");
        movieDTO.setStartDate(LocalDate.of(2024, 3, 9));
        movieDTO.setTicketPrice(150000);
        movieDTO.setDescription("When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.");
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
//        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/create")
                        .content(this.objectMapper.writeValueAsString(movieRequestBodyDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: LamNT
     * Created date: 01/03/2024
     * Test create movie validation with all valid value
     */
    @Test
    public void createMovie_name99() throws Exception {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setName("The Dark Knight");
        movieDTO.setActor("Christian Bale, Heath Ledger");
        movieDTO.setCountry("USA");
        movieDTO.setDuration(120);
        movieDTO.setDirector("Christopher Nolan");
        movieDTO.setPoster("[Poster link]");
        movieDTO.setPublisher("Warner Bros.");
        movieDTO.setTicketPrice(150000);
        movieDTO.setStartDate(LocalDate.of(2024, 3, 9));
        movieDTO.setTrailer("[Trailer link]");
        movieDTO.setDescription("When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.");
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/create")
                        .content(this.objectMapper.writeValueAsString(movieRequestBodyDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
