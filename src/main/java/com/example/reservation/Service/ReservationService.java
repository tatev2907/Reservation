package com.example.reservation.Service;

import com.example.reservation.Entity.Flight;
import com.example.reservation.Entity.Reservation;
import com.example.reservation.Entity.User;
import com.example.reservation.domain.reservation.ReservationQL;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.reservation.Repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;


    public Reservation createNew() {
        return new Reservation();
    }

    public void reserveFlight(Reservation reservation, Date date, Flight flight, User user) {
        reservation.setDate(date);
        reservation.setFlight(flight);
        reservation.setUser(user);
        reservationRepository.save(reservation);

    }

    public Optional<Reservation> findById(Long id) {
        return reservationRepository.findById(id);
    }

    public List<ReservationQL> AllResByFlightId(Long id) {

        return reservationRepository.AllResByFlightId(id);
    }

    public List<Reservation> AllResByFlightIdRest(Long id) {

        return reservationRepository.AllResByFlightIdRest(id);
    }

    public List<ReservationQL> findAllQL() {

        return reservationRepository.findAllQL();
    }

    public List<Reservation> findAll() {

        return reservationRepository.findAll();
    }

    public List<Reservation> findInDateRange(String fromdate, String todate, Long flightID) {
        Date fdate = Date.valueOf(fromdate);
        Date tdate = Date.valueOf(todate);
        return reservationRepository.findByDateRage(fdate, tdate, flightID);
    }


}
