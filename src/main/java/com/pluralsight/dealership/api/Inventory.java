package com.pluralsight.dealership.api;

import jakarta.persistence.*;

@Entity
@Table(name = "inventory")
public class Inventory {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long inventory_id;

    private Long dealership_id;
    private Long vehicle_id;

    Inventory() {
    }

    public Long getInventory_id() {
        return inventory_id;
    }
    public Long getDealership_id() {
        return dealership_id;
    }
    public Long getVehicle_id() {
        return vehicle_id;
    }

}
