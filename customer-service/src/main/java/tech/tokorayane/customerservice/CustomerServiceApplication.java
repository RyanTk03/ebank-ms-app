package tech.tokorayane.customerservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tech.tokorayane.customerservice.entities.Customer;
import tech.tokorayane.customerservice.service.CustomerService;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerService customerService) {
        return args -> {
            List<String> names = List.of("Rayane", "Imane", "Yassine");

            names.forEach(name -> {
                customerService.saveCustomer(Customer.builder().name(name).email(name + "@example.com").build());
            });
        };
    }
}
