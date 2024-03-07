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
public class MovieRestController_edit {
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
        movieDTO.setId(1L);
        scheduleDTO.setMovie(1L);
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/movie/edit")
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
        movieDTO.setId(1L);
        scheduleDTO.setMovie(1L);
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/movie/edit")
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
        movieDTO.setId(1L);
        scheduleDTO.setMovie(1L);
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/movie/edit")
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
        movieDTO.setId(1L);
        scheduleDTO.setMovie(1L);
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/movie/edit")
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
    public void createMovie_startDate1() throws Exception {
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
        movieDTO.setId(1L);
        scheduleDTO.setMovie(1L);
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/movie/edit")
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
    public void createMovie_actor1() throws Exception {
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
        movieDTO.setId(1L);
        scheduleDTO.setMovie(1L);
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/movie/edit")
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
    public void createMovie_actor2() throws Exception {
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
        movieDTO.setId(1L);
        scheduleDTO.setMovie(1L);
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/movie/edit")
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
    public void createMovie_actor3() throws Exception {
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
        movieDTO.setId(1L);
        scheduleDTO.setMovie(1L);
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/movie/edit")
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
    public void createMovie_actor4() throws Exception {
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
        movieDTO.setId(1L);
        scheduleDTO.setMovie(1L);
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/movie/edit")
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
    public void createMovie_director1() throws Exception {
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
        movieDTO.setId(1L);
        scheduleDTO.setMovie(1L);
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/movie/edit")
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
    public void createMovie_director2() throws Exception {
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
        movieDTO.setId(1L);
        scheduleDTO.setMovie(1L);
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/movie/edit")
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
    public void createMovie_director3() throws Exception {
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
        movieDTO.setId(1L);
        scheduleDTO.setMovie(1L);
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/movie/edit")
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
    public void createMovie_director4() throws Exception {
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
        movieDTO.setId(1L);
        scheduleDTO.setMovie(1L);
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/movie/edit")
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
    public void createMovie_publisher1() throws Exception {
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
        movieDTO.setId(1L);
        scheduleDTO.setMovie(1L);
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/movie/edit")
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
    public void createMovie_publisher2() throws Exception {
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
        movieDTO.setId(1L);
        scheduleDTO.setMovie(1L);
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/movie/edit")
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
    public void createMovie_publisher3() throws Exception {
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
        movieDTO.setId(1L);
        scheduleDTO.setMovie(1L);
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/movie/edit")
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
    public void createMovie_publisher4() throws Exception {
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
        movieDTO.setId(1L);
        scheduleDTO.setMovie(1L);
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/movie/edit")
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
    public void createMovie_duration1() throws Exception {
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
        movieDTO.setId(1L);
        scheduleDTO.setMovie(1L);
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/movie/edit")
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
    public void createMovie_duration2() throws Exception {
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
        movieDTO.setId(1L);
        scheduleDTO.setMovie(1L);
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/movie/edit")
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
    public void createMovie_trailer1() throws Exception {
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
        movieDTO.setId(1L);
        scheduleDTO.setMovie(1L);
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/movie/edit")
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
    public void createMovie_trailer2() throws Exception {
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
        movieDTO.setId(1L);
        scheduleDTO.setMovie(1L);
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/movie/edit")
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
    public void createMovie_country1() throws Exception {
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
        movieDTO.setId(1L);
        scheduleDTO.setMovie(1L);
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/movie/edit")
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
    public void createMovie_country2() throws Exception {
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
        movieDTO.setId(1L);
        scheduleDTO.setMovie(1L);
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/movie/edit")
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
    public void createMovie_country3() throws Exception {
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
        movieDTO.setId(1L);
        scheduleDTO.setMovie(1L);
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/movie/edit")
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
    public void createMovie_country4() throws Exception {
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
        movieDTO.setId(1L);
        scheduleDTO.setMovie(1L);
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/movie/edit")
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
    public void createMovie_poster1() throws Exception {
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
        movieDTO.setId(1L);
        scheduleDTO.setMovie(1L);
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/movie/edit")
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
    public void createMovie_poster2() throws Exception {
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
        movieDTO.setId(1L);
        scheduleDTO.setMovie(1L);
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/movie/edit")
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
    public void createMovie_schedule_date1() throws Exception {
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
        movieDTO.setId(1L);
        scheduleDTO.setMovie(1L);
        scheduleDTO.setScheduleTime(1L);
//        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/movie/edit")
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
    public void createMovie_schedule_time1() throws Exception {
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
        movieDTO.setId(1L);
        scheduleDTO.setMovie(1L);
//        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/movie/edit")
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
    public void createMovie_schedule_hall1() throws Exception {
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
        movieDTO.setId(1L);
        scheduleDTO.setMovie(1L);
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
//        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/movie/edit")
                        .content(this.objectMapper.writeValueAsString(movieRequestBodyDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: LamNT
     * Created date: 04/03/2024
     * Test movie's id not found
     */
    @Test
    public void createMovie_id1() throws Exception {
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
        movieDTO.setId(9999L);
        scheduleDTO.setMovie(1L);
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/movie/edit")
                        .content(this.objectMapper.writeValueAsString(movieRequestBodyDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Created by: LamNT
     * Created date: 04/03/2024
     * Test schedule's movie id not found
     */
    @Test
    public void createMovie_schedule_movie_id1() throws Exception {
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
        movieDTO.setId(1L);
        scheduleDTO.setMovie(99999L);
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/movie/edit")
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
    public void createMovie_succeed() throws Exception {
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
        movieDTO.setId(1L);
        scheduleDTO.setMovie(1L);
        scheduleDTO.setScheduleTime(1L);
        scheduleDTO.setDate(LocalDate.parse("2024-03-08"));
        scheduleDTO.setHall(1L);
        Set<ScheduleDTO> scheduleDTOSet = new HashSet<>();
        scheduleDTOSet.add(scheduleDTO);
        MovieRequestBodyDTO movieRequestBodyDTO = new MovieRequestBodyDTO(movieDTO, scheduleDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/movie/edit")
                        .content(this.objectMapper.writeValueAsString(movieRequestBodyDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
