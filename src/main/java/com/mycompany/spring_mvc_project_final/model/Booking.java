package com.mycompany.spring_mvc_project_final.model;

import com.mycompany.spring_mvc_project_final.entities.*;
import com.mycompany.spring_mvc_project_final.enums.BookingStatusEnum;
import com.mycompany.spring_mvc_project_final.enums.SeatStatusEnum;
import com.mycompany.spring_mvc_project_final.service.*;
import com.mycompany.spring_mvc_project_final.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
@Scope("session")
public class Booking {


    @Autowired
    ServiceService serviceService;

    @Autowired
    SeatService seatsService;

    @Autowired
    PromotionService promotionService;

    @Autowired
    AircraftSeatService aircraftSeatsService;

    @Autowired
    FeeService feeService;

    @Autowired
    CreditCardService creditCardService;

    @Autowired
    BookingService bookingService;

    @Autowired
    JavaMailSender mailSender;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    private BookingEntity booking;

    private List<ServiceBooking> serviceDepart;

    private List<ServiceBooking> serviceReturn;

    private List<PassengersEntity> passengersEntityList;

    private FlightsEntity departFlight;

    private FlightsEntity returnFlight;

    private int quantity;

    private String[] selectedSeat;

    private List<String> departSeatList;

    private List<String> returnSeatList;

    private List<AircraftSeatsEntity> departAircraftSeatsList;

    private List<AircraftSeatsEntity> returnAircraftSeatsList;

    private FlightAndSeat flightAndSeat;

    private PromotionEntity promotion;

    private PaymentEntity payment;

    private CreditCardEntity creditCardEntity;

    private String message;

    private UserEntity bookingInfo;

    public Booking() {
    }

    public BookingEntity getBooking() {
        return booking;
    }

