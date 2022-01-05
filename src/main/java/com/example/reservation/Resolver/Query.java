package com.example.reservation.Resolver;

import com.example.reservation.Service.ReservationService;
import com.example.reservation.Entity.DTO.FlightDTO;
import com.example.reservation.domain.reservation.FlightQL;

import com.example.reservation.Repository.FlightRepository;
import com.example.reservation.Repository.ReservationRepository;
import com.example.reservation.domain.reservation.ReservationQL;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Component
@Transactional
public class Query implements GraphQLQueryResolver {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private ReservationService reservationService;

//get all reservations
    public List<ReservationQL> getReservations() {
        return reservationService.findAllQL();

    }

//    Get Flight by flight id

    public FlightQL getFlight(Long flightID) {
//        list of Reservations which is for this flight
        List<ReservationQL> reservations = reservationService.AllResByFlightId(flightID);
//        get flight by id

        FlightDTO flight = flightRepository.flightbyID(flightID);
// build new FlightQL for flight with adding reservation list which we get in line 39
        return FlightQL.builder().
                id(flightID)
                .fromCity(flight.getFromCity())
                .toCity(flight.getToCity())
                .flightNumber(flight.getFlightNumber())
                .seatcount(flight.getSeatcount())
                .reservations(reservations).build();

    }
}

