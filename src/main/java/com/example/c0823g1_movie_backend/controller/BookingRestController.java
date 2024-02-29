package com.example.c0823g1_movie_backend.controller;

import com.example.c0823g1_movie_backend.dto.IBookingDTO;
import com.example.c0823g1_movie_backend.service.IBookingService;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    /* Created by: DoLV
     * Date created: February 29, 2024
     * Function: Select a booking ticket detail . If the booking ticket is not found, it returns the default booking ticket list. If the booking ticket exists and the printing status is false, it returns the booking ticket object to be printed.
     */

    @GetMapping("/exportDetail/{idBookingTicket}")
    public ResponseEntity<?> bookingTicketDetail(@PathVariable("idBookingTicket") Integer id){
       IBookingDTO iBookingDTO = iBookingService.findBookingTicketById(id);
        LocalDateTime time = LocalDateTime.now();
        Pageable pageable = PageRequest.of(0, 2);
        Page<IBookingDTO> listBookingTicket = iBookingService.findAllBookingTicket(pageable,time);

        if (iBookingDTO == null){
            return new ResponseEntity<>(listBookingTicket, HttpStatus.NOT_FOUND);
        } else {
            if (!iBookingDTO.getPrintStatus()){
                return new ResponseEntity<>(listBookingTicket, HttpStatus.NOT_FOUND);
            } else {
                List<IBookingDTO> listBookingTicketDetail = iBookingService.listBookingTicketDetail(id);

                return new ResponseEntity<>(listBookingTicketDetail, HttpStatus.OK);
            }
        }
    }


    /* Created by: DoLV
     * Date created: February 29, 2024
     * Function: Print ticket to file pdf. If the booking ticket is not found, it returns the default booking ticket list. If the booking ticket exists and the printing status is false, will print the ticket and set the print status to true.
     */
    @GetMapping("/exportPDF/{idBookingTicket}")
    public ResponseEntity<?> bookingTicketExportPDF(@PathVariable("idBookingTicket") Integer id) throws FileNotFoundException, DocumentException {
        IBookingDTO iBookingDTO = iBookingService.findBookingTicketById(id);

        if (iBookingDTO == null){
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        } else {
            if (!iBookingDTO.getPrintStatus()){
                return new ResponseEntity<>( HttpStatus.NO_CONTENT);
            } else {
                List<IBookingDTO> listBookingTicketDetail = iBookingService.listBookingTicketDetail(id);

                for (IBookingDTO temp : listBookingTicketDetail){
                    String fileName = "D:\\filePdf\\ticket_" + temp.getBookingCode() + "_MV_"+ temp.getSeatNumber() + ".pdf";
                    float customWidth = 650;
                    float customHeight = 396;
                    Rectangle pageSize = new Rectangle(customWidth, customHeight);
                    Document document = new Document(pageSize, -50, 0, 130, 0);
                    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(fileName));
                    // in
                    try{
                            document.open();
                            document.newPage();
                            addBackgroundAndContent(writer, document, temp);

                        document.close();

                    } catch (DocumentException e) {
                        throw new RuntimeException(e);
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }


                return new ResponseEntity<>(listBookingTicketDetail, HttpStatus.OK);
            }
        }
    }





    /* Created by: DoLV
     * Date created: February 29, 2024
     * Function: Support for printing pdf files with the function of adding content and background images.
     */
    private void addBackgroundAndContent(PdfWriter writer, Document document, IBookingDTO iBookingDTO ) throws IOException, DocumentException {
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
//        Font boldFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, color);

        PdfPTable table = new PdfPTable(2);
        // khoang cach 2 col
        table.setWidthPercentage(65);
        table.setTotalWidth(width);
        float yTable = yBackground - 70;

        table.writeSelectedRows(0, 0, x, yTable, writer.getDirectContent());

        table.addCell(createCell("Movie: " + iBookingDTO.getNameMovie(),font));
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        String formattedDateTime = ticket.getStartTime().format(formatter);
        table.addCell(createCell("Show Time: " + iBookingDTO.getScheduleTime(), font));
        table.addCell(createCell("Customer: " + iBookingDTO.getNameCustomer(), font));
        table.addCell(createCell("Seat Number: " + iBookingDTO.getSeatNumber(), font));
        table.addCell(createCell("Ticket Price:" + iBookingDTO.getTicketPrice(), font));
        table.addCell(createCell("Room Number: " + iBookingDTO.getCinemaHall(), font));
        table.getDefaultCell().setBorder(Rectangle.NO_BORDER);


        document.add(table);
    }

    private PdfPCell createCell(String content, Font font) {
        PdfPCell cell = new PdfPCell(new Phrase(content, font));
        cell.setBorder(Rectangle.NO_BORDER);
        return cell;
    }



}
