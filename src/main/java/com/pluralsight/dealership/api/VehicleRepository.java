package com.pluralsight.dealership.api;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface VehicleRepository extends CrudRepository<Vehicle, Long> {

//    List<Vehicle> findByLastName(String lastName);


    Vehicle findById(long id);

    @Query(value="Select v.* from Vehicles v where v.color = :color", nativeQuery = true)
    Iterable<Vehicle> findByColor (String color);


}