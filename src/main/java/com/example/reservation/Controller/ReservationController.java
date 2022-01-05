package com.example.reservation.Controller;

import com.example.reservation.Entity.Flight;
import com.example.reservation.Entity.DTO.ReservationDTO;
import com.example.reservation.Entity.User;
import com.example.reservation.Entity.Reservation;
import com.example.reservation.Service.FlightService;
import com.example.reservation.Service.ReservationService;
import com.example.reservation.Service.UserService;
import com.example.reservation.exception.FlightNotFound;
import com.example.reservation.exception.UserNotAuthenticatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reserve")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;
    @Autowired
    private FlightService flightService;
    @Autowired
    private UserService userService;


    @PostMapping
    public ResponseEntity reserve(@RequestBody ReservationDTO reserve) {
        try {
            Flight flight = flightService.findById(reserve.getFlightID()).get();
            User user;
            try {
                user = userService.findById(reserve.getUserID()).get();

            } catch (Exception e) {
                throw new UserNotAuthenticatedException(reserve.getUserID());
            }
            Date date = reserve.getDate();
            Reservation reservation = reservationService.createNew();
            reservationService.reserveFlight(reservation, date, flight, user);
            return ResponseEntity.ok("Reservation completed successfully");

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Reservation failed");
        }
    }

    @GetMapping("/reservations")
    public List<Reservation> getAll() {
        try {
            return reservationService.findAll();
        } catch (Exception e) {
            List<Reservation> emplist = Collections.emptyList();
            return emplist;
        }

    }

    @GetMapping(value = "/{reserveID}")
    public Reservation getReserve(@PathVariable Long reserveID) {
        Optional<Reservation> optionalReservation = reservationService.findById(reserveID);
        if (optionalReservation.isPresent()) {
            return optionalReservation.get();
        }

        throw new FlightNotFound(reserveID.toString());
    }

    @GetMapping(value = "/flight/{flightID}")
    public List<Reservation> getReservebyFlight(@PathVariable Long flightID) {
        try {
            List<Reservation> reservations = reservationService.AllResByFlightIdRest(flightID);
            return reservations;
        } catch (Exception e) {
            List<Reservation> emplist = Collections.emptyList();
            return emplist;
        }
    }


    @GetMapping("/")
    public List<Reservation> getByDateRange(@RequestParam("flightId") Long flightId,
                                            @RequestParam("from") @DateTimeFormat(pattern = "yyyy-MM-dd") String fromDate,
                                            @RequestParam("to") @DateTimeFormat(pattern = "yyyy-MM-dd") String toDate
    ) {
        try {
            return reservationService.findInDateRange(fromDate, toDate, flightId);
        } catch (Exception e) {
            List<Reservation> emplist = Collections.emptyList();
            return emplist;
        }

    }


}
