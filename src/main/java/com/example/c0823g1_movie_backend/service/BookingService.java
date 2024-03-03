package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.dto.HistoryBookingDTO;
import com.example.c0823g1_movie_backend.dto.IBookingDTO;
import com.example.c0823g1_movie_backend.model.Movie;
import com.example.c0823g1_movie_backend.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService implements IBookingService{
    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Page<IBookingDTO> findAllBookingTicket(Pageable pageable, LocalDateTime time) {
        return bookingRepository.findAllBookingTicket(pageable, time);
    }
    public List<HistoryBookingDTO> historyBooking(Long id) {
        return bookingRepository.getListMovieByHistoryBooking(id);
    }

    @Override
    public List<HistoryBookingDTO> searchBookingByDate(LocalDateTime startDate, LocalDateTime endDate) {
        return bookingRepository.searchMovieBookingByDate(startDate, endDate);
    }




    @Override
    public Page<IBookingDTO> searchBookingTicketWithParameterSearch(String search, LocalDateTime time , Pageable pageable) {
        return bookingRepository.searchBookingTicketWithParameterSearch(search,time,pageable);
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
        bookingRepository.saveBooking(accountId,date);
    }

    @Override
    public Integer getBooking() {
        return bookingRepository.getBooking();
    }

    @Override
    public Page<IBookingDTO> searchBookingTicketWithParameterSearchAndSearch(String search, LocalDateTime dateSearch, Pageable pageable) {
        return bookingRepository.searchBookingTicketWithParameterSearchAndSearch(search,dateSearch,pageable);
    }


}
