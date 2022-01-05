package com.example.reservation.Service;

import com.example.reservation.Entity.Flight;
import com.example.reservation.Repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepo;

    public Flight registration(Flight flight) {
        return flightRepo.save(flight);
    }

    public List<Flight> findAllFlights() {
        List<Flight> flights = flightRepo.findAll();
        return flights;
    }

    public Optional<Flight> findById(Long id) {
        return flightRepo.findById(id);
    }


}
