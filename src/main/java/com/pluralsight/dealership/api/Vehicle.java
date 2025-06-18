package com.pluralsight.dealership.api;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicles")
public class Vehicle {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long vehicle_id;

    private String vin;

    Vehicle(String vin) {
        this.vin = vin;
    }

    public Long getVehicle_id() {
        return vehicle_id;
    }

    public String getVin() {
        return vin;
    }
}
