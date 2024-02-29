package com.example.c0823g1_movie_backend.controller;

import com.example.c0823g1_movie_backend.dto.BookingDTO;
import com.example.c0823g1_movie_backend.dto.CheckoutDTO;
import com.example.c0823g1_movie_backend.dto.TicketDTO;
import com.example.c0823g1_movie_backend.model.Movie;
import com.example.c0823g1_movie_backend.model.Schedule;
import com.example.c0823g1_movie_backend.repository.MovieRepository;
import com.example.c0823g1_movie_backend.repository.ScheduleRepository;
import com.example.c0823g1_movie_backend.repository.TicketBookingRepository;
import com.example.c0823g1_movie_backend.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/ticket/booking")
public class TicketBookingRestController {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private TicketBookingRepository ticketBookingRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;
    @Autowired
    private MovieRepository movieRepository;

    @PostMapping("/test")
    public ResponseEntity<BookingDTO> returnInformationTicketBooking(@RequestBody TicketDTO ticket) {
        Optional<Movie> movie = movieRepository.findByIdMovie(ticket.getIdMovie());
        Optional<Schedule> schedule = scheduleRepository.findById(ticket.getScheduleId());
        List<Integer> seatList = ticket.getSeatList();

        String image = movie.get().getPoster();
        String movieName = movie.get().getName();
        String screen = schedule.get().getHall().getName();
        LocalDate date = schedule.get().getDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String movieDate = date.format(formatter);
        LocalTime time = schedule.get().getScheduleTime().getScheduleTime();
        List<String> seat = new ArrayList<>();

        for (Integer s: seatList) {
            String result = "";
            String ss = s.toString();
            if (s<=10){
                result = "A" + s;
            }else if (s<=20){
                if (s==20){
                    result = "B10";
                }else {
                    result = "B" + ss.charAt(ss.length()-1);
                }

            }else if (s<=30){
                if (s==30){
                    result = "C10";
                }else {
                    result = "C" + ss.charAt(ss.length()-1);
                }
            }else if (s<=40){
                if (s==40){
                    result = "D10";
                }else {
                    result = "D" + ss.charAt(ss.length()-1);
                }
            }else if (s<=50){
                if (s==50){
                    result = "E10";
                }else {
                    result = "E" + ss.charAt(ss.length()-1);
                }
            }

            seat.add(result);
        }

        Integer price = movie.get().getTicketPrice();

        Long sum = (long) (seat.size() * price);

        String timeStart = time.toString().substring(0,5);
        System.out.println(timeStart);


        BookingDTO bookingDTO = new BookingDTO(image,movieName,screen,movieDate,timeStart,seat,price,sum);



        return new ResponseEntity<>(bookingDTO, HttpStatus.OK);
    }


    @PostMapping ("/checkout")
    public ResponseEntity<CheckoutDTO> checkout(@RequestBody CheckoutDTO checkoutDTO){
        LocalDateTime date = LocalDateTime.now();
        System.out.println("zzzzzzz");
        System.out.println(checkoutDTO);

        ticketBookingRepository.saveBooking(checkoutDTO.getAccountId(),date);
        Integer id = ticketBookingRepository.getBooking();
        System.out.println(id);
        Long scheduleId = checkoutDTO.getScheduleId();

        for (Integer seat : checkoutDTO.getSeatNumber()) {
            ticketRepository.saveTicket(seat,id,scheduleId);
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
