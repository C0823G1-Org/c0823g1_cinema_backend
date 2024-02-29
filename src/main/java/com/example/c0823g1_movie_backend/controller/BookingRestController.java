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

    /* Create by: BaoNDT
     * Date created: 29/02/2024
     * Function: Receive account information (accountName and password) and check account information
     * @return HttpStatus.BAD_REQUEST if account not found/ access token,role user, account information and HttpStatus.OK if account information is accurate/
     * HttpStatus.INTERNAL_SERVER_ERROR if server error
     */
    @GetMapping("/")
    public ResponseEntity<Page<IBookingDTO>> listBookingTicket(@RequestParam(defaultValue = "0") int page){
        LocalDateTime time = LocalDateTime.now();
        Pageable pageable = PageRequest.of(page, 2);
        Page<IBookingDTO> listBookingTicket = iBookingService.findAllBookingTicket(pageable,time);
        return new ResponseEntity<>(listBookingTicket, HttpStatus.OK);
    }

    @GetMapping("/search/{search}")
    public ResponseEntity<Page<IBookingDTO>> searchBookingTicket(@PathVariable("search")String search,@RequestParam(defaultValue = "0") int page){
        LocalDateTime time = LocalDateTime.now();
        Pageable pageable = PageRequest.of(page, 2);
        Page<IBookingDTO>  listBookingTicket = iBookingService.searchBookingTicketWithParameterSearch(search,time,pageable);
        System.out.println(listBookingTicket.getSize() + " search");
        return new ResponseEntity<>(listBookingTicket, HttpStatus.OK);
    }

}
