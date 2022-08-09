package com.mycompany.spring_mvc_project_final.utils;


import com.mycompany.spring_mvc_project_final.entities.AircraftsEntity;
import com.mycompany.spring_mvc_project_final.entities.FlightsEntity;
import com.mycompany.spring_mvc_project_final.enums.AircrartsStatusEnum;

import java.util.List;

public class AircraftUtils {
    public static void changeStatus(AircraftsEntity aircraftsEntity,String status){
        aircraftsEntity.setAircraftStatus(AircrartsStatusEnum.valueOf(status));
    }

    public static boolean checkAircraft(FlightsEntity flightsEntity, List<FlightsEntity> flightsEntityList){
        for(FlightsEntity entity:flightsEntityList){
            if(flightsEntity.getAircraft().getId()==entity.getAircraft().getId()){
                return false;
            }
        }
        return true;
    }
}
