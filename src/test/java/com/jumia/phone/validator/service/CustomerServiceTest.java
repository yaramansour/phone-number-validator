package com.jumia.phone.validator.service;

import com.jumia.phone.validator.helper.CustomerTestHelper;
import com.jumia.phone.validator.model.Country;
import com.jumia.phone.validator.model.State;
import com.jumia.phone.validator.repository.CustomerRepository;
import com.jumia.phone.validator.repository.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.when;


@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @MockBean
    private CustomerRepository customerRepository;


    @Test
    public void testGetCustomers_AllCustomers(){
        when(customerRepository.findAll()).thenReturn(CustomerTestHelper.buildCustomersData());
        List<Customer> customersPhoneNumbers = customerService.getCustomersPhoneNumbers(null, null);
        assertThat(customersPhoneNumbers.size(), is(12));
    }

    @Test
    public void testGetCustomers_ValidPhoneNumbers(){
        when(customerRepository.findAll()).thenReturn(CustomerTestHelper.buildCustomersData());
        List<Customer> customersPhoneNumbers = customerService.getCustomersPhoneNumbers(null, State.VALID);
        assertThat(customersPhoneNumbers.size(), is(5));
    }

    @Test
    public void getCustomers_countryFiltered(){
        when(customerRepository.findAll()).thenReturn(CustomerTestHelper.buildCustomersData());
        List<Customer> customersPhoneNumbers = customerService.getCustomersPhoneNumbers(Country.MOROCCO, null);
        assertThat(customersPhoneNumbers.size(), is(4));
    }

    @Test
    public void getCustomers_countryAndStateFiltered(){
        when(customerRepository.findAll()).thenReturn(CustomerTestHelper.buildCustomersData());
        List<Customer> customersPhoneNumbers = customerService.getCustomersPhoneNumbers(Country.MOROCCO, State.NOT_VALID);
        assertThat(customersPhoneNumbers.size(), is(3));
    }

}
