package com.pluralsight.dealership.api;

import org.springframework.data.repository.CrudRepository;

public interface LeaseContractRepository extends CrudRepository<LeaseContract, Long> {
}