package com.mycompany.spring_mvc_project_final.configuration;

import com.mycompany.spring_mvc_project_final.model.Booking;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@Configuration
public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        System.out.println("session created");
        event.getSession().setMaxInactiveInterval(5*60);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        System.out.println("session destroyed");
        if (event.getSession().getAttribute("booking") != null) {
            Booking booking = (Booking) event.getSession().getAttribute("booking");
            System.out.println("test: " + booking.getQuantity());
            booking.getDepartSeatList().forEach(System.out::println);
            booking.setStatusForSeatAfterEndSeesion();
            System.out.println("session destroyed1");
        }
    }
}
