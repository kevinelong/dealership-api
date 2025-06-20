package com.pluralsight.dealership.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//Use controller not rest controller if you want to support redirects
@RestController
public class InventoryController {
    private InventoryRepository dao;

    @Autowired
    InventoryController(InventoryRepository dao) {
        this.dao = dao;
    }

    //READ ALL
    @GetMapping("/inventory")
    public List<Inventory> get() {
        return (List<Inventory>) dao.findAll();
    }

    //CREATE
    //JSON form post uses @RequestBody
    @PostMapping("/inventory")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Inventory create(@RequestBody Inventory inventory) {
        return dao.save(inventory);
    }

    //UPDATE BY ID
    @RequestMapping(path="/inventory/{id}",method=RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.FOUND)
    public Inventory update (@PathVariable long id, @RequestBody Inventory inventory)
    {
        return dao.save(inventory);
    }

    //GET BY ID
    @RequestMapping(path="/inventory/{id}",method=RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.FOUND)
    public Optional<Inventory> find (@PathVariable Long id)
    {
        return dao.findById(id);
    }

    //DELETE BY ID
    @RequestMapping(path="/inventory/{id}",method=RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete (@PathVariable Long id)
    {
        dao.deleteById(id);
    }
}
