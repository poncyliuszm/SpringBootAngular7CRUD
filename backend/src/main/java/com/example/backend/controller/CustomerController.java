package com.example.backend.controller;

import com.example.backend.model.Customer;
import com.example.backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    @RequestMapping("/list")
    public List<Customer> list() {
        return customerService.list();
    }

    @GetMapping("/{customerId}")
    public Customer getOne(@PathVariable("customerId") Integer customerId) {
        return customerService.getOne(customerId);
    }

    @PostMapping
    @RequestMapping("/save")
    public void save(@RequestBody Customer customer) {
        customerService.save(customer);
    }

    @PutMapping("/update")
    public void update(@RequestBody Customer customer) {
        customerService.update(customer);
    }

    @DeleteMapping
    @RequestMapping("delete/{customerId}")
    public void delete(@PathVariable("customerId") Integer customerId) {
        customerService.delete(customerId);
    }
}
