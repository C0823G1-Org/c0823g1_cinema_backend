package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.dto.HistoryBookingDTO;
import com.example.c0823g1_movie_backend.dto.IAccountDTO;
import com.example.c0823g1_movie_backend.dto.IBookingDTO;
import com.example.c0823g1_movie_backend.model.Schedule;
import com.example.c0823g1_movie_backend.repository.AccountRepository;
import com.example.c0823g1_movie_backend.repository.BookingRepository;
import com.example.c0823g1_movie_backend.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;


import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class BookingService implements IBookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public Page<HistoryBookingDTO> getHistory(Long id, LocalDateTime dateStart, LocalDateTime dateEnd, Pageable pageable) {
        return bookingRepository.getHistory(id, dateStart, dateEnd, pageable);
    }

    @Override
    public Page<IBookingDTO> findAllBookingTicket(Pageable pageable, LocalDateTime time) {
        return bookingRepository.findAllBookingTicket(pageable, time);
    }

    @Override
    public Page<IBookingDTO> searchBookingTicketWithParameterSearch(String search, LocalDateTime time, Pageable pageable) {
        return bookingRepository.searchBookingTicketWithParameterSearch(search, time, pageable);
    }

    @Override
    public IBookingDTO findBookingTicketById(Long id) {
        return bookingRepository.findBookingTicketById(id);
    }

    @Override
    public List<IBookingDTO> listBookingTicketDetail(Long id) {
        return bookingRepository.listBookingTicketDetail(id);
    }


    @Override
    public void saveBooking(Long accountId, LocalDateTime date) {
        bookingRepository.saveBooking(accountId, date);
    }



    @Override
    public Long getBooking() {
        return bookingRepository.getBooking();
    }

    @Override
    public void sendMail(Long accountId, Long scheduleId, String seat,Long id, Long total) {
        Optional<IAccountDTO> account = accountRepository.findByIdAccountDTO(accountId);
        Schedule schedule = scheduleRepository.getScheduleById(scheduleId);

        if (account.isPresent()) {
            String to = account.get().getEmail();
            String subject = "[C0823G1-Cinema]-Đặt vé thành công";
            String templateName = "ticket-gmail";
            org.thymeleaf.context.Context context = new org.thymeleaf.context.Context();
            context.setVariable("name", schedule.getMovie().getName());

            context.setVariable("seat", seat);
            context.setVariable("code", "TB"+id);


            // Định dạng tiền tệ với NumberFormat và Locale của Việt Nam
            NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
            String ticketPrice = numberFormat.format(total);
            context.setVariable("price",ticketPrice );
            context.setVariable("screen", schedule.getHall().getName());
            context.setVariable("movie", schedule.getMovie().getName());
            context.setVariable("image", schedule.getMovie().getPoster());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            context.setVariable("date", schedule.getDate().format(formatter));
            context.setVariable("time", schedule.getScheduleTime().getScheduleTime());
            accountService.sendEmailWithHtmlTemplate(to,subject,templateName,context);
        }
    }

    @Override
    public void addAccumulatedPoints(Long id, int accumulatedPoints) {
        bookingRepository.addAccumulatedPoints(id,accumulatedPoints);
    }

    @Override
    public void removeBooking(Long bookingId) {
        bookingRepository.removeBooking(bookingId);
    }
    @Override
    public Page<IBookingDTO> searchBookingTicketWithParameterSearchAndDate(String search, LocalDateTime dateSearch, Pageable pageable) {
        return bookingRepository.searchBookingTicketWithParameterSearchAndDate(search,dateSearch,pageable);
    }

    @Override
    public Page<IBookingDTO> searchBookingTicketWithParameterDate(LocalDateTime dateSearch, Pageable pageable) {
        return bookingRepository.searchBookingTicketWithParameterDate(dateSearch,pageable);
    }

    @Override
    public void setPrintStatus(Long id) {
        bookingRepository.setPrintStatus(id);
    }

    @Override
    public Long getBookingById(Long accountId) {
        return  bookingRepository.getBookingById(accountId);
    }

    @Override
    public void deleteById(Long aa) {
        bookingRepository.deleteById(aa);
    }


}
