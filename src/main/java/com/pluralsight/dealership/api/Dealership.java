package com.pluralsight.dealership.api;

import jakarta.persistence.*;

@Entity
@Table(name = "dealerships")
public class Dealership {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long dealership_id;
    private String name;
    private String address;
    private String phone;

    Dealership() {
    }

    Dealership(String name,String address,String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public Long getDealership_id() {
        return dealership_id;
    }

    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public String getPhone() {
        return phone;
    }
}
