package com.mycompany.spring_mvc_project_final.utils;


import com.mycompany.spring_mvc_project_final.entities.AircraftsEntity;
import com.mycompany.spring_mvc_project_final.entities.BookingDetailEntity;
import com.mycompany.spring_mvc_project_final.entities.ServiceBookingEntity;
import com.mycompany.spring_mvc_project_final.enums.AircrartsStatusEnum;
import com.mycompany.spring_mvc_project_final.enums.BookingStatusEnum;
import com.mycompany.spring_mvc_project_final.service.ServiceService;

import java.util.List;

public class BookingDetailUtilis {
    public static void changeService(BookingDetailEntity bookingDetailEntity, List<ServiceBookingEntity> serviceBookingEntities, ServiceService serviceService) {
        serviceBookingEntities.removeIf((temp)->(temp.getQuantity() == 0));
        for (ServiceBookingEntity serviceBookingEntity : serviceBookingEntities) {
                serviceBookingEntity.setBookingDetailEntity(bookingDetailEntity);
                serviceBookingEntity.setServiceEntity(serviceService.findById(serviceBookingEntity.getServiceEntity().getId()).get());
        }
        bookingDetailEntity.setServiceBookingEntities(serviceBookingEntities);
    }

    public static void changeStatus(BookingDetailEntity bookingDetailEntity, String status){
        bookingDetailEntity.setBookingStatusEnum(BookingStatusEnum.valueOf(status));
    }
}
