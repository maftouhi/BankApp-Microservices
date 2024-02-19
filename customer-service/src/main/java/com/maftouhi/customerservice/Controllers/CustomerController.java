package com.maftouhi.customerservice.Controllers;
import com.maftouhi.customerservice.Entities.Customer;
import com.maftouhi.customerservice.Repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@AllArgsConstructor
public class CustomerController {

    private final CustomerRepository customerRepository;

    @GetMapping("/customers")
    public List<Customer> customerList(){
        return  customerRepository.findAll();
    }

    @GetMapping("/customers/{id}")
    public Customer customerById(@PathVariable  Long id){
        return customerRepository.findById(id).get();
    }


}
