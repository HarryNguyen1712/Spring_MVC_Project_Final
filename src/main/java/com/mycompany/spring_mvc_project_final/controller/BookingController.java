package com.mycompany.spring_mvc_project_final.controller;

import com.mycompany.spring_mvc_project_final.entities.*;
import com.mycompany.spring_mvc_project_final.enums.GenderEnum;
import com.mycompany.spring_mvc_project_final.model.Booking;
import com.mycompany.spring_mvc_project_final.model.FlightAndSeat;
import com.mycompany.spring_mvc_project_final.service.*;
import com.mycompany.spring_mvc_project_final.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@Scope("session")
public class BookingController {

    @Autowired
    Booking booking;

    @Autowired
    FlightService flightsService;

    @Autowired
    SeatService seatsService;

    @Autowired
    ServiceService serviceService;


    @Autowired
    FeeService feeService;

    @Autowired
    CreditCardService creditCardService;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @RequestMapping(value = "/booking", method = RequestMethod.GET)
    public String booking(Model model, @ModelAttribute(name = "flightAndSeat") FlightAndSeat flightAndSeat) {
        booking.setBooking(new BookingEntity());
        if (booking.getBooking().getBookingDetailEntity() == null) {
            booking.getBooking().setBookingDetailEntity(new ArrayList<>());
        }
        if (booking.getDepartSeatList() == null) {
            booking.setDepartSeatList(new ArrayList<>());
        }
        if (booking.getPayment() == null) {
            booking.setPayment(new PaymentEntity());
        }
        if (booking.getCreditCardEntity() == null) {
            booking.setCreditCardEntity(new CreditCardEntity());
        }
        booking.setFlightAndSeat(flightAndSeat);
        if (SecurityUtils.checkIfLogin()) {
            booking.addBookingInfo(userDetailsService.findByEmail(SecurityUtils.getUsername()));
        }
        booking.addBookingDetail();
        FlightsEntity departFlight = flightsService.findById(flightAndSeat.getDepartFlightId()).get();
        booking.setDepartFlight(departFlight);
        if (!flightAndSeat.ifRoundTrip()) {
            model.addAttribute("roundTrip", false);
        } else {
            if (booking.getReturnSeatList() == null) {
                booking.setReturnSeatList(new ArrayList<>());
            }
            FlightsEntity returnFlight = flightsService.findById(flightAndSeat.getReturnFlightId()).get();
            booking.setReturnFlight(returnFlight);
            model.addAttribute("roundTrip", true);
        }
        model.addAttribute("booking", booking);
        model.addAttribute("check", "depart");
        return "seat_booking";
    }

