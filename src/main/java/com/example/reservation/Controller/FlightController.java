package com.example.reservation.Controller;

import com.example.reservation.Entity.Flight;
import com.example.reservation.Entity.User;
import com.example.reservation.Service.FlightService;
import com.example.reservation.Service.UserService;
import com.example.reservation.exception.FlightNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flight")
public class FlightController {
    @Autowired
    private FlightService flightService;


    @PostMapping
    public ResponseEntity registration(@RequestBody Flight flight) {
        try {
            flightService.registration(flight);
            return ResponseEntity.ok("Flight added successfully");

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to add new flight");
        }
    }
    @GetMapping("/all")
    public List<Flight> getAll() {
        try {
            return flightService.findAllFlights();

        } catch (Exception e) {
            List<Flight> emplist = Collections.emptyList();
            return emplist;
        }
    }

    @GetMapping(value = "/{flightID}")
    public Flight getFlight(@PathVariable Long flightID) {
        Optional<Flight> optionalflight = flightService.findById(flightID);
        if (optionalflight.isPresent()) {
            return optionalflight.get();
        }
        throw new FlightNotFound(flightID.toString());
    }


}
