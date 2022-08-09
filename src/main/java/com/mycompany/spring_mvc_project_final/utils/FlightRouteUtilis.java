package com.mycompany.spring_mvc_project_final.utils;

import com.mycompany.spring_mvc_project_final.entities.FlightRoutesEntity;

import java.time.Duration;

public class FlightRouteUtilis {
    public static FlightRoutesEntity addDuration(FlightRoutesEntity flightRoutesEntity, String test){
        System.out.println(test);
        String iso = test.replaceFirst("^(\\d{2}):(\\d{2}):(\\d{2})", "PT$1H$2M$3S");
        Duration d= Duration.parse(iso);
        System.out.println(d);
        flightRoutesEntity.setDuration(d);
        return flightRoutesEntity;
    }
}
