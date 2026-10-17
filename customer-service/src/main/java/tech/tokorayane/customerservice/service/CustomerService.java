package tech.tokorayane.customerservice.service;

import lombok.AllArgsConstructor;
import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.mcp.annotation.McpToolParam;
import org.springframework.stereotype.Service;
import tech.tokorayane.customerservice.entities.Customer;
import tech.tokorayane.customerservice.repository.CustomerRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {
    private CustomerRepository customerRepository;

    @McpTool(description = "Get all customer")
    public List<Customer> getAllCustomer() {
        return this.customerRepository.findAll();
    }

    @McpTool(description = "Find customer by id")
    public Customer findCustomerById(@McpToolParam(description = "The customer id") Long id) {
        return this.customerRepository.findById(id).orElseThrow();
    }

    @McpTool(description = "Save new customer")
    public Customer saveCustomer(@McpToolParam(description = "The customer to save (name, email)") Customer customer) {
        return this.customerRepository.save(customer);
    }
}
