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
    public Page<IBookingDTO> searchBookingTicketWithParameterSearch(String search, LocalDateTime time , Pageable pageable) {
        return bookingRepository.searchBookingTicketWithParameterSearch(search,time,pageable);
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
    public Integer getBooking() {
        return bookingRepository.getBooking();
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


}
