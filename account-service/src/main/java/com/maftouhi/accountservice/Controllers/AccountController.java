package com.maftouhi.accountservice.Controllers;

import com.maftouhi.accountservice.Clients.CustomerRestClient;
import com.maftouhi.accountservice.Entities.Account;
import com.maftouhi.accountservice.Entities.Customer;
import com.maftouhi.accountservice.Repositories.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AccountController {

    private AccountRepository accountRepository;
    private CustomerRestClient customerRestClient;

    @GetMapping("/accounts")
    public List<Account> accountList(){
        List<Account> accounts = accountRepository.findAll();
         accounts.forEach(account ->
            account.setCustomer(customerRestClient.findCustomerById(account.getCustomerId()))
        );
         return accounts;
    }

    @GetMapping("/accounts/{id}")
    public Account accountsById(@PathVariable String id){
        Account account = accountRepository.findById(id).get();
        Customer customer = customerRestClient.findCustomerById(account.getCustomerId());
        account.setCustomer(customer);
        return account;
    }



}
