package com.example.ticketreservation.controller;

import com.example.ticketreservation.entity.Route;
import com.example.ticketreservation.repository.RouteRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/routes")
@CrossOrigin("*")
public class RouteController {

    private final RouteRepository repository;

    public RouteController(RouteRepository repository){
        this.repository = repository;
    }

    @GetMapping("/search")
    public List<Route> search(@RequestParam String source,
                              @RequestParam String destination){
        return repository.findBySourceAndDestination(source, destination);
    }

    @PostMapping
    public Route addRoute(@RequestBody Route route){
        return repository.save(route);
    }
}