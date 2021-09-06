package com.jumia.phone.validator.repository.model;


import com.jumia.phone.validator.model.Country;
import com.jumia.phone.validator.model.State;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer implements Serializable {

    private static final long serialVersionUID = 2658299194346143062L;

    @Id
    private int id;

    private String name;

    private String phone;

    @Transient
    private Country country;

    @Transient
    private State state;

    public Customer(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}
