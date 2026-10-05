package tech.tokorayane.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.tokorayane.customerservice.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
