package tech.tokorayane.ebankservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tech.tokorayane.ebankservice.entities.BankAccount;
import tech.tokorayane.ebankservice.services.EBankService;

import java.util.List;

@RestController
public class EbankRestController {

    private EBankService eBankService;

    public EbankRestController(EBankService eBankService) {
        this.eBankService = eBankService;
    }

    @GetMapping("/accounts")
    public List<BankAccount> getAllBankAccounts() {
        return this.eBankService.getAllBankAccounts();
    }

    @GetMapping("/accounts/{id}")
    public BankAccount getBankAccountById(String id) {
        return this.eBankService.getBankAccountById(id);
    }

    @PostMapping("/accounts")
    public BankAccount save(@RequestBody BankAccount bankAccount) {
        return this.eBankService.save(bankAccount);
    }
}
