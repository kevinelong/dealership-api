package com.pluralsight.dealership.api;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface InventoryRepository extends CrudRepository<Inventory, Long> {
//    Inventory findById(long id);
}