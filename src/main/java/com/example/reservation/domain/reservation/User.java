package com.example.reservation.domain.reservation;


import lombok.Builder;
import lombok.Setter;

import java.util.List;

@Setter
@Builder
public class  User {

    Long id;
    String  Name;
    String Surname;
    String passportinfo;
    List<ReservationQL> reservations ;

}
