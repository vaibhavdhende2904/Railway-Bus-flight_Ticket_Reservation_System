package com.example.ticketreservation.entity;
import jakarta.persistence.*;

@Entity
public class Vehicle {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private int seatCapacity;

    public Long getId(){ return id; }
    public void setId(Long id){ this.id=id; }
    public String getName(){ return name; }
    public void setName(String name){ this.name=name; }
    public String getType(){ return type; }
    public void setType(String type){ this.type=type; }
    public int getSeatCapacity(){ return seatCapacity; }
    public void setSeatCapacity(int seatCapacity){ this.seatCapacity=seatCapacity; }
}