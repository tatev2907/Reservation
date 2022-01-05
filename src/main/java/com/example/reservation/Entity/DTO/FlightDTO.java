package com.example.reservation.Entity.DTO;

public class FlightDTO {
    private Long  id;
    private String fromCity;
    private String toCity;
    private String flightNumber;
    private String seatcount;


    public FlightDTO(long id, String fromCity, String toCity, String flightNumber, String seatcount) {
        this.id = id;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.flightNumber = flightNumber;
        this.seatcount = seatcount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getSeatcount() {
        return seatcount;
    }

    public void setSeatcount(String seatcount) {
        this.seatcount = seatcount;
    }
}
