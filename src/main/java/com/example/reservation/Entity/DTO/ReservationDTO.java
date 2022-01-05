package com.example.reservation.Entity.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;

public class ReservationDTO {
    private Long id;
    private Long flightID;
    private Long userID;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;

    public ReservationDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFlightID() {
        return flightID;
    }

    public void setFlightID(Long flightID) {
        this.flightID = flightID;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
