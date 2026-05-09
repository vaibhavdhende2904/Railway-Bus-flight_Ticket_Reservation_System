package com.example.ticketreservation.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Route {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String source;
    private String destination;
    private double price;
    private LocalDateTime departureTime;

    @ManyToOne
    private Vehicle vehicle;

    public Long getId(){ return id; }
    public void setId(Long id){ this.id=id; }
    public String getSource(){ return source; }
    public void setSource(String source){ this.source=source; }
    public String getDestination(){ return destination; }
    public void setDestination(String destination){ this.destination=destination; }
    public double getPrice(){ return price; }
    public void setPrice(double price){ this.price=price; }
    public LocalDateTime getDepartureTime(){ return departureTime; }
    public void setDepartureTime(LocalDateTime departureTime){ this.departureTime=departureTime; }
    public Vehicle getVehicle(){ return vehicle; }
    public void setVehicle(Vehicle vehicle){ this.vehicle=vehicle; }
}