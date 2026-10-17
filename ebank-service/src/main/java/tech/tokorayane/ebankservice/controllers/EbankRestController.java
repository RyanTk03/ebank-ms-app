package tech.tokorayane.ebankservice.controllers;

import org.springframework.web.bind.annotation.*;
import tech.tokorayane.ebankservice.entities.BankAccount;
import tech.tokorayane.ebankservice.services.EBankService;

import java.util.List;

@RestController
public class EbankRestController {

    private final EBankService eBankService;

    public EbankRestController(EBankService eBankService) {
        this.eBankService = eBankService;
    }

    @GetMapping("/accounts")
    public List<BankAccount> getAllBankAccounts() {
        return this.eBankService.getAllBankAccounts();
    }

    @GetMapping("/accounts/{id}")
    public BankAccount getBankAccountById(@PathVariable String id) {
        return this.eBankService.getBankAccountById(id);
    }

    @PostMapping("/accounts")
    public BankAccount save(@RequestBody BankAccount bankAccount) {
        return this.eBankService.save(bankAccount);
    }
}
