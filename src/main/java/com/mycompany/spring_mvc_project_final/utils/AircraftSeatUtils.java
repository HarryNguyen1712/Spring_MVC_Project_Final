package com.mycompany.spring_mvc_project_final.utils;

import com.mycompany.spring_mvc_project_final.entities.AircraftSeatsEntity;
import com.mycompany.spring_mvc_project_final.enums.SeatTypeEnum;

public class AircraftSeatUtils {
    public static double price(String seatStatus){
        if(seatStatus.equals(SeatTypeEnum.ECONOMY.toString())){
            return 30;
        }
        else if(seatStatus.equals(SeatTypeEnum.BUSINESS.toString())){
            return 80;
        }
        else{
            return 50;
        }
    }
    public static AircraftSeatsEntity changeDetail(AircraftSeatsEntity aircraftSeatsEntity1,AircraftSeatsEntity aircraftSeatsEntity2){
        aircraftSeatsEntity1.setPrice(aircraftSeatsEntity2.getPrice());
        aircraftSeatsEntity1.setSeatsStatus(aircraftSeatsEntity2.getSeatsStatus());
        aircraftSeatsEntity1.setSeatsType(aircraftSeatsEntity2.getSeatsType());
        return aircraftSeatsEntity1;
    }
}
