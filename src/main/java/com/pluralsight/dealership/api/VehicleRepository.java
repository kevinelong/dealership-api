package com.pluralsight.dealership.api;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface VehicleRepository extends CrudRepository<Vehicle, Long> {

//    List<Vehicle> findByLastName(String lastName);

    Vehicle findById(long id);
}