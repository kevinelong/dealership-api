package com.pluralsight.dealership.api;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicles")
public class Vehicle {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long vehicle_id;
    private String vin;
    private String make;
    private String model;
    private Integer year;
    private String color;
    private Double price;
    Vehicle() {
    }

//    Vehicle(String vin) {
//        this.vin = vin;
//    }

    public Long getVehicle_id() {
        return vehicle_id;
    }

    public String getVin() {
        return vin;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public Integer getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }
    public Double getPrice() {
        return price;
    }
}
