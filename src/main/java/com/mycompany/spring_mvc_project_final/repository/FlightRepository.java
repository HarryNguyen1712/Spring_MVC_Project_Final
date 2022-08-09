package com.mycompany.spring_mvc_project_final.repository;

import com.mycompany.spring_mvc_project_final.entities.BookingDetailEntity;
import com.mycompany.spring_mvc_project_final.entities.FlightRoutesEntity;
import com.mycompany.spring_mvc_project_final.entities.FlightsEntity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface FlightRepository extends CrudRepository<FlightsEntity,Integer> {

   /* @Query(value = "select f from FlightsEntity f where f.flightRoute = ?1 and f.departure = ?2")*/
    Iterable<FlightsEntity> findByFlightRouteAndDeparture(FlightRoutesEntity flightRoute, LocalDate departure);

    Iterable<FlightsEntity> findAll();

    @Query(value = "select * from flight where (timestamp(arrival,arrivalTime) between ?1 and ?2) or (timestamp(departure,departureTime) between ?1 and ?2) or ((timestamp(departure,departureTime) <= ?1)and(timestamp(arrival,arrivalTime) >= ?2)) ",nativeQuery = true)
    Iterable<FlightsEntity> findFlightByNewFlight(Timestamp start,Timestamp end);

}
