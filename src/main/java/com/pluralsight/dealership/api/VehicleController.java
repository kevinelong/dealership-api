package com.pluralsight.dealership.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VehicleController {
    private VehicleRepository dao;
    @Autowired
    VehicleController(VehicleRepository dao){
        this.dao = dao;
    }
    @RequestMapping(path="/vehicle", method= RequestMethod.GET)
    public List<Vehicle> getVehicles(){
        return (List<Vehicle>) dao.findAll();
    }
}
