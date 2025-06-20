package com.pluralsight.dealership.api;

import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Use controller not rest controller if you want to support redirects
@RestController
public class DealershipController {
    private DealershipRepository dao;

    @Autowired
    DealershipController(DealershipRepository dao) {
        this.dao = dao;
    }

    //READ ALL
    //@RequestMapping(path = "/vehicle", method = RequestMethod.GET)
    @GetMapping("/dealership")
    public List<Dealership> getDealership() {
        return (List<Dealership>) dao.findAll();
    }

    //CREATE
    //JSON form post uses @RequestBody
    @PostMapping("/dealership")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Dealership createDealership(@RequestBody Dealership dealership) {
        return dao.save(dealership);
    }

    //UPDATE BY ID
    @RequestMapping(path="/dealership/{id}",method=RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.FOUND)
    public Dealership updateDealership (@PathVariable long id, @RequestBody Dealership dealership)
    {
        return dao.save(dealership);
    }

    //GET BY ID
    @RequestMapping(path="/dealership/{id}",method=RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.FOUND)
    public Dealership findDealership (@PathVariable long id)
    {
        return dao.findById(id);
    }

    //DELETE BY ID
    @RequestMapping(path="/dealership/{id}",method=RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteDealership (@PathVariable Long id)
    {
        dao.deleteById(id);
    }
}
