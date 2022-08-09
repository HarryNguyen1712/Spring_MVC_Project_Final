/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_project_final.main;

import com.mycompany.spring_mvc_project_final.entities.BookingEntity;
import com.mycompany.spring_mvc_project_final.entities.PromotionEntity;
import com.mycompany.spring_mvc_project_final.enums.SeatStatusEnum;
import com.mycompany.spring_mvc_project_final.service.PromotionService;

import com.mycompany.spring_mvc_project_final.utils.FlightUtilis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class Main {
    @Autowired
    static
    PromotionService promotionService;


    public static void main(String[] args) {
        System.out.println("password===>" + encrytePassword("manager"));
        LocalDateTime localDateTime= LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(localDateTime);
        System.out.println(timestamp);
        /*BookingEntity bookingEntity = new BookingEntity();
        LocalDateTime from = LocalDateTime.of(LocalDate.parse("2022-04-03", DateTimeFormatter.ofPattern("yyyy-MM-dd")),LocalTime.parse("23:20",DateTimeFormatter.ofPattern("HH:mm")));
        LocalDateTime to = LocalDateTime.of(LocalDate.parse("2022-04-06", DateTimeFormatter.ofPattern("yyyy-MM-dd")),LocalTime.parse("23:30",DateTimeFormatter.ofPattern("HH:mm")));
        Duration duration = Duration.between(from, to);
        System.out.println("test:"+ duration.toHours());
        LocalDateTime time = FlightUtilis.arrivalDateTime(LocalDate.parse("2022-04-03", DateTimeFormatter.ofPattern("yyyy-MM-dd")), LocalTime.parse("23:20",DateTimeFormatter.ofPattern("HH:mm")), Duration.ofHours(2));
        System.out.println(time);
        System.out.println();
        LocalDate date= time.toLocalDate();
        LocalTime time1=time.toLocalTime();
        System.out.println(date);
        System.out.println(time1);
        System.out.println(getCharForNumber(12));*/

        String abc = "12345n";

        SeatStatusEnum test = SeatStatusEnum.AVAILABLE;

        if (test.toString().equals("AVAILABLE")){
            System.out.println("true");
        }


    }

    public static String getCharForNumber(int i) {
        return i > 0 && i < 27 ? String.valueOf((char)(i + 'A' - 1)) : null;
    }

    public static String encrytePassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}
