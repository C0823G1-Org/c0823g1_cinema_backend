package com.example.c0823g1_movie_backend.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "schedule", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"movie_id", "date", "schedule_time_id"}),
        @UniqueConstraint(columnNames = {"movie_id", "date", "schedule_time_id","hall_id"})
})
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "schedule_time_id", referencedColumnName = "id")
    private ScheduleTime scheduleTime;
    @ManyToOne
    @JoinColumn(name = "hall_id", referencedColumnName = "id")
    private Hall hall;
    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    private Movie movie;
    @OneToMany(mappedBy = "schedule")
    private Set<Ticket> tickets;
    private Boolean isDeleted = false;

    public Schedule() {
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public ScheduleTime getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(ScheduleTime scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
