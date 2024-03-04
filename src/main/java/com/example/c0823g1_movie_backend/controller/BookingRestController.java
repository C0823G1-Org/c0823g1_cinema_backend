package com.example.c0823g1_movie_backend.controller;

import com.example.c0823g1_movie_backend.config.MailConfig;
import com.example.c0823g1_movie_backend.dto.*;
import com.example.c0823g1_movie_backend.model.Account;
import com.example.c0823g1_movie_backend.model.Movie;
import com.example.c0823g1_movie_backend.model.Schedule;
import com.example.c0823g1_movie_backend.model.Ticket;
import com.example.c0823g1_movie_backend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
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
@RequestMapping("/booking")
public class BookingRestController {

    @Autowired
    private IScheduleService scheduleService;

    @Autowired
    private IMovieService movieService;

    @Autowired
    private ITicketService ticketService;

    @Autowired
    private IBookingService iBookingService;

    @Autowired
    private IAccountService accountService;

    @Autowired
    private MailConfig mailConfig;

    @GetMapping("historyBooking/{id}")
    public ResponseEntity<Iterable<HistoryBookingDTO>> historyMovie(@PathVariable Long id) {
        return new ResponseEntity<>(iBookingService.historyBooking(id), HttpStatus.OK);
    }

    /*
     * Create by TuanNM
     * Date create: 29/02/2024
     * Method: Display ticket booking history
     * @Param Account ID
     * @Return A list of booking history
     */

    @GetMapping("/")
    public ResponseEntity<List<IBookingDTO>> listBookingTicket() {
        LocalDateTime time = LocalDateTime.now();
        List<IBookingDTO> listBookingTicket = iBookingService.findAllBookingTicket(time);
        return new ResponseEntity<>(listBookingTicket, HttpStatus.OK);
    }

    @GetMapping("/search/{search}")
    public ResponseEntity<List<IBookingDTO>> searchBookingTicket(@PathVariable("search") String search) {
        LocalDateTime time = LocalDateTime.now();
        List<IBookingDTO> listBookingTicket = iBookingService.searchBookingTicketWithParameterSearch(search, time);
        System.out.println(listBookingTicket.size() + " search");
        return new ResponseEntity<>(listBookingTicket, HttpStatus.OK);
    }


    @GetMapping("searchMovieBooking/{start}/{end}")
    public ResponseEntity<Iterable<HistoryBookingDTO>> searchMovieBooking(@PathVariable LocalDateTime startDate, @PathVariable LocalDateTime endDate) {
        return new ResponseEntity<>(iBookingService.searchBookingByDate(startDate, endDate), HttpStatus.OK);
    }
    /**
     * Create by TuanNM
     * Date create: 29/02/2024
     * Method: Search by start date and end date
     * @param startDate is the starting date
     * @param endDate is the end date
     * @return a search list
     */


    /*
     * Create by HaiNT
     * Date create: 29/02/2024
     * Method: Receive request from the client when clicking
     * to book a ticket and return information to the Booking Confirmation page
     * @Param ticket(idMovie,scheduleId,seatList)
     * @Return object bookingDTO(image,movieName,screen,movieDate,timeStart,seat,price,sum)
     */
    @PostMapping("/confirm")
    public ResponseEntity<BookingDTO> returnInformationTicketBooking(@RequestBody TicketDTO ticket) {
        if (ticket == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            if (ticket.getIdMovie() == null || ticket.getAccountId() == null || ticket.getScheduleId() == null || ticket.getSeatList().isEmpty()){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }else {
                Movie movie = movieService.findMovieById(ticket.getIdMovie());
                Optional<Schedule> schedule = scheduleService.getScheduleById(ticket.getScheduleId());
                Account account = accountService.findAccountById(ticket.getAccountId());

                if (movie == null || schedule.isEmpty()|| account == null){
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                }
                List<Integer> seatList = ticket.getSeatList();
                String image = movie.getPoster();
                String movieName = movie.getName();
                String screen = schedule.get().getHall().getName();
                LocalDate date = schedule.get().getDate();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String movieDate = date.format(formatter);
                LocalTime time = schedule.get().getScheduleTime().getScheduleTime();
                List<String> seat = new ArrayList<>();

                for (Integer s: seatList) {
                    if (s>schedule.get().getHall().getTotalSeat() || s<0){
                        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                    }
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

                Integer price = movie.getTicketPrice();

                Long sum = ((long) seatList.size() * price);

                String timeStart = time.toString().substring(0,5);
                System.out.println(timeStart);

                String email = account.getEmail();

                Long accountId = ticket.getAccountId();
                Long scheduleId = ticket.getScheduleId();
                List<Integer> seatNumber = ticket.getSeatList();


                BookingDTO bookingDTO = new BookingDTO(image,movieName,screen,movieDate,timeStart,seat,price,sum,email,accountId,scheduleId,seatNumber);



                return new ResponseEntity<>(bookingDTO, HttpStatus.OK);
            }

        }

    }


    /*
     * Create by HaiNT
     * Date create: 29/02/2024
     * Method: Receive request from the client when checkout successfully
     * @RequestBody checkoutDTO(accountId,scheduleId,seatList)
     * @Return status
     */
    @PostMapping ("/checkout")
    public ResponseEntity<CheckoutDTO> checkout(@RequestBody CheckoutDTO checkoutDTO){
        LocalDateTime date = LocalDateTime.now();
        if (checkoutDTO == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (checkoutDTO.getScheduleId() == null || checkoutDTO.getAccountId() == null || checkoutDTO.getSeatNumber() == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Optional<Schedule> schedule = scheduleService.getScheduleById(checkoutDTO.getScheduleId());
        Account account = accountService.findAccountById(checkoutDTO.getAccountId());
        if (schedule.isEmpty() || account == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        iBookingService.saveBooking(checkoutDTO.getAccountId(),date);
        Integer id = iBookingService.getBooking();
        Long scheduleId = checkoutDTO.getScheduleId();
        List<Ticket> checkExist;
        for (Integer seat : checkoutDTO.getSeatNumber()) {
            checkExist = ticketService.checkExist(seat,scheduleId);
            if (checkExist.isEmpty()){
                ticketService.saveTicket(seat,id,scheduleId);
            }else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        System.out.println("abc");
        if (checkoutDTO.getTotalAmount() <= 0 || checkoutDTO.getTotalAmount() == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        int accumulatedPoints =(int) Math.floor((checkoutDTO.getTotalAmount() * 3) /100);
        iBookingService.addAccumulatedPoints(account.getId(),accumulatedPoints);
        System.out.println(account.getId());
        System.out.println(accumulatedPoints);

        String seat = "";


        for (Integer s: checkoutDTO.getSeatNumber()) {
            if (s>schedule.get().getHall().getTotalSeat() || s< 0){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
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

            seat = seat +  result + " " ;
        }

        iBookingService.sendMail(checkoutDTO.getAccountId(),checkoutDTO.getScheduleId(),seat,id);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
