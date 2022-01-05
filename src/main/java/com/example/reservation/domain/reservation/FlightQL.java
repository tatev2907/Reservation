package com.example.reservation.domain.reservation;


import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder
@Value
public class FlightQL {
    Long id;
    String fromCity ;
    String toCity  ;
    String flightNumber ;
    String seatcount;
    List<ReservationQL> reservations ;
}
