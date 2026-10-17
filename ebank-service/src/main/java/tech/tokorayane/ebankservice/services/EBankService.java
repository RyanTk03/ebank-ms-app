package tech.tokorayane.ebankservice.services;

import org.springframework.stereotype.Service;
import tech.tokorayane.ebankservice.entities.BankAccount;
import tech.tokorayane.ebankservice.repositories.BankAccountRepository;

import java.util.List;

@Service
public class EBankService {
    private final BankAccountRepository bankAccountRepository;

    public EBankService(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    public List<BankAccount> getAllBankAccounts() {
        return this.bankAccountRepository.findAll();
    }

    public BankAccount getBankAccountById(String id) {
        return this.bankAccountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found!"));
    }

    public BankAccount save(BankAccount bankAccount) {
        return this.bankAccountRepository.save(bankAccount);
    }
}
