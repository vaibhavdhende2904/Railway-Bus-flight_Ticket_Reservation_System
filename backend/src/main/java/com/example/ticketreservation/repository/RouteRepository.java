package com.example.ticketreservation.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ticketreservation.entity.Route;
import java.util.List;

public interface RouteRepository extends JpaRepository<Route, Long> {
    List<Route> findBySourceAndDestination(String source, String destination);
}