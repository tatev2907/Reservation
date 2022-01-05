package com.example.reservation.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;


@Entity
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "fk_flight_id")
    @JsonIgnoreProperties({"fromCity", "toCity", "flightNumber", "seatcount", "reservations"})
    private Flight flight;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "fk_user_id")
    @JsonIgnoreProperties({"name", "surname", "email", "passportinfo", "reservations"})
    private User user;

    public Reservation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
