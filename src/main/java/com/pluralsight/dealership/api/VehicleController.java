package com.pluralsight.dealership.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

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

    //Traditional HTML Form POST
    @PostMapping("/vehicle")
    @ResponseStatus(value = HttpStatus.CREATED)
    public RedirectView  createVehicle(@RequestParam String vin) {
        Vehicle vehicle = new Vehicle(vin);
        dao.save(vehicle);
        return new RedirectView("/");
    }


//    //JSON
//    @PostMapping("/vehicle")
//    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
//        return dao.save(vehicle);
//    }
}
