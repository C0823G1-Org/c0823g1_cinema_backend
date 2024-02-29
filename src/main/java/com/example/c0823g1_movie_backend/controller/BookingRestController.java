package com.example.c0823g1_movie_backend.controller;

import com.example.c0823g1_movie_backend.dto.IBookingDTO;
import com.example.c0823g1_movie_backend.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/booking")
public class BookingRestController {

    @Autowired
    private IBookingService iBookingService;

    /* Create by: DoLV
     * Date created: 29/02/2024
     * Function: Displays the list and pagination of ticket bookings with a time from the current time about 1 week
     */
    @GetMapping("/")
    public ResponseEntity<Page<IBookingDTO>> listBookingTicket(@RequestParam(defaultValue = "0") int page){
        LocalDateTime time = LocalDateTime.now();
        Pageable pageable = PageRequest.of(page, 2);
        Page<IBookingDTO> listBookingTicket = iBookingService.findAllBookingTicket(pageable,time);
        return new ResponseEntity<>(listBookingTicket, HttpStatus.OK);
    }

    /* Create by: DoLV
     * Date created: 29/02/2024
     * Function: Displays list and pagination of ticket booking with search action
     */
    @GetMapping("/search/{search}")
    public ResponseEntity<Page<IBookingDTO>> searchBookingTicket(@PathVariable("search")String search,@RequestParam(defaultValue = "0") int page){
        LocalDateTime time = LocalDateTime.now();
        Pageable pageable = PageRequest.of(page, 2);
        Page<IBookingDTO>  listBookingTicket = iBookingService.searchBookingTicketWithParameterSearch(search,time,pageable);
        if (listBookingTicket.isEmpty()){
            Page<IBookingDTO> listBookingTicketNotFound = iBookingService.findAllBookingTicket(pageable,time);
            return new ResponseEntity<>(listBookingTicketNotFound, HttpStatus.NOT_FOUND);
        }
        System.out.println(listBookingTicket.getSize() + " search");
        return new ResponseEntity<>(listBookingTicket, HttpStatus.OK);
    }

    @GetMapping("/export/{idBookingTicket}")
    public ResponseEntity<IBookingDTO> bookingTicketDetail(@PathVariable("idBookingTicket") Integer id){
        IBookingDTO iBookingDTO = iBookingService.findBookingTicketById(id);
        if (iBookingDTO == null){
            return  new ResponseEntity<>( HttpStatus.NOT_FOUND);
        } else {
            if (iBookingDTO.getPrintStatus()){
                return  new ResponseEntity<>( HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(iBookingDTO, HttpStatus.OK);
            }


        }

    }

}
