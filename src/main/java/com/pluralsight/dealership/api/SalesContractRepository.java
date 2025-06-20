package com.pluralsight.dealership.api;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

public interface SalesContractRepository extends CrudRepository<SalesContract, Long> {
    @Query(value="Select sc.* from sales_contracts sc where sc.when_sold between :from and :to", nativeQuery = true)
    Iterable<SalesContract> findBetween (LocalDate from, LocalDate to);
}