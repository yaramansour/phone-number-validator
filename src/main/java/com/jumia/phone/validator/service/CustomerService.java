package com.jumia.phone.validator.service;


import com.jumia.phone.validator.repository.model.Customer;
import com.jumia.phone.validator.repository.CustomerRepository;
import com.jumia.phone.validator.model.Country;
import com.jumia.phone.validator.model.State;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    /**
     * retrieve customers from the database applying country and state filters if exists
     *
     * @param country country filter
     * @param state   state filter
     */
    public List<Customer> getCustomersPhoneNumbers(Country country, State state){
        List<Customer> customers = customerRepository.findAll();

        if (country == null && state == null) {
            customers.forEach(this::setPhoneNumberValidityAndCountry);
            return customers;
        }

        return filterCustomers(customers, country, state);
    }

    /**
     * filter customers based on country and state
     *
     * @param customers list of customers to filter
     * @param country country filter
     * @param state   state filter
     */
    private List<Customer> filterCustomers(List<Customer> customers, Country country, State state){

        List<Customer> filteredCustomers = new ArrayList<>();
        for (Customer customer : customers) {
            setPhoneNumberValidityAndCountry(customer);

            if (country == null || country == customer.getCountry()) {
                if(state == null || state == customer.getState()){
                    filteredCustomers.add(customer);
                }
            }
        }

        return filteredCustomers;
    }

    /**
     * sets the country and the state for the customer based on country code and validation regex
     *
     * @param customer customer object
     */
    private void setPhoneNumberValidityAndCountry(Customer customer) {

        String phoneNumber = customer.getPhone();
        if (phoneNumber == null || phoneNumber.isEmpty() || !phoneNumber.contains(")")) {
            customer.setState(State.NOT_VALID);
            return;
        }

        String countryCode = phoneNumber.substring(1, phoneNumber.indexOf(")"));
        Country country = Country.valueByCountryCode(countryCode);
        customer.setCountry(country);

        if (phoneNumber.matches(country.getValidationRegex())) {
            customer.setState(State.VALID);
        } else {
            customer.setState(State.NOT_VALID);
        }
    }
}
