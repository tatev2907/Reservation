package com.example.reservation.Repository;

import com.example.reservation.Entity.Reservation;
import com.example.reservation.domain.reservation.ReservationQL;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;


@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    List<Reservation> findAll();

//    list of reservations each reservation contains only relational id-es, not relational objects

    @Query("SELECT  new com.example.reservation.domain.reservation.ReservationQL(b.id,b.date,b.flight.id, b.user.id) " +
            "FROM Reservation b")
    List<ReservationQL> findAllQL();

//    list of reservations each reservation contains only relational id-es, not relational objects which flightId passed as arument

    @Query("SELECT  new com.example.reservation.domain.reservation.ReservationQL(b.id,b.date,b.flight.id, b.user.id) " +
            "FROM Reservation b LEFT OUTER JOIN flight a ON b.flight.id = a.id  WHERE a.id = :flightID")
    List<ReservationQL> AllResByFlightId(@Param("flightID") Long flightID);

    @Query("SELECT b FROM Reservation b LEFT OUTER JOIN flight a ON b.flight.id = a.id  WHERE a.id = :flightID")
    List<Reservation> AllResByFlightIdRest(@Param("flightID") Long flightID);


//    find all reservation of given flight by id in date range
    @Query("SELECT b FROM Reservation b LEFT OUTER JOIN flight a ON b.flight.id = a.id WHERE a.id = :flightID AND ((:fromdate <= b.date AND b.date < :todate) )")
    List<Reservation> findByDateRage(@Param("fromdate") Date fromdate, @Param("todate") Date todate, @Param("flightID") Long flightID);

}

