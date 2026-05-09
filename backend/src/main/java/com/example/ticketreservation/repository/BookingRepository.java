package com.example.ticketreservation.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ticketreservation.entity.Booking;
import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByRouteIdAndJourneyDate(Long routeId, LocalDate journeyDate);
}