package com.pluralsight.dealership.api;

import org.springframework.data.repository.CrudRepository;

public interface DealershipRepository extends CrudRepository<Dealership, Long> {
    Dealership findById(long id);
}