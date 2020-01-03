package com.mapri.webbackend.repository;

import com.mapri.webbackend.domain.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Long> {
    Customer findByCnpj(String cnpj);
}
