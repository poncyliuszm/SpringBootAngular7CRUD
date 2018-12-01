package com.example.backend.service;

import com.example.backend.model.Customer;
import com.example.backend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> list() {
        return customerRepository.findAll();
    }

    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    public void delete(Integer customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);

        customerRepository.delete(customer.get());
    }

    public void update(Customer customer) {
        Optional<Customer> custOpt = customerRepository.findById(customer.getId());
        Customer customerOld = custOpt.get();
        customerOld.setFirstName(customer.getFirstName());
        customerOld.setLastName(customer.getLastName());
        customerOld.setEmail(customer.getEmail());
        customerOld.getCustomerOrderList().addAll(customer.getCustomerOrderList());

        customerRepository.save(customerOld);
    }

    public Customer getOne(Integer customerId) {
        return customerRepository.findById(customerId).get();
    }

    public Customer getOneByName(String name) {
        return customerRepository.findByFirstName(name);
    }
}
