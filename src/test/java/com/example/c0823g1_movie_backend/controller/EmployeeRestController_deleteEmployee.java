/**
 * This class contains unit tests for deleting employees in the EmployeeRestController class.
 *
 * @author HungVXK
 * @version 1.0
 * @since 2024-03-01
 */
package com.example.c0823g1_movie_backend.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeRestController_deleteEmployee {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Test to delete an employee by ID = "".
     *
     * @throws Exception if there is an error performing the request
     */
    @Test
    public void deleteNonExistentEmployeeById() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/employee/delete/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Test to delete an employee by ID with an ID without in database.
     *
     * @throws Exception if there is an error performing the request
     */
    @Test
    public void deleteEmployeeByIdWithExistingId() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch(
                                "/api/employee/delete/{id}", "20"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Test to delete an employee by ID with an existing ID.
     *
     * @throws Exception if there is an error performing the request
     */
    @Test
    public void deleteEmployeeById() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch(
                                "/api/employee/delete/{id}", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