    @RequestMapping(value = "/returnSeatBooking", method = RequestMethod.GET)
    public String returnSeatBooking(Model model) {
        model.addAttribute("booking", booking);
        model.addAttribute("check", "return");
        return "seat_booking";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(Model model) {
        return "test";
    }

    @RequestMapping(value = "/seat_booking", method = RequestMethod.GET)
    public String seatBooking(Model model) {
        model.addAttribute("check", "depart");
        return "seat_booking";
    }

    @RequestMapping(value = "/checkSeat", method = RequestMethod.GET)
    @ResponseBody
    public boolean checkSeat(@RequestParam(name = "seatNumber") String seatNumber, @RequestParam(name = "flightId") String flightId, Model model, HttpSession session) {
        System.out.println("check: " + seatNumber);
        if (booking.checkSeat(seatNumber, flightId)){
            session.setAttribute("booking", booking);
            return true;
        }
        else return false;
    }

    @RequestMapping(value = "/uncheckSeat", method = RequestMethod.GET)
    @ResponseBody
    public void uncheckSeat(Model model, @RequestParam(name = "seatNumber") String seatNumber, @RequestParam(name = "flightId") String flightId, HttpSession session) {
        System.out.println("uncheck:" + seatNumber);
        booking.uncheckSeat(seatNumber, flightId);
        session.setAttribute("booking", booking);
    }


    @RequestMapping(value = "/passenger", method = RequestMethod.GET)
    public String passenger(Model model) {
        Booking booking1 = new Booking();
        booking1.setPassengersEntityList(new ArrayList<>());
        booking1.setBookingInfo(new UserEntity());
        model.addAttribute("book", booking1);
        /*model.addAttribute("booking", booking);*/
        model.addAttribute("genderList", GenderEnum.values());
        return "passenger";
    }

 /*   @RequestMapping(value = "/editPassenger", method = RequestMethod.GET)
    public String editPassenger(Model model) {
        model.addAttribute("book", booking.getPassengersEntityList());
        model.addAttribute("booking", booking);
        model.addAttribute("genderList", genderService.findAll());
        return "passenger";
    }*/

    @RequestMapping(value = "/savePassenger", method = RequestMethod.POST)
    public String savePassenger(Model model, @Valid @ModelAttribute(name = "book") Booking book, BindingResult result) {
        if (result.hasErrors()) {
            booking.setPassengersEntityList(book.getPassengersEntityList());
            booking.setBookingInfo(book.getBookingInfo());
         /*   model.addAttribute("booking", booking);*/
            model.addAttribute("genderList", GenderEnum.values());
        }
        booking.setPassengersEntityList(book.getPassengersEntityList());
        booking.addBookingInfo(book.getBookingInfo());
        booking.addInfoBookingDetail();
        booking.addToAircraftsSeatsList();
        model.addAttribute("booking", booking);
        model.addAttribute("serviceList", serviceService.findAll());
        model.addAttribute("check", "depart");
        return "service_booking";
    }

    @RequestMapping(value = "/service_booking", method = RequestMethod.GET)
    public String serviceBooking(Model model) {
        model.addAttribute("serviceList", serviceService.findAll());
        model.addAttribute("check", "depart");
        model.addAttribute("total", booking.totalPriceService());
        return "service_booking";
    }

    @RequestMapping(value = "/payment", method = RequestMethod.GET)
    public String doAddServiceBooking(Model model) throws Exception {
        model.addAttribute("fee", feeService.findAll());
        model.addAttribute("ticketAndSeatPrice", booking.totalTicketAndSeat());
        model.addAttribute("allPrice", booking.allPrice());
        model.addAttribute("departSeat", booking.getDepartAircraftSeatsList().get(0));
        if (booking.getFlightAndSeat().ifRoundTrip())
            model.addAttribute("returnSeat", booking.getReturnAircraftSeatsList().get(0));
        model.addAttribute("credit-card", booking.getCreditCardEntity());
        return "payment";
    }

    @RequestMapping(value = "/changeItemServiceQuantity", method = RequestMethod.GET)
    @ResponseBody
    public double changeItemServiceQuantity(Model model, @RequestParam(name = "seat_id") String seat_id,
                                            @RequestParam(name = "flightId") String flightId,
                                            @RequestParam(name = "serviceId") String serviceId,
                                            @RequestParam(name = "quantity") String quantity, HttpSession session) {
    /*    System.out.println("quantity: " + quantity);
        System.out.println("serviceId: " + serviceId);
        System.out.println("FlightId: " + flightId);
        System.out.println("IdenCode: " + idenCode);
        System.out.println();*/
        booking.changeItemServiceQuantity(serviceId, quantity, flightId, seat_id);
        return booking.totalPriceService();
    }

    @RequestMapping(value = "/returnServiceBooking", method = RequestMethod.GET)
    public String returnServiceBooking(Model model) {
        model.addAttribute("serviceList", serviceService.findAll());
        model.addAttribute("check", "return");
        return "service_booking";
    }

    @RequestMapping(value = "/addPromotion", method = RequestMethod.GET)
    @ResponseBody
    public String addPromotion(Model model, @RequestParam(name = "code") String code) throws Exception {
        if (booking.checkPromotion(code)) {
            model.addAttribute("ticketAndSeatPrice", booking.totalTicketAndSeat());
            model.addAttribute("allPrice", booking.allPrice());
            return "Success!!";
        } else return "Wrong Code!!";
    }

    @RequestMapping(value = "/checkPayment", method = RequestMethod.GET)
    public String addPayment(Model model, @ModelAttribute(name = "credit-card") CreditCardEntity creditCard) {
        System.out.println(creditCard.toString());
        int result = booking.checkCreditCard(creditCard);
        if (result == 1) {
            booking.endOfBooking();
            booking = new Booking();
            return "done";
        } else if (result == 0) {
            booking.setMessage("Not enough balance!!");
        } else {
            booking.setMessage("Wrong credit-card information!!");
        }
        booking.setCreditCardEntity(creditCard);
        return "redirect:payment";
    }
}
