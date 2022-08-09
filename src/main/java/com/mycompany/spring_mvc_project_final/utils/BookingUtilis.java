package com.mycompany.spring_mvc_project_final.utils;

import com.mycompany.spring_mvc_project_final.entities.BookingDetailEntity;
import com.mycompany.spring_mvc_project_final.entities.BookingEntity;
import com.mycompany.spring_mvc_project_final.entities.PaymentEntity;
import com.mycompany.spring_mvc_project_final.service.BookingService;
import com.mycompany.spring_mvc_project_final.service.CreditCardService;
import com.mycompany.spring_mvc_project_final.service.PaymentService;

import java.util.List;

public class BookingUtilis {
    public static void amountPayment(BookingEntity bookingEntity, BookingService bookingService, CreditCardService creditCardService, double startPrice, double laterPrice){
        double amount= bookingEntity.getPaymentEntity().getAmount() - startPrice;
        double amount2= amount +laterPrice;
        double diff= bookingEntity.getPaymentEntity().getAmount()-amount2;
        bookingEntity.getPaymentEntity().setCreditCardEntity(CreditCardUtilis.changeAmount(bookingEntity.getPaymentEntity().getCreditCardEntity(),creditCardService,diff));
        bookingEntity.getPaymentEntity().setAmount(amount2);
        bookingService.save(bookingEntity);
    }
    public static long orders(BookingService bookingService){
        List<BookingEntity> bookingEntityList= (List<BookingEntity>) bookingService.findAll(null, null);
        return bookingEntityList.size();
    }
    public static double total(PaymentService paymentService){
        return paymentService.total();
    }
}
