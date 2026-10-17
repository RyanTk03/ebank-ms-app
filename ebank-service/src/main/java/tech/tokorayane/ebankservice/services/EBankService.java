package tech.tokorayane.ebankservice.services;

import org.springframework.stereotype.Service;
import tech.tokorayane.ebankservice.entities.BankAccount;
import tech.tokorayane.ebankservice.feign.CustomerRestClient;
import tech.tokorayane.ebankservice.models.Customer;
import tech.tokorayane.ebankservice.repositories.BankAccountRepository;

import java.util.Date;
import java.util.List;

@Service
public class EBankService {
    private final BankAccountRepository bankAccountRepository;
    private final CustomerRestClient customerRestClient;

    public EBankService(BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient) {
        this.bankAccountRepository = bankAccountRepository;
        this.customerRestClient = customerRestClient;
    }

    public List<BankAccount> getAllBankAccounts() {
        return this.bankAccountRepository.findAll();
    }

    public BankAccount getBankAccountById(String id) {
        BankAccount bankAccount = this.bankAccountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found!"));
        bankAccount.setCustomer(this.customerRestClient.getCustomerById(bankAccount.getCustomerId()));

        return bankAccount;
    }

    public BankAccount save(BankAccount bankAccount) {
        try {
            Customer customer = this.customerRestClient.getCustomerById(bankAccount.getCustomerId());
            bankAccount.setCreatedAt(new Date());
            return this.bankAccountRepository.save(bankAccount);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
