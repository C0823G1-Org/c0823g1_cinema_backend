package com.example.c0823g1_movie_backend.controller;

import com.example.c0823g1_movie_backend.config.MailConfig;
import com.example.c0823g1_movie_backend.dto.*;
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
        iBookingService.saveBooking(checkoutDTO.getAccountId(),date);
        Integer id = iBookingService.getBooking();
        Long scheduleId = checkoutDTO.getScheduleId();
        for (Integer seat : checkoutDTO.getSeatNumber()) {
            ticketService.saveTicket(seat,id,scheduleId);
        }
        Schedule schedule = scheduleService.getScheduleById(checkoutDTO.getScheduleId()).get();
        Account account = accountService.findAccountById(checkoutDTO.getAccountId());
        String email = account.getEmail();
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

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(email);
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
