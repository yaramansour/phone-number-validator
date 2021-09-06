package com.jumia.phone.validator.web.model;

import com.jumia.phone.validator.model.Country;
import com.jumia.phone.validator.repository.model.Customer;
import com.jumia.phone.validator.model.State;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * the Class that represents {customers.html} model and view
 * @author Yara Mansour
 */

@Getter
@Setter
public class CustomersView implements Serializable {

    private static final long serialVersionUID = 8098456167783512775L;

    private List<Customer> customers;

    private Country[] countries;

    private State[] states;

    private Country country;

    private String state;
}
