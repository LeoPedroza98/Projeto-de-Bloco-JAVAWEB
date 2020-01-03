package com.mapri.webbackend.controller;

import com.mapri.webbackend.domain.Customer;
import com.mapri.webbackend.repository.CustomerRepository;
import com.mapri.webbackend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Customer> findAll (){
        Iterable<Customer> all = customerRepository.findAll();
        return all;
    }
    @RequestMapping(method = RequestMethod.POST)
    public Customer save (@RequestBody Customer customer){
        Customer c = customerService.save(customer);
        return c;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Customer update (@RequestBody Customer customer){
        Customer c = customerRepository.save(customer);
        return c;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void delete (@RequestBody Customer customer){
        customerRepository.deleteById(customer.getId());
    }
}
