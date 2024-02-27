package com.example.c0823g1_movie_backend.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "movie")
    Set<MovieHasGenre> genres;
    @OneToMany(mappedBy = "movie")
    Set<Schedule> schedules;
    private String name;
    private LocalDate startDate;
    private String actor;
    private String director;
    private String producer;
    private Integer duration;
    private String trailer;
    private String country;
    private String description;
    private String poster;
    private Integer ticketPrice;
    private Boolean isDeleted = false;

    public Movie() {
    }

    public Set<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(Set<Schedule> schedules) {
        this.schedules = schedules;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<MovieHasGenre> getGenres() {
        return genres;
    }

    public void setGenres(Set<MovieHasGenre> genres) {
        this.genres = genres;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Integer getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Integer ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
