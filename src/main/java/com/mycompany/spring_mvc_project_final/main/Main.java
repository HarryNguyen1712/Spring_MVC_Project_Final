/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_project_final.main;

import com.mycompany.spring_mvc_project_final.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author ASUS
 */
public class Main {
    @Autowired
    static
    PromotionService promotionService;


    public static void main(String[] args) throws ParseException,Exception {
        testConnection();
        System.out.println("password===>" + encrytePassword("manager"));
        LocalDateTime from = LocalDateTime.of(LocalDate.parse("2022-04-03", DateTimeFormatter.ofPattern("yyyy-MM-dd")),LocalTime.parse("23:20:20",DateTimeFormatter.ofPattern("HH:mm:ss")));
        LocalDateTime to = LocalDateTime.of(LocalDate.parse("2022-04-05", DateTimeFormatter.ofPattern("yyyy-MM-dd")),LocalTime.parse("23:30:30",DateTimeFormatter.ofPattern("HH:mm:ss")));
        Duration duration = Duration.between(from, to);


        System.out.println("ssssss"+duration);
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

        /*String abc = "12345n";

        SeatStatusEnum test = SeatStatusEnum.AVAILABLE;

        if (test.toString().equals("AVAILABLE")){
            System.out.println("true");
        }*/

    /*    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(LocalDate.now().toString());
        System.out.println(date);*/

        LocalDateTime dateTime = LocalDateTime.now().plusDays(1);
        System.out.println(dateTime);
        LocalDateTime dateTime1 = LocalDateTime.of(LocalDate.now(),LocalTime.now());
        LocalTime time = LocalTime.now().plusHours(23);
        System.out.println(time.atDate(LocalDate.now()));
    }

    public static String getCharForNumber(int i) {
        return i > 0 && i < 27 ? String.valueOf((char)(i + 'A' - 1)) : null;
    }

    public static String encrytePassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
    public static void testConnection() throws Exception{
        try{
            String url="jdbc:oracle:thin:@localhost:1521:orcl1";
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn= DriverManager.getConnection(url,"speedy","speedy");
            System.out.printf("ok");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
