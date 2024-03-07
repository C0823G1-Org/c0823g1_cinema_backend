package com.example.c0823g1_movie_backend.controller;

import com.example.c0823g1_movie_backend.dto.IBookingDTO;
import com.example.c0823g1_movie_backend.service.IBookingService;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.example.c0823g1_movie_backend.config.MailConfig;
import com.example.c0823g1_movie_backend.dto.*;
import com.example.c0823g1_movie_backend.model.Account;
import com.example.c0823g1_movie_backend.model.Movie;
import com.example.c0823g1_movie_backend.model.Schedule;
import com.example.c0823g1_movie_backend.model.Ticket;
import com.example.c0823g1_movie_backend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.*;

import java.time.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin("*")
@RequestMapping("/booking")
public class BookingRestController {
    private static final String FOUND = "FOUND";
    private static final String BAD_REQUEST = "BAD_REQUEST";
    private static final String NO_CONTENT = "NO_CONTENT";
    private static final String OK = "OK";


    /* Create by: DoLV
     * Date created: 29/02/2024
     * Function: Displays the list and pagination of ticket bookings with a time from the current time about 1 week
     */

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

    @GetMapping("getListBooking/{id}/{dateStart}/{dateEnd}/{page}")
    public ResponseEntity<Page<HistoryBookingDTO>> getListBooking(@PathVariable int page,
                                                                  @PathVariable Long id,
                                                                  @PathVariable LocalDateTime dateStart,
                                                                  @PathVariable LocalDateTime dateEnd) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<HistoryBookingDTO> list = iBookingService.getHistory(id, dateStart, dateEnd, pageable);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    @GetMapping(value = {"/", "/list"})
    public ResponseEntity<Object> listBookingTicket( @PageableDefault(size = 5) Pageable pageable ) {
        LocalDateTime time = LocalDateTime.now();
        Page<IBookingDTO> listBookingTicket = iBookingService.findAllBookingTicket(pageable, time);
        ApiResponse response = new ApiResponse<>();
        if (listBookingTicket.isEmpty()){
            response.setFlag("NOT_FOUND");
            response.setData(listBookingTicket);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        response.setFlag(FOUND);
        response.setData(listBookingTicket);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    /*
     * Create by TuanNM
     * Date create: 29/02/2024
     * Method: Display ticket booking history
     * @Param Account ID
     * @Return A list of booking history
     */


    @GetMapping("/search")
    public ResponseEntity<Object> searchBookingTicket(
            @RequestParam(value = "searchInput", required = false) String search,
            @RequestParam(value = "date", required = false) LocalDate localDate,
            @PageableDefault(size = 5) Pageable pageable) {
        if (search != null){
            search = search.trim();
        }

        LocalDateTime timeNow = LocalDateTime.now();
        if (search == null && localDate == null) {
            ApiResponse response = new ApiResponse<>();
            Page<IBookingDTO> listBookingTicketNotFound = iBookingService.findAllBookingTicket(pageable, timeNow);
            response.setData(listBookingTicketNotFound);
            response.setFlag(FOUND);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        if (search != null && localDate != null) {
            LocalDateTime dateSearch = localDate.atStartOfDay();
            Page<IBookingDTO> listBookingTicket = iBookingService.searchBookingTicketWithParameterSearchAndDate(search, dateSearch, pageable);
            return getResponseEntity(listBookingTicket, timeNow, pageable);
        } else if (search != null) {
            Page<IBookingDTO> listBookingTicket = iBookingService.searchBookingTicketWithParameterSearch(search, timeNow, pageable);
            return getResponseEntity(listBookingTicket, timeNow, pageable);
        } else {
            LocalDateTime dateSearch = localDate.atStartOfDay();
            Page<IBookingDTO> listBookingTicket = iBookingService.searchBookingTicketWithParameterDate(dateSearch, pageable);
            return getResponseEntity(listBookingTicket, dateSearch, pageable);
        }
    }

    private ResponseEntity<Object> getResponseEntity(Page<IBookingDTO> listBookingTicket, LocalDateTime timeNow,Pageable pageable) {
        ApiResponse<Page<IBookingDTO>> response = new ApiResponse<>();
        if (listBookingTicket.isEmpty()) {
            Page<IBookingDTO> listBookingTicketNotFound = iBookingService.findAllBookingTicket(pageable, timeNow);
            response.setFlag("NOT_FOUND");
            response.setData(listBookingTicketNotFound);
        } else {
            response.setFlag(FOUND);
            response.setData(listBookingTicket);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /* Created by: DoLV
     * Date created: February 29, 2024
     * Function: Select a booking ticket detail . If the booking ticket is not found, it returns the default booking ticket list. If the booking ticket exists and the printing status is false,
     * it returns the booking ticket object to be printed.
     */

    @GetMapping("/exportDetail")
    public ResponseEntity<Object> bookingTicketDetail(@RequestParam("idBooking") String id, @PageableDefault(size = 5) Pageable pageable){
        try{
            ApiResponse response = new ApiResponse<>();
            Long bookingId = parseLong(id);
            IBookingDTO iBookingDTO = iBookingService.findBookingTicketById(bookingId);
            LocalDateTime time = LocalDateTime.now();
            Page<IBookingDTO> listBookingTicket = iBookingService.findAllBookingTicket(pageable,time);

            if (iBookingDTO == null){
                response.setData(listBookingTicket);
                response.setFlag(BAD_REQUEST);
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {

                if (iBookingDTO.getPrintStatus()){
                    response.setData(listBookingTicket);
                    response.setFlag(BAD_REQUEST);
                    return new ResponseEntity<>(response, HttpStatus.OK);
                } else {
                    response.setFlag(FOUND);
                    List<IBookingDTO> listBookingTicketDetail = iBookingService.listBookingTicketDetail(bookingId);
                    response.setData(listBookingTicketDetail);
                    return new ResponseEntity<>(response, HttpStatus.OK);
                }
            }

        } catch (NumberFormatException e){
            return new ResponseEntity<>("Invalid idBooking format", HttpStatus.BAD_REQUEST);
        }
    }

    private Long parseLong(String id) throws NumberFormatException {
        if (!id.matches("\\d+")) {
            throw new NumberFormatException("Invalid idBooking format");
        }
        BigInteger idBigInt = new BigInteger(id);
        if (idBigInt.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) > 0) {
            throw new NumberFormatException("Invalid idBooking format. Number exceeds Long.MAX_VALUE.");
        }
        Long idChange =  idBigInt.longValue();
        if (idChange <= 0L) {
            throw new NumberFormatException("Invalid idBooking format. Number must not be negative.");
        }

        return idChange;
    }


    /* Created by: DoLV
     * Date created: February 29, 2024
     * Function: Print ticket to file pdf. If the booking ticket is not found, it returns the default booking ticket list. If the booking ticket exists and the printing status is false, will print the ticket and set the print status to true.
     */
    @GetMapping("/exportPDF")
    public ResponseEntity<Object> bookingTicketExportPDF(@RequestParam("idBooking") String idInput, @PageableDefault(size = 5) Pageable pageable) throws FileNotFoundException, DocumentException {
        Long id = parseLong(idInput);
        LocalDateTime time = LocalDateTime.now();
        Page<IBookingDTO> listBookingTicket = iBookingService.findAllBookingTicket(pageable,time);
        ApiResponse response = new ApiResponse<>();
        IBookingDTO iBookingDTO = iBookingService.findBookingTicketById(id);
        response.setData(listBookingTicket);

        if (iBookingDTO == null){
            response.setFlag(BAD_REQUEST);
            return new ResponseEntity<>( response,HttpStatus.OK);
        } else {
            if (iBookingDTO.getPrintStatus()){
                response.setFlag(NO_CONTENT);
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                List<IBookingDTO> listBookingTicketDetail = iBookingService.listBookingTicketDetail(id);
                if (listBookingTicketDetail.isEmpty()){
                    response.setFlag(NO_CONTENT);
                    return new ResponseEntity<>( response,HttpStatus.OK);
                } else {
                    response.setFlag(OK);
                    String fileName = "C:\\Users\\Public\\ticket" + id + ".pdf";
                    float customWidth = 650;
                    float customHeight = 396;
                    Rectangle pageSize = new Rectangle(customWidth, customHeight);
                    Document document = new Document(pageSize, -50, 0, 110, 0);
                    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(fileName));
//                    String fileName = "D:\\filePdf\\ticket_" + temp.getBookingCode() + "_MV_"+ temp.getSeatNumber() + ".pdf";
                    document.open();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE-MM-dd HH:mm:ss");

                    for (IBookingDTO temp : listBookingTicketDetail){
                        // in
                        String formattedDateTime = temp.getDateBooking().format(formatter);
                        try{
                            document.newPage();
                            addBackgroundAndContent(writer, document, temp, formattedDateTime);

                        } catch (DocumentException e) {
                            throw new RuntimeException(e);
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    document.close();
                    iBookingService.setPrintStatus(id);
                    response.setData(fileName);

                }

                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        }
    }

    /* Created by: DoLV
     * Date created: February 29, 2024
     * Function: Support for printing pdf files with the function of adding content and background images.
     */

    private void addBackgroundAndContent(PdfWriter writer, Document document, IBookingDTO iBookingDTO , String formattedDateTime) throws IOException, DocumentException {
        PdfContentByte canvas = writer.getDirectContentUnder();
        Image background = Image.getInstance("D:\\Pictures\\ticket.jpg");
        float documentWidth = document.getPageSize().getWidth();
        float documentHeight = document.getPageSize().getHeight();
        float width = 680;
        float height = 400;
        background.scaleToFit(width, height);
        float x = (documentWidth - background.getScaledWidth()) / 2;
        float yBackground = (documentHeight - background.getScaledHeight() + 250 + 20) / 2;
        background.setAbsolutePosition(0,0);
        Rectangle rectBackground = new Rectangle(
                documentWidth ,
                documentHeight
        );
        rectBackground.setBorder(Rectangle.BOX);
        rectBackground.setBorderWidth(1);
        canvas.rectangle(rectBackground);
        canvas.addImage(background);
        BaseColor color = BaseColor.BLACK;
        Font font = FontFactory.getFont(FontFactory.HELVETICA, 14, color);
        Font boldFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, color);

        PdfPTable table = new PdfPTable(1);
        table.setWidthPercentage(65);
        table.setTotalWidth(width);
        float yTable = yBackground - 70;

        table.writeSelectedRows(0, 0, x, yTable, writer.getDirectContent());
        table.addCell(createTitleCell("Vé xem phim", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLACK)));

        table.addCell(createCell("                           ---------------------------------------------------------",font));
        table.addCell(createCell("         Phim:  " + iBookingDTO.getNameMovieFilm(), boldFont));
        table.addCell(createCell("         Ngày chếu:  " + iBookingDTO.getScheduleDate(), boldFont));
        table.addCell(createCell("         Khách hàng:  " + iBookingDTO.getNameCustomer(), boldFont));
        table.addCell(createCell("         Ghế:  " + iBookingDTO.getSeatNumber(), boldFont));
        table.addCell(createCell("         Giá:  " + iBookingDTO.getTicketPrice() + " VND", boldFont));
        table.addCell(createCell("         Phòng:  " + iBookingDTO.getCinemaHall(), boldFont));
        table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        table.addCell(createCell("=====================================================",font));


        document.add(table);
    }
    private PdfPCell createCell(String content, Font font) {
        PdfPCell cell = new PdfPCell(new Phrase(content, font));
        cell.setBorder(Rectangle.NO_BORDER);
        return cell;
    }
    private PdfPCell createTitleCell(String content, Font font) {
        PdfPCell cell = new PdfPCell(new Phrase(content, font));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        return cell;
    }



    /*
     * Create by HaiNT
     * Date create: 29/02/2024
     * Method: Receive request from the client when checkout successfully
     * @RequestBody checkoutDTO(accountId,scheduleId,seatList)
     * @Return status
     */
    @PostMapping("/confirm")
    public ResponseEntity<BookingDTO> checkout(@RequestBody TicketDTO ticketDTO) {

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
        System.out.println(bookingDTO);
            return new ResponseEntity<>(bookingDTO, HttpStatus.OK);

    }



    @PostMapping("/fail")
    public ResponseEntity<Long> handleCheckoutFail(@RequestBody CheckoutDTO checkoutDTO) {
        if (checkoutDTO.getBookingId() == null || checkoutDTO.getAccountId() == null || checkoutDTO.getScheduleId() == null
                || checkoutDTO.getSeat().isEmpty() || checkoutDTO.getSeat() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Optional<Schedule> schedule = scheduleService.getScheduleById(checkoutDTO.getScheduleId());
        if (schedule.get().getMovie() == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
            Long movieId = schedule.get().getMovie().getId();
        ticketService.removeTicket(checkoutDTO.getBookingId(), checkoutDTO.getScheduleId());

        iBookingService.removeBooking(checkoutDTO.getBookingId());
        return new ResponseEntity<>(movieId, HttpStatus.OK);
    }

    @PostMapping("/success")
    public ResponseEntity<Object> handleCheckoutSuccess(@RequestBody CheckoutDTO checkoutDTO) {
        if (checkoutDTO.getBookingId() == null || checkoutDTO.getAccountId() == null || checkoutDTO.getScheduleId() == null
                || checkoutDTO.getSeat().isEmpty() || checkoutDTO.getSeat() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        String seat = "";
        for (String s : checkoutDTO.getSeat()) {
            seat += s + " ";
        }
        iBookingService.sendMail(checkoutDTO.getAccountId(), checkoutDTO.getScheduleId(), seat, checkoutDTO.getBookingId(), checkoutDTO.getTotalAmount());
        int accumulatedPoints = (int) Math.floor((checkoutDTO.getTotalAmount() * 3) / 100);

        iBookingService.addAccumulatedPoints(checkoutDTO.getAccountId(), accumulatedPoints);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