    public void setBooking(BookingEntity booking) {
        this.booking = booking;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String[] getSelectedSeat() {
        return selectedSeat;
    }

    public void setSelectedSeat(String[] selectedSeat) {
        this.selectedSeat = selectedSeat;
    }

    public FlightAndSeat getFlightAndSeat() {
        return flightAndSeat;
    }

    public void setFlightAndSeat(FlightAndSeat flightAndSeat) {
        this.flightAndSeat = flightAndSeat;
    }

    public FlightsEntity getDepartFlight() {
        return departFlight;
    }

    public void setDepartFlight(FlightsEntity departFlight) {
        this.departFlight = departFlight;
    }

    public FlightsEntity getReturnFlight() {
        return returnFlight;
    }

    public void setReturnFlight(FlightsEntity returnFlight) {
        this.returnFlight = returnFlight;
    }


    public List<String> getDepartSeatList() {
        return departSeatList;
    }

    public void setDepartSeatList(List<String> departSeatList) {
        this.departSeatList = departSeatList;
    }

    public List<String> getReturnSeatList() {
        return returnSeatList;
    }

    public void setReturnSeatList(List<String> returnSeatList) {
        this.returnSeatList = returnSeatList;
    }

    public List<ServiceBooking> getServiceDepart() {
        return serviceDepart;
    }

    public void setServiceDepart(List<ServiceBooking> serviceDepart) {
        this.serviceDepart = serviceDepart;
    }

    public List<ServiceBooking> getServiceReturn() {
        return serviceReturn;
    }

    public void setServiceReturn(List<ServiceBooking> serviceReturn) {
        this.serviceReturn = serviceReturn;
    }

    public List<AircraftSeatsEntity> getDepartAircraftSeatsList() {
        return departAircraftSeatsList;
    }

    public void setDepartAircraftSeatsList(List<AircraftSeatsEntity> departAircraftSeatsList) {
        this.departAircraftSeatsList = departAircraftSeatsList;
    }

    public List<AircraftSeatsEntity> getReturnAircraftSeatsList() {
        return returnAircraftSeatsList;
    }

    public void setReturnAircraftSeatsList(List<AircraftSeatsEntity> returnAircraftSeatsList) {
        this.returnAircraftSeatsList = returnAircraftSeatsList;
    }

    public List<PassengersEntity> getPassengersEntityList() {
        return passengersEntityList;
    }

    public void setPassengersEntityList(List<PassengersEntity> passengersEntityList) {
        this.passengersEntityList = passengersEntityList;
    }

    public PromotionEntity getPromotion() {
        return promotion;
    }

    public void setPromotion(PromotionEntity promotion) {
        this.promotion = promotion;
    }

    public PaymentEntity getPayment() {
        return payment;
    }

    public void setPayment(PaymentEntity payment) {
        this.payment = payment;
    }

    public CreditCardEntity getCreditCardEntity() {
        return creditCardEntity;
    }

    public void setCreditCardEntity(CreditCardEntity creditCardEntity) {
        this.creditCardEntity = creditCardEntity;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserEntity getBookingInfo() {
        return bookingInfo;
    }

    public void setBookingInfo(UserEntity bookingInfo) {
        this.bookingInfo = bookingInfo;
    }

    public void addBookingInfo(UserEntity user) {
        booking.setGenderEnum(user.getGenderEnum());
        booking.setAddress(user.getAddress());
        booking.setBirthday(user.getBirthday());
        booking.setEmail(user.getEmail());
        booking.setFullName(user.getFullName());
        booking.setPhoneNumber(user.getPhoneNumber());
    }

    public void addBookingDetail() {
        int size = flightAndSeat.getQuantity();
        if (flightAndSeat.ifRoundTrip()) {
            size = size * 2;
        }
        for (int i = 0; i < size; i++) {
            booking.getBookingDetailEntity().add(new BookingDetailEntity());
        }
        /*   System.out.println("size: " + booking.getBookingDetailEntityList().size());*/
    }

    public void uncheckSeat(String seat, String flightId) {
        if (Integer.parseInt(flightId) == flightAndSeat.getDepartFlightId()) {
            departSeatList.remove(seat);
            /*    System.out.println("removeDepartSeat:" + seat);*/
            quantity = quantity - 1;
        } else {
            returnSeatList.remove(seat);
            /*           System.out.println("removeReturnSeat:" + seat);*/
        }
        AircraftSeatsEntity aircraftSeats = aircraftSeatsService.findByFlight_IdAndSeat_Number(Integer.parseInt(flightId), seat).get();
        setStatusForSeat(aircraftSeats, SeatStatusEnum.AVAILABLE);
    }

    public boolean checkIfSeatAvailable(String seat, int flightId) {
        return aircraftSeatsService.findByFlight_IdAndSeat_Number(flightId, seat).get().getSeatsStatus() == SeatStatusEnum.AVAILABLE;
    }

    public boolean checkSeat(String seat, String flightId) {
        if (checkIfSeatAvailable(seat, Integer.parseInt(flightId))) {
            if (Integer.parseInt(flightId) == flightAndSeat.getDepartFlightId()) {
                departSeatList.add(seat);
                /*     System.out.println("addDepartSeat:" + seat);*/
                quantity = quantity + 1;
            } else {
                returnSeatList.add(seat);
                /*      System.out.println("addReturnSeat:" + seat);*/
            }
            AircraftSeatsEntity aircraftSeats = aircraftSeatsService.findByFlight_IdAndSeat_Number(Integer.parseInt(flightId), seat).get();
            setStatusForSeat(aircraftSeats, SeatStatusEnum.PROCESSING);
            return true;
        } else return false;
        /*    System.out.println("flightId: " + flightId);*/
    }

    public void setStatusForSeat(AircraftSeatsEntity aircraftSeats, SeatStatusEnum seatStatusEnum) {
        aircraftSeats.setSeatsStatus(seatStatusEnum);
        aircraftSeatsService.save(aircraftSeats);
    }

    public void setStatusForSeatAfterEndSeesion() {
        if (departSeatList != null) {
            for (String seat : departSeatList) {
                AircraftSeatsEntity aircraftSeats = aircraftSeatsService.findByFlight_IdAndSeat_Number(departFlight.getId(), seat).get();
                setStatusForSeat(aircraftSeats, SeatStatusEnum.AVAILABLE);
            }
        }
        if (flightAndSeat.ifRoundTrip() && returnSeatList != null) {
            for (String seat : returnSeatList) {
                AircraftSeatsEntity aircraftSeats = aircraftSeatsService.findByFlight_IdAndSeat_Number(returnFlight.getId(), seat).get();
                setStatusForSeat(aircraftSeats, SeatStatusEnum.AVAILABLE);
            }
        }
    }

    public void addToAircraftsSeatsList() {
        departAircraftSeatsList = new ArrayList<>();
        for (String seat : departSeatList) {
            AircraftSeatsEntity aircraftSeats = aircraftSeatsService.findByFlight_IdAndSeat_Number(departFlight.getId(), seat).get();
            departAircraftSeatsList.add(aircraftSeats);
        }
        if (flightAndSeat.ifRoundTrip()) {
            returnAircraftSeatsList = new ArrayList<>();
            for (String seat : returnSeatList) {
                AircraftSeatsEntity aircraftSeats = aircraftSeatsService.findByFlight_IdAndSeat_Number(returnFlight.getId(), seat).get();
                returnAircraftSeatsList.add(aircraftSeats);
            }
        }
    }


    public void addInfoBookingDetail() {
        int temp = booking.getBookingDetailEntity().size();
        for (int i = 0; i < booking.getBookingDetailEntity().size(); i++) {
            if (!flightAndSeat.ifRoundTrip()) {
                booking.getBookingDetailEntity().get(i).setFlightsEntity(departFlight);
                booking.getBookingDetailEntity().get(i).setPassengersEntity(passengersEntityList.get(i));
                booking.getBookingDetailEntity().get(i).setSeatsEntity(seatsService.findByName(departSeatList.get(i)).get());
            } else {
                if (i < temp / 2) {
                    booking.getBookingDetailEntity().get(i).setFlightsEntity(departFlight);
                    booking.getBookingDetailEntity().get(i).setPassengersEntity(passengersEntityList.get(i));
                    booking.getBookingDetailEntity().get(i).setSeatsEntity(seatsService.findByName(departSeatList.get(i)).get());
                    /* addSeat(departSeatList.get(i), passengersEntityList.get(i).getIdenCode());*/
                } else {
                    booking.getBookingDetailEntity().get(i).setFlightsEntity(returnFlight);
                    booking.getBookingDetailEntity().get(i).setPassengersEntity(passengersEntityList.get(i - temp / 2));
                    booking.getBookingDetailEntity().get(i).setSeatsEntity(seatsService.findByName(returnSeatList.get(i - temp / 2)).get());
                    /*addSeat(returnSeatList.get(i - temp / 2), passengersEntityList.get(i - temp).getIdenCode());*/
                }
            }
        }
    }


    public void changeItemServiceQuantity(String serviceId, String quantityService, String flightId, String seat_id) {
        int id = Integer.parseInt(serviceId);
        int quantity = Integer.parseInt(quantityService);
        int flight = Integer.parseInt(flightId);
        int seatId = Integer.parseInt(seat_id);
        boolean checkIfExist = false;
        ServiceBookingEntity serviceBooking = new ServiceBookingEntity();
        serviceBooking.setServiceEntity(serviceService.findById(id).get());
        serviceBooking.setQuantity(quantity);
        for (BookingDetailEntity bookingDetail : booking.getBookingDetailEntity()) {
            if (bookingDetail.getSeatsEntity().getId() == seatId && bookingDetail.getFlightsEntity().getId() == flight) {
                serviceBooking.setBookingDetailEntity(bookingDetail);
                if (bookingDetail.getServiceBookingEntities() == null) {
                    if (quantity != 0) {
                        bookingDetail.setServiceBookingEntities(new ArrayList<>());
                        bookingDetail.getServiceBookingEntities().add(serviceBooking);
                    }
                } else {
                    for (ServiceBookingEntity value : bookingDetail.getServiceBookingEntities()) {
                        if (value.getServiceEntity().getId() == id) {
                            checkIfExist = true;
                            value.setQuantity(quantity);
                            break;
                        }
                    }
                    bookingDetail.getServiceBookingEntities().removeIf(value -> value.getQuantity() == 0);
                    if (!checkIfExist) {
                        bookingDetail.getServiceBookingEntities().add(serviceBooking);
                    }
                }
                break;
            }
        }
    }

    public double priceService(BookingDetailEntity bookingDetail) {
        double total = 0;
        if (bookingDetail.getServiceBookingEntities() != null) {
            for (ServiceBookingEntity serviceBooking : bookingDetail.getServiceBookingEntities()) {
                total += serviceBooking.getQuantity() * serviceBooking.getServiceEntity().getPrice();
            }
        }
        return total;
    }

    public double totalPriceService() {
        double total = 0;
        for (BookingDetailEntity bookingDetail : booking.getBookingDetailEntity()) {
            if (bookingDetail.getServiceBookingEntities() != null) {
                for (ServiceBookingEntity serviceBooking : bookingDetail.getServiceBookingEntities()) {
                    total = total + serviceBooking.getServiceEntity().getPrice() * serviceBooking.getQuantity();
                }
            }
        }
        return total;
    }

    public double totalTicketPrice() {
        double total = 0;
        for (BookingDetailEntity bookingDetail : booking.getBookingDetailEntity()) {
            total += bookingDetail.getFlightsEntity().getFlightRoute().getStandardPrice() * (1 - bookingDetail.getDiscount() / (double) 100);
        }
        return total;
    }

    public double totalSeatPrice() {
        double total = 0;
        for (AircraftSeatsEntity aircraftSeats : departAircraftSeatsList) {
            total = total + aircraftSeats.getPrice();
        }
        if (flightAndSeat.ifRoundTrip()) {
            for (AircraftSeatsEntity aircraftSeats : returnAircraftSeatsList)
                total = total + aircraftSeats.getPrice();
        }
        return total;
    }

    public double otherFee() {
        double total = 0;
        for (FeeAndCarrierChargesEntity fee : feeService.findAll()) {
            if (!fee.getName().equals("tax"))
                total += fee.getPrice();
        }
        return total;
    }

    public double totalTicketAndSeat() {
        double total = 0;
        total = (totalTicketPrice() + totalSeatPrice());
        return total;
    }

    public void unitPriceForBookingDetail(BookingDetailEntity bookingDetail, AircraftSeatsEntity aircraftSeats) throws Exception {
        double total = 0;
        total = bookingDetail.getFlightsEntity().getFlightRoute().getStandardPrice() * (1 + (feeService.findByName("tax").get().getPrice() - bookingDetail.getDiscount()) / (double) 100) + priceService(bookingDetail)
                + aircraftSeats.getPrice() + otherFee();
        bookingDetail.setUnitPrice(total);
    }

    public double allPrice() throws Exception {
        double total = 0;
        int size = booking.getBookingDetailEntity().size();
        for (int i = 0; i < booking.getBookingDetailEntity().size(); i++) {
            if (!flightAndSeat.ifRoundTrip() || i < (size / 2)) {
                unitPriceForBookingDetail(booking.getBookingDetailEntity().get(i), departAircraftSeatsList.get(i));
            } else {
                unitPriceForBookingDetail(booking.getBookingDetailEntity().get(i), returnAircraftSeatsList.get(i - size / 2));
            }
            total = total + booking.getBookingDetailEntity().get(i).getUnitPrice();
        }
        payment.setAmount(total);
        return total;
    }

    public boolean checkPromotion(String name) {
        boolean check = false;
        Optional<PromotionEntity> temp = promotionService.findByName(name);
        int size = booking.getBookingDetailEntity().size();
        if (temp.isPresent()) {
            if (temp.get().getStartDate().isBefore(LocalDate.now()) && temp.get().getEndDate().isAfter(LocalDate.now())) {
                for (int i = 0; i < size; i++) {
                    if (!flightAndSeat.ifRoundTrip() || i < (size / 2)) {
                        for (PromotionEntity promotionEntity : departFlight.getPromotionEntities()) {
                            if (promotionEntity.getId() == temp.get().getId()) {
                                booking.getBookingDetailEntity().get(i).setDiscount(temp.get().getDiscount());
                                check = true;
                                break;
                            }
                        }
                    } else {
                        for (PromotionEntity promotionEntity : returnFlight.getPromotionEntities()) {
                            if (promotionEntity.getId() == temp.get().getId()) {
                                booking.getBookingDetailEntity().get(i).setDiscount(temp.get().getDiscount());
                                check = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return check;
    }

    public int checkCreditCard(CreditCardEntity creditCard) {
        int temp = -1;
        for (CreditCardEntity cardEntity : creditCardService.findAll()) {
            if (cardEntity.equals(creditCard)) {
                if (cardEntity.getBalance() >= payment.getAmount()) {
                    temp = 1;
                    creditCardEntity = cardEntity;
                    System.out.println("amount" + payment.getAmount());
                    creditCardEntity.setBalance(cardEntity.getBalance() - payment.getAmount());
                } else {
                    temp = 0;
                }
                break;
            }
        }
        return temp;
    }

    public void doSendEmail() {
        StringBuilder text = new StringBuilder();
        text.append("Booking Number: ").append(booking.getBookingNumber()).append("\n")
                .append("Booking Date: ").append(booking.getBookingDate()).append("\n")
                .append("Depart Route: ").append(departFlight.getFlightRoute().getDepartureAirport().getName()).append("->")
                .append(departFlight.getFlightRoute().getDestinationAirport().getName()).append("\n")
                .append("Depart Date: ").append(departFlight.getDeparture()).append(" .Depart time: ").append(departFlight.getDepartureTime()).append("\n")
                .append("Seat: ").append(departSeatList.toString()).append("\n");
        if (flightAndSeat.ifRoundTrip()) {
            text.append("Return Route: ").append(returnFlight.getFlightRoute().getDepartureAirport().getName()).append("->")
                    .append(returnFlight.getFlightRoute().getDestinationAirport().getName()).append("\n")
                    .append("Return Date: ").append(returnFlight.getDeparture()).append(" .Return time: ").append(returnFlight.getDepartureTime()).append("\n")
                    .append("Seat: ").append(returnSeatList.toString()).append("\n");
        }
        if (SecurityUtils.getUsername() != null && !Objects.equals(SecurityUtils.getUsername(), "")) {
            UserEntity user = userDetailsService.findByEmail(SecurityUtils.getUsername());
            text.append("For more Information -->").append("http://localhost:8080/Spring_MVC_Project_Final_war_exploded/booking_history?booking_number=").append(booking.getBookingNumber()).append("\n");
        }
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(booking.getEmail());
        email.setSubject("Booking Information");
        email.setText(text.toString());
        mailSender.send(email);
    }

    @Transactional(rollbackFor = Exception.class)
    public void endOfBooking() {
        try {
            booking.setBookingDate(LocalDate.now());
            long number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
            int luggage = 7;
            List<String> ListNumber = bookingService.findAllBookingNumber();
            for (String s : ListNumber) {
                if (Long.toString(number).equals(s))
                    number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
            }
            for (BookingDetailEntity bookingDetail : booking.getBookingDetailEntity()) {
                bookingDetail.setBookingStatusEnum(BookingStatusEnum.BOOKED);
                if (bookingDetail.getServiceBookingEntities() != null) {
                    for (ServiceBookingEntity bookingService : bookingDetail.getServiceBookingEntities()) {
                        if (bookingService.getServiceEntity().getId() == 1) {
                            luggage += 10 * bookingService.getQuantity();
                        }
                    }
                }
            }
            payment.setCreditCardEntity(creditCardEntity);
            creditCardService.save(creditCardEntity);
            payment.setPaymentDate(LocalDate.now());
            payment.setBookingEntity(booking);
            booking.setBookingNumber(Long.toString(number));
            booking.setLuggage(luggage);
            booking.setPaymentEntity(payment);
            departAircraftSeatsList.forEach((temp) -> {
                temp.setSeatsStatus(SeatStatusEnum.RESERVED);
                aircraftSeatsService.save(temp);
            });
            if (flightAndSeat.ifRoundTrip())
                returnAircraftSeatsList.forEach((temp) -> {
                    temp.setSeatsStatus(SeatStatusEnum.RESERVED);
                    aircraftSeatsService.save(temp);
                });
            booking.getBookingDetailEntity().forEach((n) -> n.setBookingEntity(booking));
            bookingService.save(booking);
            doSendEmail();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
