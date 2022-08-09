package com.mycompany.spring_mvc_project_final.controller;

import com.mycompany.spring_mvc_project_final.entities.AircraftSeatsEntity;
import com.mycompany.spring_mvc_project_final.entities.AirportsEntity;
import com.mycompany.spring_mvc_project_final.entities.FlightRoutesEntity;
import com.mycompany.spring_mvc_project_final.entities.FlightsEntity;
import com.mycompany.spring_mvc_project_final.enums.SeatTypeEnum;
import com.mycompany.spring_mvc_project_final.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Controller
public class SearchController {

    @Autowired
    FlightService flightsService;

    @Autowired
    FlightsRoutesService flightRouteService;

    @Autowired
    AirportService airportService;

    @Autowired
    AircraftSeatService aircraftSeatsService;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(Model model, @Valid @ModelAttribute(name = "flights") FlightsEntity flights, BindingResult result, @RequestParam(name = "return") String date) throws ParseException {
        if (result.hasErrors()) {
            model.addAttribute("flights", flights);

            model.addAttribute("airports", airportService.findAll());
            return "index";
        }
        if (!date.isEmpty() /*&& date != null && !date.equals("")*/) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate returnDate = LocalDate.parse(date, formatter);
            if (returnDate.isBefore(flights.getDeparture())) {
                model.addAttribute("flights", flights);
                model.addAttribute("airports", airportService.findAll());
                return "index";
            }
        }
        model.addAttribute("returnDate", date);
        model.addAttribute("seatType", SeatTypeEnum.values());
        AirportsEntity departure = flights.getFlightRoute().getDepartureAirport();
        AirportsEntity destination = flights.getFlightRoute().getDestinationAirport();
        Optional<FlightRoutesEntity> routes = flightRouteService.findByCriteria(departure.getName(), destination.getName());
        if (routes.isPresent()) {
            List<FlightsEntity> flightsList = flightsService.findAvailableFlight(flightsService.findAllByFlightRouteAndDeparture(routes.get(), flights.getDeparture()));
            if (!flightsList.isEmpty()) {
                model.addAttribute("flight_route", routes.get());
                model.addAttribute("flightsList", flightsList);
                model.addAttribute("checkRoundTrip", false);
            } else model.addAttribute("message", "Flight not found!!");
        } else {
            model.addAttribute("message", "Flight route not found!!");
        }
        return "search";
    }

    @RequestMapping(value = "/checkIfRoundTrip", method = RequestMethod.GET)
    public String checkIfRoundTrip(Model model, @RequestParam(name = "id") String flightId,
                                   @RequestParam(name = "seatType") String seatType,
                                   @RequestParam(name = "seatPrice") String departSeatPrice,
                                   @RequestParam(name = "returnDate") String date) {

        FlightsEntity flights = flightsService.findById(Integer.parseInt(flightId)).get();
        model.addAttribute("departFlight", flights);
        model.addAttribute("departSeatType", seatType);
        model.addAttribute("emptyAircraftSeatList", new AircraftSeatsEntity());
        model.addAttribute("seatType", SeatTypeEnum.values());
        model.addAttribute("departSeatPrice", Double.parseDouble(departSeatPrice));
        if (date.isEmpty()) {
            return "flight_check";
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate returnDate = LocalDate.parse(date, formatter);
            FlightsEntity returnFlight = new FlightsEntity();
            returnFlight.setDeparture(returnDate);
            AirportsEntity destination = flights.getFlightRoute().getDepartureAirport();
            AirportsEntity departure = flights.getFlightRoute().getDestinationAirport();
            Optional<FlightRoutesEntity> routes = flightRouteService.findByCriteria(departure.getName(), destination.getName());
            if (routes.isPresent()) {
                List<FlightsEntity> flightsList = flightsService.findAvailableFlight(flightsService.findAllByFlightRouteAndDeparture(routes.get(), returnFlight.getDeparture()));
                if (!flightsList.isEmpty()) {
                    model.addAttribute("flight_route", routes.get());
                    model.addAttribute("flightsList", flightsList);
                    model.addAttribute("checkRoundTrip", true);
                } else model.addAttribute("message", "Flight not found!!");
            } else {
                model.addAttribute("message", "Flight route not found!!");
            }
            return "search";
        }
    }

    @RequestMapping(value = "/flightCheck", method = RequestMethod.GET)
    public String flightCheck(Model model, @RequestParam(name = "departFlightId") String departFlightId,
                              @RequestParam(name = "departSeatType") String departSeatType,
                              @RequestParam(name = "departSeatPrice") String departSeatPrice,
                              @RequestParam(name = "returnFlightId") String returnFlightId,
                              @RequestParam(name = "returnSeatType") String returnSeatType,
                              @RequestParam(name = "returnSeatPrice") String returnSeatPrice) {
        FlightsEntity departFlight = flightsService.findById(Integer.parseInt(departFlightId)).get();
        FlightsEntity returnFlight = flightsService.findById(Integer.parseInt(returnFlightId)).get();
        model.addAttribute("departFlight", departFlight);
        model.addAttribute("returnFlight", returnFlight);
        model.addAttribute("departSeatType", departSeatType);
        model.addAttribute("returnSeatType", returnSeatType);
        model.addAttribute("departSeatPrice", Double.parseDouble(departSeatPrice));
        model.addAttribute("returnSeatPrice", Double.parseDouble(returnSeatPrice));
        model.addAttribute("checkIfRoundTrip", true);
        return "flight_check";
    }
}
