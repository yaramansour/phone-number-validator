package com.jumia.phone.validator.web.helper;

import com.jumia.phone.validator.repository.model.Customer;
import com.jumia.phone.validator.model.Country;
import com.jumia.phone.validator.web.model.CustomersView;
import com.jumia.phone.validator.model.State;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.jumia.phone.validator.util.Constants.CUSTOMERS_MODEL_KEY;
import static com.jumia.phone.validator.util.Constants.CUSTOMERS_VIEW;


public class CustomerControllerHelper {


    public static ModelAndView buildCustomersView(CustomersView customersView, List<Customer> customers) {

        if (customersView == null) {
            customersView = new CustomersView();
        }
        customersView.setCountries(Country.values());
        customersView.setStates(State.values());
        customersView.setCustomers(customers);
        Map<String, Object> model = new HashMap<>();
        model.put(CUSTOMERS_MODEL_KEY, customersView);
        return new ModelAndView(CUSTOMERS_VIEW, model);
    }
}
