package com.example.c0823g1_movie_backend;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class BookingRestController_historyMovie {
    @Autowired
    private MockMvc mockMvc;

    /**
     * This function checks if ID is null
     *
     * @author: TuanNM
     */

    @Test
    public void getHistoryMovie_id_7() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/booking/historyBooking/{id}/{number}",
                (Object) null,1)).andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * This function checks if ID is empty
     *
     * @author: TuanNM
     */
    @Test
    public void getHistoryMovie_id_8() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/booking/historyBooking/{id}/{number}", "",1)).andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * This function checks if ID does not exist
     *
     * @author: TuanNM
     */
    @Test
    public void getHistoryMovie_id_9() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/booking/historyBooking/{id}/{number}", 50,1)).andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * This function checks if ID exists and no data
     *
     * @author: TuanNM
     */
    @Test
    public void getHistoryMovie_id_10() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/booking/historyBooking/{id}/{number}", 1,1)).andDo(print()).andExpect(status().is2xxSuccessful());
    }

    /**
     * This function checks if ID exists and has data
     *
     * @author: TuanNM
     */
    @Test
    public void getHistoryMovie_id_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/booking/historyBooking/{id}/{number}", 2,1)).andDo(print()).andExpect(status().is2xxSuccessful());
    }
    /**
     * This function checks if ID exists and no has data because page does not exist
     *
     * @author: TuanNM
     */
    @Test
    public void getHistoryMovie_id_99() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/booking/historyBooking/{id}/{number}", 2,1000)).andDo(print()).andExpect(status().is2xxSuccessful());
    }
}
