package com.mapri.webbackend.service;

import com.mapri.webbackend.domain.Customer;
import com.mapri.webbackend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomerService implements UserDetailsService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByCnpj(username);
        if (customer != null) {
            return new User(customer.getCnpj(), customer.getPassword(), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

    public Customer save(Customer customer) {
        Customer savedCustomer = new Customer();
        savedCustomer.setName(customer.getName());
        savedCustomer.setCorporateName(customer.getCorporateName());
        savedCustomer.setRating(customer.getRating());
        savedCustomer.setCnpj(customer.getCnpj());
        savedCustomer.setPassword(bcryptEncoder.encode(customer.getPassword()));
        return customerRepository.save(savedCustomer);
    }
}
