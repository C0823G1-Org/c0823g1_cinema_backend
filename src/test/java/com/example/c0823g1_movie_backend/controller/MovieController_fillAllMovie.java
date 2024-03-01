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
public class MovieController_fillAllMovie {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Created by: ThuanTM
     * Date created: 01/03/2024
     * Movie list empty
     * @return HTTPStatus.NO_CONTENT
     */
    @Test
    public void fillAllMovie_5() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/movie/list"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    /**
     * Created by: ThuanTM
     * Date created: 01/03/2024
     * Movie list have data
     * @return HTTPStatus.OK
     */
    @Test
    public void fillAllMovie_6() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/movie/list?page=2"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(12))
                .andExpect(jsonPath("content[0].name").value("The Dark Knight"))
                .andExpect(jsonPath("content[0].publisher").value("Warner Bros."))
                .andExpect(jsonPath("content[0].startDate").value("2008-07-18"))
                .andExpect(jsonPath("content[0].duration").value(152))
                .andExpect(jsonPath("content[5].name").value("Ngọc Thành"))
                .andExpect(jsonPath("content[5].publisher").value("2000-09-18"))
                .andExpect(jsonPath("content[5].startDate").value(1));
    }
}
