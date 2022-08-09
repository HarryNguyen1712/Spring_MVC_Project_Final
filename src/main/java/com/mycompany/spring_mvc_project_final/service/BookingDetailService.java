package com.mycompany.spring_mvc_project_final.service;

import com.mycompany.spring_mvc_project_final.entities.BookingDetailEntity;
import com.mycompany.spring_mvc_project_final.entities.BookingEntity;
import com.mycompany.spring_mvc_project_final.model.test;
import com.mycompany.spring_mvc_project_final.repository.BookingDetailRepository;
import com.mycompany.spring_mvc_project_final.utils.BookingDetailUtilis;
import com.mycompany.spring_mvc_project_final.utils.BookingUtilis;
import com.mycompany.spring_mvc_project_final.utils.ServiceUtilis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class BookingDetailService {
    @Autowired
    BookingDetailRepository bookingDetailRepository;

    @Autowired
    BookingService bookingService;

    @Autowired
    ServiceBookingService serviceBookingService;

    @Autowired
    ServiceService serviceService;

    @Autowired
    CreditCardService creditCardService;

    public Optional<BookingDetailEntity> findById(int id){
        return bookingDetailRepository.findById(id);
    }
    public Iterable<BookingDetailEntity> findByBooking(BookingEntity bookingEntity){
        return bookingDetailRepository.findByBookingEntity( bookingEntity);
    }

    @Transactional(rollbackFor = Exception.class)
    public void save(BookingDetailEntity bookingDetailEntity,String id,test test){
        try {
            BookingEntity bookingEntity = bookingService.findById(Integer.parseInt(id)).get();
            double startPrice = ServiceUtilis.priceService(bookingDetailEntity);
            serviceBookingService.deleteById(bookingDetailEntity);
            BookingDetailUtilis.changeService(bookingDetailEntity, test.getServiceBookingEntities(), serviceService);
            double laterPrice = ServiceUtilis.priceService(bookingDetailEntity);
            BookingUtilis.amountPayment(bookingEntity, bookingService, creditCardService, startPrice, laterPrice);
            bookingDetailRepository.save(bookingDetailEntity);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    public void save(BookingDetailEntity bookingDetailEntity){
        bookingDetailRepository.save(bookingDetailEntity);
    }

}
