package com.example.reservation.domain.reservation;
import java.util.Date;

public class ReservationQL {
    long id ;
    Date date;
    long userId;
    long flightId;

    public ReservationQL(long id, Date date, long userId, long flightId) {
        this.id = id;
        this.date = date;
        this.userId = userId;
        this.flightId = flightId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public Long getuserId() {
        return userId;
    }

    public void setuserId(Long userId) {
        userId = userId;
    }

    public Long getflightId() {
        return flightId;
    }

    public void setflightId(Long flightId) {
        flightId = flightId;
    }


}
