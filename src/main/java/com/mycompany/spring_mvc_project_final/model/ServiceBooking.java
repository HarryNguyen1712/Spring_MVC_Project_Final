package com.mycompany.spring_mvc_project_final.model;

import com.mycompany.spring_mvc_project_final.entities.ServiceEntity;

public class ServiceBooking {

    private ServiceEntity serviceEntity;

    private int quantity;

    public ServiceBooking() {
    }

    public ServiceEntity getServiceEntity() {
        return serviceEntity;
    }

    public void setServiceEntity(ServiceEntity serviceEntity) {
        this.serviceEntity = serviceEntity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void plusQuantity(){
        quantity = quantity + 1;
    }

}
