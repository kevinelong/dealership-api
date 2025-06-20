package com.pluralsight.dealership.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//Use controller not rest controller if you want to support redirects
@RestController
public class SalesContractController {
    private SalesContractRepository dao;

    @Autowired
    SalesContractController(SalesContractRepository dao) {
        this.dao = dao;
    }

    //READ ALL
    //@RequestMapping(path = "/vehicle", method = RequestMethod.GET)
    @GetMapping("/sales_contracts")
    public List<SalesContract> get() {
        return (List<SalesContract>) dao.findAll();
    }

    //CREATE
    //JSON form post uses @RequestBody
    @PostMapping("/sales_contracts")
    @ResponseStatus(value = HttpStatus.CREATED)
    public SalesContract create(@RequestBody SalesContract contract) {
        return dao.save(contract);
    }

    //UPDATE BY ID
    @RequestMapping(path="/sales_contracts/{id}",method=RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.FOUND)
    public SalesContract update (@PathVariable long id, @RequestBody SalesContract contract)
    {
        return dao.save(contract);
    }

    //GET BY ID
    @RequestMapping(path="/sales_contracts/{id}",method=RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.FOUND)
    public Optional<SalesContract> find (@PathVariable long id)
    {
        return dao.findById(id);
    }

    //DELETE BY ID
    @RequestMapping(path="/sales_contracts/{id}",method=RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete (@PathVariable Long id)
    {
        dao.deleteById(id);
    }
}
