package com.pluralsight.dealership.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//Use controller not rest controller if you want to support redirects
@RestController
public class LeaseContractController {
    private LeaseContractRepository dao;

    @Autowired
    LeaseContractController(LeaseContractRepository dao) {
        this.dao = dao;
    }

    //READ ALL
    //@RequestMapping(path = "/vehicle", method = RequestMethod.GET)
    @GetMapping("/lease_contracts")
    public List<LeaseContract> get() {
        return (List<LeaseContract>) dao.findAll();
    }

    //CREATE
    //JSON form post uses @RequestBody
    @PostMapping("/lease_contracts")
    @ResponseStatus(value = HttpStatus.CREATED)
    public LeaseContract create(@RequestBody LeaseContract contract) {
        contract.setCustomer_name(contract.getCustomer_name() + "ZZZ" );
        return dao.save(contract);
    }

    //UPDATE BY ID
    @RequestMapping(path="/lease_contracts/{id}",method=RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.FOUND)
    public LeaseContract update (@PathVariable long id, @RequestBody LeaseContract contract)
    {
        return dao.save(contract);
    }

    //GET BY ID
    @RequestMapping(path="/lease_contracts/{id}",method=RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.FOUND)
    public Optional<LeaseContract> find (@PathVariable long id)
    {
        return dao.findById(id);
    }

    //DELETE BY ID
    @RequestMapping(path="/lease_contracts/{id}",method=RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete (@PathVariable Long id)
    {
        dao.deleteById(id);
    }
}
