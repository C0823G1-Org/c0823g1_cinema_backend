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
     * This method is used to test for function findAllMovie with list size = 0
     *
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
     * This method is used to test for function findAllMovie with list size > 0
     *
     * @return HTTPStatus.OK
     */
    @Test
    public void fillAllMovie_6() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/movie/list?page=0&size=6"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(12))
                .andExpect(jsonPath("content[0].name").value("Interstellar"))
                .andExpect(jsonPath("content[0].publisher").value("Paramount Pictures"))
                .andExpect(jsonPath("content[0].startDate").value("2014-11-06"))
                .andExpect(jsonPath("content[0].duration").value(169))
                .andExpect(jsonPath("content[5].name").value("Avatar"))
                .andExpect(jsonPath("content[5].publisher").value("20th Century Fox"))
                .andExpect(jsonPath("content[5].startDate").value("2009-12-18"))
                .andExpect(jsonPath("content[5].duration").value(162));
    }

    /**
     * This method is used to test for function findAllMovie
     * with parameter name , publisher, startDate, endDate is null
     *
     * @return HTTPStatus.OK
     */
    @Test
    public void fillAllMovie_29() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/movie/list?page=0&size=6"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(12))
                .andExpect(jsonPath("content[0].name").value("Interstellar"))
                .andExpect(jsonPath("content[0].publisher").value("Paramount Pictures"))
                .andExpect(jsonPath("content[0].startDate").value("2014-11-06"))
                .andExpect(jsonPath("content[0].duration").value(169))
                .andExpect(jsonPath("content[5].name").value("Avatar"))
                .andExpect(jsonPath("content[5].publisher").value("20th Century Fox"))
                .andExpect(jsonPath("content[5].startDate").value("2009-12-18"))
                .andExpect(jsonPath("content[5].duration").value(162));
    }

    /**
     * This method is used to test for function findAllMovie
     * name and publisher use only a input
     * with parameter name is null, publisher = null, startDate="", endDate =""
     *
     * @return HTTPStatus.OK
     */
    @Test
    public void fillAllMovie_30() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/movie/list?page=0&size=6&startDate=&endDate="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(12))
                .andExpect(jsonPath("content[0].name").value("Interstellar"))
                .andExpect(jsonPath("content[0].publisher").value("Paramount Pictures"))
                .andExpect(jsonPath("content[0].startDate").value("2014-11-06"))
                .andExpect(jsonPath("content[0].duration").value(169))
                .andExpect(jsonPath("content[5].name").value("Avatar"))
                .andExpect(jsonPath("content[5].publisher").value("20th Century Fox"))
                .andExpect(jsonPath("content[5].startDate").value("2009-12-18"))
                .andExpect(jsonPath("content[5].duration").value(162));
    }

    /**
     * This method is used to test for function findAllMovie
     * name and publisher use only a input
     * with parameter name ="", publisher = "", startDate is null, endDate =""
     *
     * @return HTTPStatus.OK
     */
    @Test
    public void fillAllMovie_31() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/movie/list?page=0&size=6&name=&publisher=&endDate="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(12))
                .andExpect(jsonPath("content[0].name").value("Interstellar"))
                .andExpect(jsonPath("content[0].publisher").value("Paramount Pictures"))
                .andExpect(jsonPath("content[0].startDate").value("2014-11-06"))
                .andExpect(jsonPath("content[0].duration").value(169))
                .andExpect(jsonPath("content[5].name").value("Avatar"))
                .andExpect(jsonPath("content[5].publisher").value("20th Century Fox"))
                .andExpect(jsonPath("content[5].startDate").value("2009-12-18"))
                .andExpect(jsonPath("content[5].duration").value(162));
    }

    /**
     * This method is used to test for function findAllMovie
     * name and publisher use only a input
     * with parameter name ="", publisher = "", startDate ="", endDate is null
     *
     * @return HTTPStatus.OK
     */
    @Test
    public void fillAllMovie_32() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/movie/list?page=0&size=6&name=&publisher=&startDate="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(12))
                .andExpect(jsonPath("content[0].name").value("Interstellar"))
                .andExpect(jsonPath("content[0].publisher").value("Paramount Pictures"))
                .andExpect(jsonPath("content[0].startDate").value("2014-11-06"))
                .andExpect(jsonPath("content[0].duration").value(169))
                .andExpect(jsonPath("content[5].name").value("Avatar"))
                .andExpect(jsonPath("content[5].publisher").value("20th Century Fox"))
                .andExpect(jsonPath("content[5].startDate").value("2009-12-18"))
                .andExpect(jsonPath("content[5].duration").value(162));
    }

    /**
     * This method is used to test for function findAllMovie
     * name and publisher use only a input
     * with parameter name is null, publisher is null, startDate ="2014-11-06", endDate is null
     *
     * @return HTTPStatus.OK
     */
    @Test
    public void fillAllMovie_33() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/movie/list?page=0&size=6&startDate=2014-11-06"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(2))
                .andExpect(jsonPath("content[0].name").value("Interstellar"))
                .andExpect(jsonPath("content[0].publisher").value("Paramount Pictures"))
                .andExpect(jsonPath("content[0].startDate").value("2014-11-06"))
                .andExpect(jsonPath("content[0].duration").value(169))
                .andExpect(jsonPath("content[1].name").value("Interstellara"))
                .andExpect(jsonPath("content[1].publisher").value("Paramount Pictures"))
                .andExpect(jsonPath("content[1].startDate").value("2014-11-06"))
                .andExpect(jsonPath("content[1].duration").value(169));
    }

    /**
     * This method is used to test for function findAllMovie
     * name and publisher use only a input
     * with parameter name is null, publisher is null, startDate ="2014-11-06", endDate =""
     *
     * @return HTTPStatus.OK
     */
    @Test
    public void fillAllMovie_34() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/movie/list?page=0&size=6&startDate=2014-11-06&endDate="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(2))
                .andExpect(jsonPath("content[0].name").value("Interstellar"))
                .andExpect(jsonPath("content[0].publisher").value("Paramount Pictures"))
                .andExpect(jsonPath("content[0].startDate").value("2014-11-06"))
                .andExpect(jsonPath("content[0].duration").value(169))
                .andExpect(jsonPath("content[1].name").value("Interstellara"))
                .andExpect(jsonPath("content[1].publisher").value("Paramount Pictures"))
                .andExpect(jsonPath("content[1].startDate").value("2014-11-06"))
                .andExpect(jsonPath("content[1].duration").value(169));
    }

    /**
     * This method is used to test for function findAllMovie
     * name and publisher use only a input
     * with parameter name is null, publisher is null, startDate is null, endDate ="2014-11-06"
     *
     * @return HTTPStatus.OK
     */
    @Test
    public void fillAllMovie_35() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/movie/list?page=0&size=6&endDate=2014-11-06"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(12))
                .andExpect(jsonPath("content[0].name").value("Interstellar"))
                .andExpect(jsonPath("content[0].publisher").value("Paramount Pictures"))
                .andExpect(jsonPath("content[0].startDate").value("2014-11-06"))
                .andExpect(jsonPath("content[0].duration").value(169))
                .andExpect(jsonPath("content[5].name").value("Avatar"))
                .andExpect(jsonPath("content[5].publisher").value("20th Century Fox"))
                .andExpect(jsonPath("content[5].startDate").value("2009-12-18"))
                .andExpect(jsonPath("content[5].duration").value(162));
    }

    /**
     * This method is used to test for function findAllMovie
     * name and publisher use only a input
     * with parameter name is null, publisher is null, startDate = "2008-07-18", endDate ="2014-11-06"
     *
     * @return HTTPStatus.OK
     */
    @Test
    public void fillAllMovie_36() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/movie/list?page=0&size=6&startDate=2008-07-18&endDate=2014-11-06"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(8))
                .andExpect(jsonPath("content[0].name").value("Interstellar"))
                .andExpect(jsonPath("content[0].publisher").value("Paramount Pictures"))
                .andExpect(jsonPath("content[0].startDate").value("2014-11-06"))
                .andExpect(jsonPath("content[0].duration").value(169))
                .andExpect(jsonPath("content[5].name").value("Avatar"))
                .andExpect(jsonPath("content[5].publisher").value("20th Century Fox"))
                .andExpect(jsonPath("content[5].startDate").value("2009-12-18"))
                .andExpect(jsonPath("content[5].duration").value(162));
    }

    /**
     * This method is used to test for function findAllMovie
     * name and publisher use only a input
     * with parameter name is null, publisher is null, startDate = "2014-11-06", endDate ="2008-07-18"
     *
     * @return HTTPStatus.NO_CONTENT
     */
    @Test
    public void fillAllMovie_37() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/movie/list?page=0&size=6&startDate=2014-11-06&endDate=2008-07-18"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * This method is used to test for function findAllMovie
     * name and publisher use only a input
     * with parameter name ="", publisher ="", startDate is null, endDate is null
     *
     * @return HTTPStatus.OK
     */
    @Test
    public void fillAllMovie_38() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/movie/list?page=0&size=6&name=&publisher="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(12))
                .andExpect(jsonPath("content[0].name").value("Interstellar"))
                .andExpect(jsonPath("content[0].publisher").value("Paramount Pictures"))
                .andExpect(jsonPath("content[0].startDate").value("2014-11-06"))
                .andExpect(jsonPath("content[0].duration").value(169))
                .andExpect(jsonPath("content[5].name").value("Avatar"))
                .andExpect(jsonPath("content[5].publisher").value("20th Century Fox"))
                .andExpect(jsonPath("content[5].startDate").value("2009-12-18"))
                .andExpect(jsonPath("content[5].duration").value(162));
    }

    /**
     * This method is used to test for function findAllMovie
     * name and publisher use only a input
     * with parameter name = "" , publisher ="", startDate ="", endDate =""
     *
     * @return HTTPStatus.OK
     */
    @Test
    public void fillAllMovie_39() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/movie/list?page=0&size=6&name=&publisher=&startDate=&endDate="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(12))
                .andExpect(jsonPath("content[0].name").value("Interstellar"))
                .andExpect(jsonPath("content[0].publisher").value("Paramount Pictures"))
                .andExpect(jsonPath("content[0].startDate").value("2014-11-06"))
                .andExpect(jsonPath("content[0].duration").value(169))
                .andExpect(jsonPath("content[5].name").value("Avatar"))
                .andExpect(jsonPath("content[5].publisher").value("20th Century Fox"))
                .andExpect(jsonPath("content[5].startDate").value("2009-12-18"))
                .andExpect(jsonPath("content[5].duration").value(162));
    }

    /**
     * This method is used to test for function findAllMovie
     * name and publisher use only a input
     * with parameter name = "h" , publisher ="h", startDate ="", endDate =""
     *
     * @return HTTPStatus.OK
     */
    @Test
    public void fillAllMovie_40() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/movie/list?page=0&size=6&name=h&publisher=h&startDate=&endDate="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(6))
                .andExpect(jsonPath("content[0].name").value("Avatar"))
                .andExpect(jsonPath("content[0].publisher").value("20th Century Fox"))
                .andExpect(jsonPath("content[0].startDate").value("2009-12-18"))
                .andExpect(jsonPath("content[0].duration").value(162))
                .andExpect(jsonPath("content[5].name").value("The Shawshank Redemption"))
                .andExpect(jsonPath("content[5].publisher").value("Warner Bros."))
                .andExpect(jsonPath("content[5].startDate").value("1994-10-14"))
                .andExpect(jsonPath("content[5].duration").value(142));
    }

    /**
     * This method is used to test for function findAllMovie
     * name and publisher use only a input
     * with parameter name = "h" , publisher ="h", startDate is null, endDate is null
     *
     * @return HTTPStatus.OK
     */
    @Test
    public void fillAllMovie_41() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/movie/list?page=0&size=6&name=h&publisher=h"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(6))
                .andExpect(jsonPath("content[0].name").value("Avatar"))
                .andExpect(jsonPath("content[0].publisher").value("20th Century Fox"))
                .andExpect(jsonPath("content[0].startDate").value("2009-12-18"))
                .andExpect(jsonPath("content[0].duration").value(162))
                .andExpect(jsonPath("content[5].name").value("The Shawshank Redemption"))
                .andExpect(jsonPath("content[5].publisher").value("Warner Bros."))
                .andExpect(jsonPath("content[5].startDate").value("1994-10-14"))
                .andExpect(jsonPath("content[5].duration").value(142));
    }

    /**
     * This method is used to test for function findAllMovie
     * name and publisher use only a input
     * with parameter name = "Thuận" , publisher ="Thuận", startDate is null, endDate is null
     *
     * @return HTTPStatus.NO_CONTENT
     */
    @Test
    public void fillAllMovie_42() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/movie/list?page=0&size=6&name=Thuận&publisher=Thuận"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * This method is used to test for function findAllMovie
     * name and publisher use only a input
     * with parameter name = "Thuận" , publisher ="Thuận", startDate ="", endDate =""
     *
     * @return HTTPStatus.NO_CONTENT
     */
    @Test
    public void fillAllMovie_43() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/movie/list?page=0&size=6&name=Thuận&publisher=Thuận&startDate=&endDate="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * This method is used to test for function findAllMovie
     * name and publisher use only a input
     * with parameter name = "Thuận" , publisher ="Thuận", startDate ="2008-07-18", endDate ="2014-11-06"
     *
     * @return HTTPStatus.NO_CONTENT
     */
    @Test
    public void fillAllMovie_44() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/movie/list?page=0&size=6&name=Thuận&publisher=Thuận&startDate=2008-07-18&endDate=2014-11-06"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * This method is used to test for function findAllMovie
     * name and publisher use only a input
     * with parameter name = "Thuận" , publisher ="Thuận", startDate ="2014-11-06", endDate ="2008-07-18"
     *
     * @return HTTPStatus.NO_CONTENT
     */
    @Test
    public void fillAllMovie_45() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/movie/list?page=0&size=6&name=Thuận&publisher=Thuận&startDate=2014-11-06&endDate=2008-07-18"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * This method is used to test for function findAllMovie
     * name and publisher use only a input
     * with parameter name = "h" , publisher ="h", startDate ="2014-11-06", endDate ="2008-07-18"
     *
     * @return HTTPStatus.NO_CONTENT
     */
    @Test
    public void fillAllMovie_46() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/movie/list?page=0&size=6&name=h&publisher=h&startDate=2014-11-06&endDate=2008-07-18"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * This method is used to test for function findAllMovie
     * name and publisher use only a input
     * with parameter name = "h" , publisher ="h", startDate ="2008-07-18", endDate ="2014-11-06"
     *
     * @return HTTPStatus.OK
     */
    @Test
    public void fillAllMovie_47() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/movie/list?page=0&size=6&name=h&publisher=h&startDate=2008-07-18&endDate=2014-11-06"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(4))
                .andExpect(jsonPath("content[0].name").value("Avatar"))
                .andExpect(jsonPath("content[0].publisher").value("20th Century Fox"))
                .andExpect(jsonPath("content[0].startDate").value("2009-12-18"))
                .andExpect(jsonPath("content[0].duration").value(162))
                .andExpect(jsonPath("content[3].name").value("The Dark Knight"))
                .andExpect(jsonPath("content[3].publisher").value("Warner Bros."))
                .andExpect(jsonPath("content[3].startDate").value("2008-07-18"))
                .andExpect(jsonPath("content[3].duration").value(152));
    }

    /**
     * This method is used to test for function findAllMovie
     * name and publisher use only a input
     * with parameter name = "" , publisher ="", startDate ="2014-11-06", endDate is null
     *
     * @return HTTPStatus.OK
     */
    @Test
    public void fillAllMovie_48() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/movie/list?page=0&size=6&name=&publisher=&startDate=2014-11-06"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(2))
                .andExpect(jsonPath("content[0].name").value("Interstellar"))
                .andExpect(jsonPath("content[0].publisher").value("Paramount Pictures"))
                .andExpect(jsonPath("content[0].startDate").value("2014-11-06"))
                .andExpect(jsonPath("content[0].duration").value(169))
                .andExpect(jsonPath("content[1].name").value("Interstellara"))
                .andExpect(jsonPath("content[1].publisher").value("Paramount Pictures"))
                .andExpect(jsonPath("content[1].startDate").value("2014-11-06"))
                .andExpect(jsonPath("content[1].duration").value(169));
    }

    /**
     * This method is used to test for function findAllMovie
     * name and publisher use only a input
     * with parameter name is null , publisher is null, startDate ="", endDate ="2014-11-06"
     *
     * @return HTTPStatus.OK
     */
    @Test
    public void fillAllMovie_49() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/movie/list?page=0&size=6&startDate=&endDate=2014-11-06"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(12))
                .andExpect(jsonPath("content[0].name").value("Interstellar"))
                .andExpect(jsonPath("content[0].publisher").value("Paramount Pictures"))
                .andExpect(jsonPath("content[0].startDate").value("2014-11-06"))
                .andExpect(jsonPath("content[0].duration").value(169))
                .andExpect(jsonPath("content[5].name").value("Avatar"))
                .andExpect(jsonPath("content[5].publisher").value("20th Century Fox"))
                .andExpect(jsonPath("content[5].startDate").value("2009-12-18"))
                .andExpect(jsonPath("content[5].duration").value(162));
    }

    /**
     * This method is used to test for function findAllMovie
     * name and publisher use only a input
     * with parameter name = "Thuận" , publisher = "Thuận", startDate ="2008-07-18", endDate =""
     *
     * @return HTTPStatus.NO_CONTENT
     */
    @Test
    public void fillAllMovie_50() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/movie/list?page=0&size=6&name=Thuận&publisher=Thuận&startDate=2008-07-18&endDate="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * This method is used to test for function findAllMovie
     * name and publisher use only a input
     * with parameter name = "Thuận" , publisher = "Thuận", startDate ="2008-07-18", endDate is null
     *
     * @return HTTPStatus.NO_CONTENT
     */
    @Test
    public void fillAllMovie_51() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/movie/list?page=0&size=6&name=Thuận&publisher=Thuận&startDate=2008-07-18"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * This method is used to test for function findAllMovie
     * name and publisher use only a input
     * with parameter name = "Thuận" , publisher = "Thuận", startDate ="", endDate =2008-07-18"
     *
     * @return HTTPStatus.NO_CONTENT
     */
    @Test
    public void fillAllMovie_52() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/movie/list?page=0&size=6&name=Thuận&publisher=Thuận&startDate=&endDate=2008-07-18"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * This method is used to test for function findAllMovie
     * name and publisher use only a input
     * with parameter name = "Thuận" , publisher = "Thuận", startDate is null, endDate ="2008-07-18"
     *
     * @return HTTPStatus.NO_CONTENT
     */
    @Test
    public void fillAllMovie_53() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/movie/list?page=0&size=6&name=Thuận&publisher=Thuận&endDate=2008-07-18"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * This method is used to test for function findAllMovie
     * name and publisher use only a input
     * with parameter name = "h" , publisher = "h", startDate ="2008-07-18", endDate =""
     *
     * @return HTTPStatus.OK
     */
    @Test
    public void fillAllMovie_54() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/movie/list?page=0&size=6&name=h&publisher=h&startDate=2008-07-18&endDate="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(4))
                .andExpect(jsonPath("content[0].name").value("Avatar"))
                .andExpect(jsonPath("content[0].publisher").value("20th Century Fox"))
                .andExpect(jsonPath("content[0].startDate").value("2009-12-18"))
                .andExpect(jsonPath("content[0].duration").value(162))
                .andExpect(jsonPath("content[3].name").value("The Dark Knight"))
                .andExpect(jsonPath("content[3].publisher").value("Warner Bros."))
                .andExpect(jsonPath("content[3].startDate").value("2008-07-18"))
                .andExpect(jsonPath("content[3].duration").value(152));
    }

    /**
     * This method is used to test for function findAllMovie
     * name and publisher use only a input
     * with parameter name = "h" , publisher = "h", startDate ="2008-07-18", endDate is null
     *
     * @return HTTPStatus.OK
     */
    @Test
    public void fillAllMovie_55() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/movie/list?page=0&size=6&name=h&publisher=h&startDate=2008-07-18"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(4))
                .andExpect(jsonPath("content[0].name").value("Avatar"))
                .andExpect(jsonPath("content[0].publisher").value("20th Century Fox"))
                .andExpect(jsonPath("content[0].startDate").value("2009-12-18"))
                .andExpect(jsonPath("content[0].duration").value(162))
                .andExpect(jsonPath("content[3].name").value("The Dark Knight"))
                .andExpect(jsonPath("content[3].publisher").value("Warner Bros."))
                .andExpect(jsonPath("content[3].startDate").value("2008-07-18"))
                .andExpect(jsonPath("content[3].duration").value(152));
    }

    /**
     * This method is used to test for function findAllMovie
     * name and publisher use only a input
     * with parameter name = "h" , publisher = "h", startDate ="", endDate ="2008-07-18"
     *
     * @return HTTPStatus.OK
     */
    @Test
    public void fillAllMovie_56() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/movie/list?page=0&size=6&name=h&publisher=h&startDate=&endDate=2008-07-18"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(4))
                .andExpect(jsonPath("content[0].name").value("The Dark Knight"))
                .andExpect(jsonPath("content[0].publisher").value("Warner Bros."))
                .andExpect(jsonPath("content[0].startDate").value("2008-07-18"))
                .andExpect(jsonPath("content[0].duration").value(152))
                .andExpect(jsonPath("content[3].name").value("The Shawshank Redemption"))
                .andExpect(jsonPath("content[3].publisher").value("Warner Bros."))
                .andExpect(jsonPath("content[3].startDate").value("1994-10-14"))
                .andExpect(jsonPath("content[3].duration").value(142));
    }

    /**
     * This method is used to test for function findAllMovie
     * name and publisher use only a input
     * with parameter name = "h" , publisher = "h", startDate is null, endDate ="2008-07-18"
     *
     * @return HTTPStatus.OK
     */
    @Test
    public void fillAllMovie_57() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/movie/list?page=0&size=6&name=h&publisher=h&endDate=2008-07-18"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(4))
                .andExpect(jsonPath("content[0].name").value("The Dark Knight"))
                .andExpect(jsonPath("content[0].publisher").value("Warner Bros."))
                .andExpect(jsonPath("content[0].startDate").value("2008-07-18"))
                .andExpect(jsonPath("content[0].duration").value(152))
                .andExpect(jsonPath("content[3].name").value("The Shawshank Redemption"))
                .andExpect(jsonPath("content[3].publisher").value("Warner Bros."))
                .andExpect(jsonPath("content[3].startDate").value("1994-10-14"))
                .andExpect(jsonPath("content[3].duration").value(142));
    }

    /**
     * This method is used to test for function findAllMovie
     * name and publisher use only a input
     * with parameter name = "h" , publisher = "h", startDate ="", endDate is null
     *
     * @return HTTPStatus.OK
     */
    @Test
    public void fillAllMovie_58() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/movie/list?page=0&size=6&name=h&publisher=h&startDate="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(6))
                .andExpect(jsonPath("content[0].name").value("Avatar"))
                .andExpect(jsonPath("content[0].publisher").value("20th Century Fox"))
                .andExpect(jsonPath("content[0].startDate").value("2009-12-18"))
                .andExpect(jsonPath("content[0].duration").value(162))
                .andExpect(jsonPath("content[5].name").value("The Shawshank Redemption"))
                .andExpect(jsonPath("content[5].publisher").value("Warner Bros."))
                .andExpect(jsonPath("content[5].startDate").value("1994-10-14"))
                .andExpect(jsonPath("content[5].duration").value(142));
    }

    /**
     * This method is used to test for function findAllMovie
     * name and publisher use only a input
     * with parameter name = "h" , publisher = "h", startDate is null, endDate =""
     *
     * @return HTTPStatus.OK
     */
    @Test
    public void fillAllMovie_59() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/movie/list?page=0&size=6&name=h&publisher=h&endDate="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(6))
                .andExpect(jsonPath("content[0].name").value("Avatar"))
                .andExpect(jsonPath("content[0].publisher").value("20th Century Fox"))
                .andExpect(jsonPath("content[0].startDate").value("2009-12-18"))
                .andExpect(jsonPath("content[0].duration").value(162))
                .andExpect(jsonPath("content[5].name").value("The Shawshank Redemption"))
                .andExpect(jsonPath("content[5].publisher").value("Warner Bros."))
                .andExpect(jsonPath("content[5].startDate").value("1994-10-14"))
                .andExpect(jsonPath("content[5].duration").value(142));
    }

    /**
     * This method is used to test for function findAllMovie
     * name and publisher use only a input
     * with parameter name = "Thuận" , publisher = "Thuận", startDate is null, endDate =""
     *
     * @return HTTPStatus.NO_CONTENT
     */
    @Test
    public void fillAllMovie_60() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/movie/list?page=0&size=6&name=Thuận&publisher=Thuận&endDate="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * This method is used to test for function findAllMovie
     * name and publisher use only a input
     * with parameter name = "Thuận" , publisher = "Thuận", startDate ="", endDate is null
     *
     * @return HTTPStatus.NO_CONTENT
     */
    @Test
    public void fillAllMovie_61() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/movie/list?page=0&size=6&name=Thuận&publisher=Thuận&startDate="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
