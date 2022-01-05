package com.example.reservation.Entity;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity(name = "UserInfo")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private String email;

    private String passportinfo;


    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties({"date", "flight", "user"})
    private List<Reservation> reservations;

    @PrePersist
    @PreUpdate
    private void prepareData() {
        this.email = (email == null) ? email : email.toLowerCase();
    }

    public List<Reservation> getreservations() {
        return reservations;
    }

    public void setBookings(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassportinfo() {
        return passportinfo;
    }

    public void setPassportinfo(String passportinfo) {
        this.passportinfo = passportinfo;
    }
}