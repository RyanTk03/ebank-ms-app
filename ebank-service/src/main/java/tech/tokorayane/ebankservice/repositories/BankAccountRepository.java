package tech.tokorayane.ebankservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.tokorayane.ebankservice.entities.BankAccount;

import java.util.List;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
    List<BankAccount> findByCustomerId(Long id);
}
