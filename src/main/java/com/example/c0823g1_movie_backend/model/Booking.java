package com.example.c0823g1_movie_backend.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity

public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;
    private Boolean printStatus = false;
    private Boolean isDeleted = false;
    private LocalDateTime dateBooking;
    @OneToMany(mappedBy = "booking")
    private Set<Ticket> tickets;

    public Booking() {
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Boolean getPrintStatus() {
        return printStatus;
    }

    public void setPrintStatus(Boolean printStatus) {
        this.printStatus = printStatus;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public LocalDateTime getDateBooking() {
        return dateBooking;
    }

    public void setDateBooking(LocalDateTime dateBooking) {
        this.dateBooking = dateBooking;
    }
}
