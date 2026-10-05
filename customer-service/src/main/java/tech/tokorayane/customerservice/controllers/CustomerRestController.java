package tech.tokorayane.customerservice.controllers;

import org.springframework.web.bind.annotation.*;
import tech.tokorayane.customerservice.entities.Customer;
import tech.tokorayane.customerservice.service.CustomerService;

import java.util.List;

@RestController
public class CustomerRestController {
    private CustomerService customerService;

    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomer() {
        return this.customerService.getAllCustomer();
    }

    @GetMapping("/customers/{id}")
    public Customer findCustomerById(@PathVariable Long id) {
        return this.customerService.findCustomerById(id);
    }

    @PostMapping("/customers")
    public Customer saveCustomer(@RequestBody Customer customer) {
        return this.customerService.saveCustomer(customer);
    }
}
