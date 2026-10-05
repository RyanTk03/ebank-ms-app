package tech.tokorayane.customerservice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.tokorayane.customerservice.entities.Customer;
import tech.tokorayane.customerservice.repository.CustomerRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomer() {
        return this.customerRepository.findAll();
    }

    public Customer findCustomerById(Long id) {
        return this.customerRepository.findById(id).orElseThrow();
    }

    public Customer saveCustomer(Customer customer) {
        return this.customerRepository.save(customer);
    }
}
