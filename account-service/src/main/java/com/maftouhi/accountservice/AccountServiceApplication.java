package com.maftouhi.accountservice;

import com.maftouhi.accountservice.Clients.CustomerRestClient;
import com.maftouhi.accountservice.ENUMs.AccountType;
import com.maftouhi.accountservice.Entities.Account;
import com.maftouhi.accountservice.Repositories.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AccountRepository accountRepository, CustomerRestClient customerRestClient ) {
		return args -> {
			customerRestClient.allCustomers().forEach(customer -> {
				Account account1 = Account.builder()
						.accountId(UUID.randomUUID().toString())
						.accountType(AccountType.SAVING_ACCOUNT)
						.balance(Math.random() * 333)
						.createdAt(LocalDate.now())
						.currency("$")
						.customerId(customer.getId())
						.build();
				accountRepository.save(account1);
				Account account2 = Account.builder()
						.accountId(UUID.randomUUID().toString())
						.accountType(AccountType.CURRENT_ACCOUNT)
						.balance(Math.random() * 333)
						.createdAt(LocalDate.now())
						.currency("$")
						.customerId(customer.getId())
						.build();
				accountRepository.save(account2);
			});
		};
	}

}