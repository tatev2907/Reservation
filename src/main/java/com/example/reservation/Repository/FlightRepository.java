package com.example.reservation.Repository;

import java.util.List;


import com.example.reservation.Entity.Flight;
import com.example.reservation.Entity.DTO.FlightDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    //    get flight by id wihtout reservations list and create new object of FlightDTO
    @Query("SELECT new com.example.reservation.Entity.DTO.FlightDTO(a.id,a.fromCity,a.toCity,a.flightNumber,a.seatcount) " +
            "FROM flight a WHERE (a.id = :flightID)")
    FlightDTO flightbyID(@Param("flightID") Long flightID);

}


