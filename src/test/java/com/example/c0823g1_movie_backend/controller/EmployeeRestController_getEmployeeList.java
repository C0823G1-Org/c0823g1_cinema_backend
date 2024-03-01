/**
 * Created date: 01/03/2024
 * @author: HungVXK
 * @version: 1.0
 * This class contains tests for the EmployeeRestController's getEmployeeList method.
 * These tests verify the functionality of retrieving a list of employees.
 */
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
public class EmployeeRestController_getEmployeeList {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Test to verify successful retrieval of employee list without pagination.
     * @throws Exception if an error occurs while performing the test
     */
    @Test
    public void getEmployeeList_5() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/list"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Test to verify successful retrieval of paginated employee list.
     * @throws Exception if an error occurs while performing the test
     */
    @Test
    public void getEmployeeList_6() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/list?page=0&size=5"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(9))
                .andExpect(jsonPath("content[0].memberCode").value("NV000001"))
                .andExpect(jsonPath("content[0].fullName").value("Phạm Thanh Hữu"))
                .andExpect(jsonPath("content[0].idNumber").value("123123123123"))
                .andExpect(jsonPath("content[0].email").value("phamthanhhuu@gmail.com"))
                .andExpect(jsonPath("content[0].phoneNumber").value("0123123123"))
                .andExpect(jsonPath("content[0].address").value("Ho Chi Minh"))
                .andExpect(jsonPath("content[4].memberCode").value("NV000005"))
                .andExpect(jsonPath("content[4].fullName").value("Hoàng Trần Văn Hiếu"))
                .andExpect(jsonPath("content[4].idNumber").value("111111111111"))
                .andExpect(jsonPath("content[4].email").value("hoangtranvanhieu@gmail.com"))
                .andExpect(jsonPath("content[4].phoneNumber").value("0987654321"))
                .andExpect(jsonPath("content[4].address").value("Hue"));
    }

    /**
     * Test to verify successful retrieval of paginated employee list with name search.
     * @throws Exception if an error occurs while performing the test
     */
    @Test
    public void getEmployeeList_nameSearch_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/list?page=0&size=5"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(9))
                .andExpect(jsonPath("content[0].memberCode").value("NV000001"))
                .andExpect(jsonPath("content[0].fullName").value("Phạm Thanh Hữu"))
                .andExpect(jsonPath("content[0].idNumber").value("123123123123"))
                .andExpect(jsonPath("content[0].email").value("phamthanhhuu@gmail.com"))
                .andExpect(jsonPath("content[0].phoneNumber").value("0123123123"))
                .andExpect(jsonPath("content[0].address").value("Ho Chi Minh"))
                .andExpect(jsonPath("content[4].memberCode").value("NV000005"))
                .andExpect(jsonPath("content[4].fullName").value("Hoàng Trần Văn Hiếu"))
                .andExpect(jsonPath("content[4].idNumber").value("111111111111"))
                .andExpect(jsonPath("content[4].email").value("hoangtranvanhieu@gmail.com"))
                .andExpect(jsonPath("content[4].phoneNumber").value("0987654321"))
                .andExpect(jsonPath("content[4].address").value("Hue"));
    }

    /**
     * Test to verify successful retrieval of paginated employee list with name search (empty name parameter).
     * @throws Exception if an error occurs while performing the test
     */
    @Test
    public void getEmployeeList_nameSearch_8() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/list?page=0&size=5&name="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(9))
                .andExpect(jsonPath("content[0].memberCode").value("NV000001"))
                .andExpect(jsonPath("content[0].fullName").value("Phạm Thanh Hữu"))
                .andExpect(jsonPath("content[0].idNumber").value("123123123123"))
                .andExpect(jsonPath("content[0].email").value("phamthanhhuu@gmail.com"))
                .andExpect(jsonPath("content[0].phoneNumber").value("0123123123"))
                .andExpect(jsonPath("content[0].address").value("Ho Chi Minh"))
                .andExpect(jsonPath("content[4].memberCode").value("NV000005"))
                .andExpect(jsonPath("content[4].fullName").value("Hoàng Trần Văn Hiếu"))
                .andExpect(jsonPath("content[4].idNumber").value("111111111111"))
                .andExpect(jsonPath("content[4].email").value("hoangtranvanhieu@gmail.com"))
                .andExpect(jsonPath("content[4].phoneNumber").value("0987654321"))
                .andExpect(jsonPath("content[4].address").value("Hue"));
    }

    /**
     * Test to verify client error response when providing an invalid search query.
     * @throws Exception if an error occurs while performing the test
     */
    @Test
    public void getListProducts_nameSearch_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/list?page=0&size=5&name=z"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Test to verify successful retrieval of employee list with specific name search.
     * @throws Exception if an error occurs while performing the test
     */
    @Test
    public void getListProducts_nameSearch_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/list?page=0&size=5&name=Phạm Thanh Hữu"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
