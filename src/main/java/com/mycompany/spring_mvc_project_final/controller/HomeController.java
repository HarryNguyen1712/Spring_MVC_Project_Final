/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_project_final.controller;

import com.mycompany.spring_mvc_project_final.entities.FlightsEntity;
import com.mycompany.spring_mvc_project_final.service.*;
import com.mycompany.spring_mvc_project_final.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    FlightsRoutesService flightRouteService;

    @Autowired
    AirportService airportService;

    @Autowired
    FlightService flightsService;


    @Autowired
    BookingService bookingService;

    @Autowired
    BookingDetailService bookingDetailService;

    @Autowired
    ServiceService serviceService;

    @Autowired
    UserDetailsServiceImpl userDetailsService;


    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("flights", new FlightsEntity());
        model.addAttribute("airports", airportService.findAll());
        return "index";
    }

    @RequestMapping(value = "/booking_history", method = RequestMethod.GET)
    public String bookingList(Model model, @RequestParam(name = "booking_number") String number) {
        if (bookingService.findByBookingNumber(number).isPresent()) {
            model.addAttribute("item", bookingService.findByBookingNumber(number).get());
            return "booking_history";
        } else return "redirect:index";
    }

    @RequestMapping(value = "/booking_details", method = RequestMethod.GET)
    public String bookingDetailList(Model model, @RequestParam(name = "id") int id) {
        model.addAttribute("listBookingDetail", bookingDetailService.findByBooking(bookingService.findById(id).get()));
        model.addAttribute("idBooking", id);
        return "booking_details";
    }
}
