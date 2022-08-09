package com.mycompany.spring_mvc_project_final.model;

import com.mycompany.spring_mvc_project_final.entities.ServiceBookingEntity;

import java.util.List;

public class test {
    private List<ServiceBookingEntity> serviceBookingEntities;

    public test() {
    }

    public List<ServiceBookingEntity> getServiceBookingEntities() {
        return serviceBookingEntities;
    }

    public void setServiceBookingEntities(List<ServiceBookingEntity> serviceBookingEntities) {
        this.serviceBookingEntities = serviceBookingEntities;
    }
}
