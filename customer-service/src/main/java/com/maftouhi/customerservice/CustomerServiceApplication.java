package com.maftouhi.customerservice;

import com.maftouhi.customerservice.Entities.Customer;
import com.maftouhi.customerservice.Repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
		List<Customer> customerList = List.of(
				Customer.builder()
						.firstname("bilal")
						.lastname("maftouhi")
						.email("maftouhi@")
						.build(),
				Customer.builder()
						.firstname("med")
						.lastname("test")
						.email("med@")
						.build()
		);
		return args -> {
			customerRepository.saveAll(customerList);
		};
	}
}
