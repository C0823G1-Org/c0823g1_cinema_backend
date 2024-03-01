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

        Schedule schedule = scheduleService.getScheduleById(checkoutDTO.getScheduleId()).get();

        String seat = "";


        for (Integer s: checkoutDTO.getSeatNumber()) {
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

            seat += result;
        }


        for (Integer seatNumber : checkoutDTO.getSeatNumber()) {

            ticketService.saveTicket(seatNumber,id,scheduleId);
        }
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(account.getEmail());
        mailMessage.setSubject("Bạn đã đặt vé xem phim thành công");
        String content = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Document</title>\n" +
                "</head>\n" +
                "\n" +
                "<body style=\"width: 80%;;margin-left: 10%;\">\n" +
                "    <img style=\"width: 50%;height: 30%;margin-left: 25%;\"\n" +
                "        src=\""+ schedule.getMovie().getPoster() +"\" alt=\"Madame Web\n" +
                "    \n" +
                "    Xem thêm tại: https://www.galaxycine.vn/\">\n" +
                "    <table style=\"width: 100%;padding-left: 20%;\">\n" +
                "        <tr>\n" +
                "            <td>Phòng chiếu</th>\n" +
                "            <td>"+schedule.getHall().getName()+"</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td>Ngày chiếu</th>\n" +
                "            <td>"+schedule.getDate()+"</td>\n" +
                "        </tr>\n" +
                "\n" +
                "        <tr>\n" +
                "            <td>Giờ chiếu</th>\n" +
                "            <td>"+ schedule.getScheduleTime().getScheduleTime()+"</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td>Ghế </th>\n" +
                "            <td>"+
                seat
                +"</td>\n" +
                "        </tr>\n" +
                "    </table>\n" +
                "    <img style=\"width: 30%;height: 30%;margin-left: 35%;\"\n" +
                "        src=\"https://t3.gstatic.com/licensed-image?q=tbn:ANd9GcSh-wrQu254qFaRcoYktJ5QmUhmuUedlbeMaQeaozAVD4lh4ICsGdBNubZ8UlMvWjKC\"\n" +
                "        alt=\"\">\n" +
                "</body>\n" +
                "\n" +
                "</html>";
        mailMessage.setText(content);
        mailConfig.getJavaMailSender().send(mailMessage);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
