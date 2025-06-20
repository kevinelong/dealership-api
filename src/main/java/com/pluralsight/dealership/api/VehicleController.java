package com.pluralsight.dealership.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

//Use controller not rest controller if you want to support redirects
@RestController
public class VehicleController {
    private VehicleRepository dao;

    @Autowired
    VehicleController(VehicleRepository dao) {
        this.dao = dao;
    }

    //READ ALL
    //@RequestMapping(path = "/vehicle", method = RequestMethod.GET)
    @GetMapping("/vehicle")
    public List<Vehicle> getVehicles() {
        return (List<Vehicle>) dao.findAll();
    }

    @GetMapping("/vehicle/color/{color}")
    public List<Vehicle> getVehicleByColor(@PathVariable String color) {

        return (List<Vehicle>) dao.findByColor(color);
    }

    //CREATE
    //JSON form post uses @RequestBody
    @PostMapping("/vehicle")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
        return dao.save(vehicle);
    }

    //UPDATE BY ID
    @RequestMapping(path="/vehicle/{id}",method=RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.FOUND)
    public Vehicle updateVehicle (@PathVariable long id, @RequestBody Vehicle vehicle)
    {
        return dao.save(vehicle);
    }

    //GET BY ID
    @RequestMapping(path="/vehicle/{id}",method=RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.FOUND)
    public Vehicle findVehicle (@PathVariable long id)
    {
        return dao.findById(id);
    }

    //DELETE BY ID
    @RequestMapping(path="/vehicle/{id}",method=RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteVehicle (@PathVariable Long id)
    {
        dao.deleteById(id);
    }
}
