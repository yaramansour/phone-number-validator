package com.jumia.phone.validator.web.controller;


import com.jumia.phone.validator.repository.model.Customer;
import com.jumia.phone.validator.service.CustomerService;
import com.jumia.phone.validator.web.helper.CustomerControllerHelper;
import com.jumia.phone.validator.model.Country;
import com.jumia.phone.validator.web.model.CustomersView;
import com.jumia.phone.validator.model.State;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/phoneNumbers")
    public ModelAndView getPhoneNumbers(@RequestParam(name = "country", required = false) Country country,
                                        @RequestParam(name = "state", required = false) State state,
                                        CustomersView customersView) {
        List<Customer> customers = customerService.getCustomersPhoneNumbers(country, state);
        return CustomerControllerHelper.buildCustomersView(customersView, customers);
    }
}
