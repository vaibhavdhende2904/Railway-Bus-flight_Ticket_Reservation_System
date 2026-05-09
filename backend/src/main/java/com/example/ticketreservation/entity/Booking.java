package com.example.ticketreservation.entity;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Booking {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pnr;
    private int seatNumber;
    private LocalDate journeyDate;

    @ManyToOne
    private User user;

    @ManyToOne
    private Route route;

    public Long getId(){ return id; }
    public void setId(Long id){ this.id=id; }
    public String getPnr(){ return pnr; }
    public void setPnr(String pnr){ this.pnr=pnr; }
    public int getSeatNumber(){ return seatNumber; }
    public void setSeatNumber(int seatNumber){ this.seatNumber=seatNumber; }
    public LocalDate getJourneyDate(){ return journeyDate; }
    public void setJourneyDate(LocalDate journeyDate){ this.journeyDate=journeyDate; }
    public User getUser(){ return user; }
    public void setUser(User user){ this.user=user; }
    public Route getRoute(){ return route; }
    public void setRoute(Route route){ this.route=route; }
}