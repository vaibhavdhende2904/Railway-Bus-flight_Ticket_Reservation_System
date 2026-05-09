//package com.example.ticketreservation.controller;
//
//import com.example.ticketreservation.entity.Booking;
//import com.example.ticketreservation.repository.BookingRepository;
//import com.example.ticketreservation.service.BookingService;
//import org.springframework.web.bind.annotation.*;
//import java.time.LocalDate;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/bookings")
//@CrossOrigin("*")
//public class BookingController {
//
//    private final BookingService bookingService;
//    private final BookingRepository bookingRepository;
//
//    public BookingController(BookingService bookingService,
//            BookingRepository bookingRepository){
//this.bookingService = bookingService;
//this.bookingRepository = bookingRepository;
//
//}
//
//    @PostMapping
//    public Booking book(@RequestBody Map<String, String> body){
//        return bookingService.bookTicket(
//            Long.parseLong(body.get("userId")),
//            Long.parseLong(body.get("routeId")),
//            Integer.parseInt(body.get("seat")),
//            LocalDate.parse(body.get("date"))
//        );
//    }
//    
//}


package com.example.ticketreservation.controller;

import com.example.ticketreservation.entity.Booking;
import com.example.ticketreservation.repository.BookingRepository;
import com.example.ticketreservation.service.BookingService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin("*")
public class BookingController {

    private final BookingService bookingService;
    private final BookingRepository bookingRepository;

    public BookingController(BookingService bookingService,
                             BookingRepository bookingRepository) {
        this.bookingService = bookingService;
        this.bookingRepository = bookingRepository;
    }

    // CREATE BOOKING
    @PostMapping
    public Booking book(@RequestBody Map<String, String> body) {
        return bookingService.bookTicket(
                Long.parseLong(body.get("userId")),
                Long.parseLong(body.get("routeId")),
                Integer.parseInt(body.get("seat")),
                LocalDate.parse(body.get("date"))
        );
    }

    // GET ALL BOOKINGS
    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
    //Delete booking
    @DeleteMapping("/{id}")
    public String cancelTicket(@PathVariable Long id){
        bookingRepository.deleteById(id);
        return "Ticket Cancelled Successfully";
    }
    //update ticket
    @PutMapping("/{id}")
    public Booking updateBooking(@PathVariable Long id,
                                 @RequestBody Booking updatedBooking){

        Booking booking = bookingRepository.findById(id)
                .orElseThrow();

        booking.setSeatNumber(updatedBooking.getSeatNumber());
        booking.setJourneyDate(updatedBooking.getJourneyDate());

        return bookingRepository.save(booking);
    }
}