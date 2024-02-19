package com.maftouhi.accountservice.Clients;

import com.maftouhi.accountservice.Entities.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="CUSTOMER-SERVICE")
public interface CustomerRestClient {

    @GetMapping("/customers/{id}")
    @CircuitBreaker(name = "customerService",fallbackMethod = "getDefaultCustomer")
    Customer findCustomerById(@PathVariable Long id);
    @CircuitBreaker(name = "customerService",fallbackMethod = "getAllDefaultCustomer")
    @GetMapping("/customers")
    List<Customer> allCustomers();

    default Customer getDefaultCustomer(Long id, Exception exception){
        return Customer.builder()
                .firstname("Not Available")
                .lastname("Not Available")
                .email("Not Available")
                .build();
    }

    default List<Customer> getAllDefaultCustomer(Exception exception) {
        return List.of();
    }
}
