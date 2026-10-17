package tech.tokorayane.ebankservice.entities;

import jakarta.persistence.*;
import lombok.*;
import tech.tokorayane.ebankservice.models.Customer;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private Date createdAt;

    private double balance;

    private String type;

    private long customerId;

    @Transient
    private Customer customer;
}
