package com.pluralsight.dealership.api;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "sales_contracts")
public class SalesContract {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long sales_contracts_id;
    private String customer_name;
    private Long dealership_id;
    private Long vehicle_id;
    private Date when_sold;
    private Double monthly_payment;
    private Double total_price;

    SalesContract() {
    }

    public Long getSales_contracts_id() {
        return sales_contracts_id;
    }
    public String getCustomer_name() {
        return customer_name;
    }
    public Long getDealership_id() {
        return dealership_id;
    }
    public Long getVehicle_id() {
        return vehicle_id;
    }
    public Date getWhen_sold() {
        return when_sold;
    }
    public Double getMonthly_payment() {
        return monthly_payment;
    }
    public Double getTotal_price() {
        return total_price;
    }

}
