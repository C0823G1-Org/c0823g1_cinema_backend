package com.example.c0823g1_movie_backend.controller;

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
public class MovieController_deleteMovie {
    @Autowired
    private MockMvc mockMvc;
    /**
     * Created by: ThuanTM
     * Date created: 02/03/2024
     * This method is used to test for function deleteMovie.
     * But dont delete data in the database. Only update the state of the is_delete field
     * this case with id = ""
     * @return HTTPStatus.NO_FOUND
     */
   
    @Test
    public void deleteMovieById_26() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/movie/delete/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * This method is used to test for function deleteMovie.
     * But dont delete data in the database. Only update the state of the is_delete field
     * this case with id = 100 does not exist in the database
     * @return HTTPStatus.NO_FOUND
     */
    @Test
    public void deleteMovieById_27() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch(
                                "/movie/delete/{id}", "100"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * This method is used to test for function deleteMovie.
     * But dont delete data in the database. Only update the state of the is_delete field
     * this case with id = 1  exist in the database
     * @return HTTPStatus.OK
     */
    @Test
    public void deleteMovieById_28() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch(
                                "/movie/delete/{id}", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
