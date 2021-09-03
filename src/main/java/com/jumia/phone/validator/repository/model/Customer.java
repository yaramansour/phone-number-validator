package com.jumia.phone.validator.repository.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Customer {

    @Id
    private int id;

    private String name;

    private String phone;
}
