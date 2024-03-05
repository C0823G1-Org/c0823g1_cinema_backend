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
public class MovieRestController_searchMovies {
    @Autowired
    private MockMvc mockMvc;


    /**
     * Author: BaoLVN.
     * This method is used to test for function searchMovies with input param (name is existed)
     * @Throws Exception
     */
    @Test
    public void searchMovies_11() throws Exception {
       mockMvc.perform(MockMvcRequestBuilders.get("/movie/search?name=a&page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
               .andExpect(jsonPath("totalElements").value(6))
               .andExpect(jsonPath("content[0].description").value("b"))
               .andExpect(jsonPath("content[0].name").value("Naru"))
               .andExpect(jsonPath("content[0].poster").value("b"))
               .andExpect(jsonPath("content[3].description").value("k"))
               .andExpect(jsonPath("content[3].name").value("Dai"))
               .andExpect(jsonPath("content[3].poster").value("k"));
    }

    /**
     * Author: BaoLVN.
     * This method is used to test for function searchMovies with input param (name is not existed)
     * @Throws Exception
     */
    @Test
    public void searchMovies_9() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/movie/search?name=4&page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Author: BaoLVN.
     * This method is used to test for function searchMovies with input param (name is empty)
     * @Throws Exception
     */
    @Test
    public void searchMovies_8() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/movie/search?page=0&name="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(4))
                .andExpect(jsonPath("totalElements").value(13))
                .andExpect(jsonPath("content[0].description").value("a"))
                .andExpect(jsonPath("content[0].name").value("Son"))
                .andExpect(jsonPath("content[0].poster").value("a"));
    }

    /**
     * Author: BaoLVN.
     * This method is used to test for function searchMovies with input param (name is null)
     * @Throws Exception
     */
    @Test
    public void searchMovies_7() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/movie/search?page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
