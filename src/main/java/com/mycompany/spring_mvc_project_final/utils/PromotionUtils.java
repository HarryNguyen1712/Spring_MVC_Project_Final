package com.mycompany.spring_mvc_project_final.utils;

import com.mycompany.spring_mvc_project_final.entities.FlightsEntity;
import com.mycompany.spring_mvc_project_final.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;

public class PromotionUtils {

    public static void saveById(String[] string, FlightsEntity flightsEntity,PromotionService promotionService){
        for(String s: string){
            flightsEntity.getPromotionEntities().add(promotionService.findById(Integer.parseInt(s)).get());
        }
    }
}
