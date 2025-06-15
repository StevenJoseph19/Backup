package com.example.bank.service;

import com.example.bank.model.Customer;
import com.example.bank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Integer id) {
        return customerRepository.findById(id);
    }

    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }

    public List<Customer> search(String firstName, String lastName) {
        if (firstName != null && lastName != null) {
            return customerRepository.findByFirstNameAndLastName(firstName, lastName);
        } else if (firstName != null) {
            return customerRepository.findByFirstName(firstName);
        } else if (lastName != null) {
            return customerRepository.findByLastName(lastName);
        } else {
            return getAllCustomers();
        }
    }
}
