package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.dto.HistoryBookingDTO;
import com.example.c0823g1_movie_backend.dto.IBookingDTO;
import com.example.c0823g1_movie_backend.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class BookingService implements IBookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Page<HistoryBookingDTO> getHistory(Long id, LocalDateTime dateStart, LocalDateTime dateEnd, Pageable pageable) {
        return bookingRepository.getHistory(id, dateStart, dateEnd, pageable);
    }

    @Override
    public List<HistoryBookingDTO> historyBooking(Long id, int number) {
        return bookingRepository.getListMovieByHistoryBooking(id, number);
    }

    @Override
    public Page<IBookingDTO> findAllBookingTicket(Pageable pageable, LocalDateTime time) {
        return bookingRepository.findAllBookingTicket(pageable, time);
    }


    @Override
    public List<HistoryBookingDTO> searchBookingByDate(Long id, LocalDateTime startDate, LocalDateTime endDate, int page) {
        return bookingRepository.searchMovieBookingByDate(id, startDate, endDate, page);
    }


    @Override
    public Page<IBookingDTO> searchBookingTicketWithParameterSearch(String search, LocalDateTime time, Pageable pageable) {
        return bookingRepository.searchBookingTicketWithParameterSearch(search, time, pageable);
    }

    @Override
    public IBookingDTO findBookingTicketById(Integer id) {
        return bookingRepository.findBookingTicketById(id);
    }

    @Override
    public List<IBookingDTO> listBookingTicketDetail(Integer id) {
        return bookingRepository.listBookingTicketDetail(id);
    }


    @Override
    public void saveBooking(Long accountId, LocalDateTime date) {
        bookingRepository.saveBooking(accountId, date);
    }

    @Override
    public Integer getBooking() {
        return bookingRepository.getBooking();
    }


}
