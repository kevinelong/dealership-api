package com.pluralsight.dealership.api;

import jakarta.persistence.*;

@Entity
@Table(name="vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    private Long vehicle_id;
    private String vin;
}
