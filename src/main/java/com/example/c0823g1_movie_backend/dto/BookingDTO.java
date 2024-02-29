package com.example.c0823g1_movie_backend.dto;

import java.util.List;

public class BookingDTO {
    private String image;
    private String movieName;
    private String screen;
    private String date;
    private String time;
    private List<String> seat;
    private Integer price;
    private Long sum;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<String> getSeat() {
        return seat;
    }

    public void setSeat(List<String> seat) {
        this.seat = seat;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }

    public BookingDTO() {
    }

    public BookingDTO(String image, String movieName, String screen, String date, String time, List<String> seat, Integer price, Long sum) {
        this.image = image;
        this.movieName = movieName;
        this.screen = screen;
        this.date = date;
        this.time = time;
        this.seat = seat;
        this.price = price;
        this.sum = sum;
    }
}
