package com.maftouhi.accountservice.Entities;

import com.maftouhi.accountservice.ENUMs.AccountType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder @ToString
public class Account {
    @Id
    private String accountId;
    private double balance;
    private LocalDate createdAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Transient
    private Customer customer;
    private Long customerId; // FK

}
