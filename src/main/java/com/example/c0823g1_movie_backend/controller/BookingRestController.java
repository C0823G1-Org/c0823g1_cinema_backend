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

    /*
     * Create by HaiNT
     * Date create: 29/02/2024
     * Method: Receive request from the client when checkout successfully
     * @RequestBody checkoutDTO(accountId,scheduleId,seatList)
     * @Return status
     */
    @PostMapping("/confirm")
    public ResponseEntity<BookingDTO> checkout(@RequestBody TicketDTO ticketDTO) {
        System.out.println("Save Ticket");

        if (ticketDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (ticketDTO.getAccountId() == null || ticketDTO.getScheduleId() == null || ticketDTO.getSeatList() == null || ticketDTO.getSeatList().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Optional<Schedule> schedule = scheduleService.getScheduleById(ticketDTO.getScheduleId());
        Account account = accountService.findAccountById(ticketDTO.getAccountId());
        if (schedule.isEmpty() || account == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        String result = "";
        String seatString = "";
        List<String> seat = new ArrayList<>();
        for (Integer s : ticketDTO.getSeatList()) {
            if (s > schedule.get().getHall().getTotalSeat() || s < 0) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            String ss = s.toString();
            if (s <= 10) {
                result = "A" + s;
            } else if (s <= 20) {
                if (s == 20) {
                    result = "B10";
                } else {
                    result = "B" + ss.charAt(ss.length() - 1);
                }

            } else if (s <= 30) {
                if (s == 30) {
                    result = "C10";
                } else {
                    result = "C" + ss.charAt(ss.length() - 1);
                }
            } else if (s <= 40) {
                if (s == 40) {
                    result = "D10";
                } else {
                    result = "D" + ss.charAt(ss.length() - 1);
                }
            } else if (s <= 50) {
                if (s == 50) {
                    result = "E10";
                } else {
                    result = "E" + ss.charAt(ss.length() - 1);
                }
            }
            seatString = seatString + " ";
            seat.add(result);
        }
        LocalDateTime bookingDate = LocalDateTime.now();
        iBookingService.saveBooking(account.getId(), bookingDate);
        Long bookingId = iBookingService.getBooking();
        List<Ticket> checkExist;
        for (Integer seatN : ticketDTO.getSeatList()) {
            checkExist = ticketService.checkExist(seatN, ticketDTO.getScheduleId());
            if (checkExist.isEmpty()) {
                ticketService.saveTicket(seatN, bookingId, ticketDTO.getScheduleId());
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
//        iBookingService.sendMail(ticketDTO.getAccountId(),ticketDTO.getScheduleId(),seatString,id);
        Long accountId = ticketDTO.getAccountId();
        Movie movie = movieService.findMovieById(schedule.get().getMovie().getId());
        String image = movie.getPoster();
        String movieName = movie.getName();
        String screen = schedule.get().getHall().getName();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String movieDate = schedule.get().getDate().format(formatter);

        String timeStart = schedule.get().getScheduleTime().getScheduleTime().toString().substring(0, 5);
        Integer price = movie.getTicketPrice();
        List<Integer> seatNumber = ticketDTO.getSeatList();
        Long sum = (long) (price * (seatNumber.size()));
        String email = account.getEmail();
        Long scheduleId = schedule.get().getId();
        BookingDTO bookingDTO = new BookingDTO(image, movieName, screen, movieDate, timeStart, seat, price, sum, email, accountId, scheduleId, seatNumber, bookingId);
        return new ResponseEntity<>(bookingDTO, HttpStatus.OK);
    }



    @PostMapping("/fail")
    public ResponseEntity<?> handleCheckoutFail(@RequestBody CheckoutDTO checkoutDTO) {
        if (checkoutDTO.getBookingId() == null || checkoutDTO.getAccountId() == null || checkoutDTO.getScheduleId() == null
                || checkoutDTO.getSeat().isEmpty() || checkoutDTO.getSeat() == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        System.out.println("Fail");
        ticketService.removeTicket(checkoutDTO.getBookingId(), checkoutDTO.getScheduleId());
        iBookingService.removeBooking(checkoutDTO.getBookingId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/success")
    public ResponseEntity<?> handleCheckoutSuccess(@RequestBody CheckoutDTO checkoutDTO) {
        if (checkoutDTO.getBookingId() == null || checkoutDTO.getAccountId() == null || checkoutDTO.getScheduleId() == null
        || checkoutDTO.getSeat().isEmpty() || checkoutDTO.getSeat() == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        System.out.println("Success");
        String seat = "";
        for (String s : checkoutDTO.getSeat()) {
            seat += s + " ";
        }
        iBookingService.sendMail(checkoutDTO.getAccountId(), checkoutDTO.getScheduleId(), seat, checkoutDTO.getBookingId());
        int accumulatedPoints = (int) Math.floor((checkoutDTO.getTotalAmount() * 3) / 100);

        iBookingService.addAccumulatedPoints(checkoutDTO.getAccountId(), accumulatedPoints);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
