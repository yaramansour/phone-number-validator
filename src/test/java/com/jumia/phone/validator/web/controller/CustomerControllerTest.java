package com.jumia.phone.validator.web.controller;


import com.jumia.phone.validator.helper.CustomerTestHelper;
import com.jumia.phone.validator.repository.model.Customer;
import com.jumia.phone.validator.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@SpringBootTest
public class CustomerControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private CustomerController customerController;

    @MockBean
    private CustomerService customerService;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @Test
    public void testGetCustomers() throws Exception {
        List<Customer> customers = CustomerTestHelper.buildCustomersData();
        when(customerService.getCustomersPhoneNumbers(any(), any())).thenReturn(customers);
        mockMvc.perform(get("/customers/phoneNumbers")).andExpect(status().isOk())
                .andExpect(view().name(CustomerTestHelper.CUSTOMERS_VIEW))
                .andExpect(model().attribute(CustomerTestHelper.CUSTOMERS_MODEL_KEY,
                        hasProperty("customers", is(customers))));

    }
}
