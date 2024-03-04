package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.dto.HistoryBookingDTO;
import com.example.c0823g1_movie_backend.dto.IAccountDTO;
import com.example.c0823g1_movie_backend.dto.IBookingDTO;
import com.example.c0823g1_movie_backend.model.Booking;
import com.example.c0823g1_movie_backend.model.Movie;
import com.example.c0823g1_movie_backend.model.Schedule;
import com.example.c0823g1_movie_backend.repository.AccountRepository;
import com.example.c0823g1_movie_backend.repository.BookingRepository;
import com.example.c0823g1_movie_backend.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService implements IBookingService{
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public List<HistoryBookingDTO> historyBooking(Long id) {
        return bookingRepository.getListMovieByHistoryBooking(id);
    }

    @Override
    public List<HistoryBookingDTO> searchBookingByDate(LocalDateTime startDate, LocalDateTime endDate) {
        return bookingRepository.searchMovieBookingByDate(startDate, endDate);
    }
    public List<IBookingDTO> findAllBookingTicket(LocalDateTime time) {
        return bookingRepository.findAllBookingTicket(time);
    }

    @Override
    public List<IBookingDTO> searchBookingTicketWithParameterSearch(String search, LocalDateTime time) {
        return bookingRepository.searchBookingTicketWithParameterSearch(search,time);
    }


    @Override
    public void saveBooking(Long accountId, LocalDateTime date) {
        bookingRepository.saveBooking(accountId,date);
    }

    @Override
    public Integer getBooking() {
        return bookingRepository.getBooking();
    }

    @Override
    public void sendMail(Long accountId, Long scheduleId, String seat, Integer id) {
        Optional<IAccountDTO> account = accountRepository.findByIdAccountDTO(accountId);
        Integer bookingId = bookingRepository.getBooking();
        Schedule schedule = scheduleRepository.getScheduleById(scheduleId);

        if (account.isPresent()) {
            String to = account.get().getEmail();
            String subject = "[C0823G1-Cinema]-Đặt vé thành công";
            String templateName = "email-checkout";
            org.thymeleaf.context.Context context = new org.thymeleaf.context.Context();
            context.setVariable("seat", seat);
            context.setVariable("code", "TB"+bookingId);
            context.setVariable("screen", schedule.getHall().getName());
            context.setVariable("movie", schedule.getMovie().getName());
            context.setVariable("image", schedule.getMovie().getPoster());
            context.setVariable("date", schedule.getDate());
            context.setVariable("time", schedule.getScheduleTime().getScheduleTime());
            accountService.sendEmailWithHtmlTemplate(to,subject,templateName,context);
        }
    }

    @Override
    public void addAccumulatedPoints(Long id, int accumulatedPoints) {
        bookingRepository.addAccumulatedPoints(id,accumulatedPoints);
    }

}
