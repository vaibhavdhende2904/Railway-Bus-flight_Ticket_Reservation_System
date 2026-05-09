package com.example.ticketreservation.service;

import com.example.ticketreservation.entity.*;
import com.example.ticketreservation.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final RouteRepository routeRepository;
    private final UserRepository userRepository;

    public BookingService(BookingRepository bookingRepository,
                          RouteRepository routeRepository,
                          UserRepository userRepository) {
        this.bookingRepository = bookingRepository;
        this.routeRepository = routeRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public Booking bookTicket(Long userId, Long routeId, int seat, LocalDate date) {
        List<Booking> existing = bookingRepository.findByRouteIdAndJourneyDate(routeId, date);

        boolean seatTaken = existing.stream()
            .anyMatch(b -> b.getSeatNumber() == seat);

        if(seatTaken){
            throw new RuntimeException("Seat already booked");
        }

        Booking booking = new Booking();
        booking.setSeatNumber(seat);
        booking.setJourneyDate(date);
        booking.setPnr(UUID.randomUUID().toString().substring(0,8).toUpperCase());
        booking.setUser(userRepository.findById(userId).orElseThrow());
        booking.setRoute(routeRepository.findById(routeId).orElseThrow());

        return bookingRepository.save(booking);
    }
}