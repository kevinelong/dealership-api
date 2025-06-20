package com.pluralsight.dealership.api;

import org.springframework.data.repository.CrudRepository;

public interface SalesContractRepository extends CrudRepository<SalesContract, Long> {
}