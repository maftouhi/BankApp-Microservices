package com.maftouhi.accountservice.Entities;

import lombok.*;

@Getter
@Setter
@Builder
public class Customer {

    private Long id;
    private String firstname;
    private String lastname;
    private String email;

}
