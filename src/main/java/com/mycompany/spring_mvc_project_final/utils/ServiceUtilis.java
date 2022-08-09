package com.mycompany.spring_mvc_project_final.utils;

import com.mycompany.spring_mvc_project_final.entities.BookingDetailEntity;
import com.mycompany.spring_mvc_project_final.entities.ServiceBookingEntity;
import com.mycompany.spring_mvc_project_final.entities.ServiceEntity;

public class ServiceUtilis {
    public static double priceService(BookingDetailEntity bookingDetailEntity){
        double total=0;
        if(bookingDetailEntity.getServiceBookingEntities() !=null){
            for(ServiceBookingEntity serviceBooking: bookingDetailEntity.getServiceBookingEntities()){
                total +=serviceBooking.getQuantity() * serviceBooking.getServiceEntity().getPrice();
            }
        }
        return total;
    }

}
