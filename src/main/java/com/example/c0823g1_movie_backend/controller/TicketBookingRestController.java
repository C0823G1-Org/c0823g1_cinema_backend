package com.example.c0823g1_movie_backend.controller;

import com.example.c0823g1_movie_backend.config.MailConfig;
import com.example.c0823g1_movie_backend.dto.BookingDTO;
import com.example.c0823g1_movie_backend.dto.CheckoutDTO;
import com.example.c0823g1_movie_backend.dto.TicketDTO;
import com.example.c0823g1_movie_backend.model.Account;
import com.example.c0823g1_movie_backend.model.Movie;
import com.example.c0823g1_movie_backend.model.Schedule;
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
@RequestMapping("/api/ticket/booking")
public class TicketBookingRestController {
    @Autowired
    private IBookingService bookingService;

    @Autowired
    private IScheduleService scheduleService;

    @Autowired
    private IMovieService movieService;

    @Autowired
    private ITicketService ticketService;

    @Autowired
    private IAccountService accountService;

    @Autowired
    private MailConfig mailConfig;

    @PostMapping()
    public ResponseEntity<BookingDTO> returnInformationTicketBooking(@RequestBody TicketDTO ticket) {
        System.out.println("abc");
        Optional<Movie> movie = Optional.ofNullable(movieService.findMovieById(ticket.getIdMovie()));
        Optional<Schedule> schedule = scheduleService.getScheduleById(ticket.getScheduleId());
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

        Account account = accountService.findAccountById(ticket.getAccountId());
        String email = account.getEmail();


        BookingDTO bookingDTO = new BookingDTO(image,movieName,screen,movieDate,timeStart,seat,price,sum,email);



        return new ResponseEntity<>(bookingDTO, HttpStatus.OK);
    }


    @PostMapping ("/checkout")
    public ResponseEntity<CheckoutDTO> checkout(@RequestBody CheckoutDTO checkoutDTO){
        LocalDateTime date = LocalDateTime.now();

        bookingService.saveBooking(checkoutDTO.getAccountId(),date);
        Account account = accountService.findAccountById(checkoutDTO.getAccountId());
        Integer id = bookingService.getBooking();
        Long scheduleId = checkoutDTO.getScheduleId();

        

        for (Integer seat : checkoutDTO.getSeatNumber()) {

            ticketService.saveTicket(seat,id,scheduleId);
        }
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(account.getEmail());
        mailMessage.setSubject("Bạn đã đặt vé xem phim thành công");
        String content = "Tên phim: \n" +
                "Ngày chiếu: \n" +
                "Phòng chiếu: \n" +
                "Giờ: \n" +
                "Ghế: \n" +
                "Vui lòng đến trước 30 phút để nhận vé \n" +
                "Chúc bạn xem phim vui vẻ";
        mailMessage.setText(content);
        mailConfig.getJavaMailSender().send(mailMessage);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
