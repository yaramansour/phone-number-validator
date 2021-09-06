package com.jumia.phone.validator.helper;

import com.jumia.phone.validator.repository.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerTestHelper {

    public static final String CUSTOMERS_VIEW = "customers";

    public static final String CUSTOMERS_MODEL_KEY = "customersView";

    public static List<Customer> buildCustomersData(){
        List<Customer> customers = new ArrayList<>();
        //valid phone numbers
        customers.add(new Customer("Yosaf Karrouch", "(212) 698054317"));
        customers.add(new Customer("MICHAEL MICHAEL", "(237) 677046616"));
        customers.add(new Customer("Filimon Embaye", "(251) 914701723"));
        customers.add(new Customer("pt shop 0901 Ultimo", "(256) 3142345678"));
        customers.add(new Customer("Edunildo Gomes Alberto", "(258) 847651504"));

        //invalid phone numbers
        customers.add(new Customer("Walid Hammadi", "(212) 6007989253"));
        customers.add(new Customer("Younes Boutikyad", "(212) 6546545369"));
        customers.add(new Customer("Houda Houda", "(212) 6617344445"));
        customers.add(new Customer("ARREYMANYOR ROLAND TABOT", "(237) 6A0311634"));
        customers.add(new Customer("ZEKARIAS KEBEDE", "(251) 9119454961"));
        customers.add(new Customer("Solo Dolo", "(258) 042423566"));
        customers.add(new Customer("JACKSON NELLY", "(256) 775069443"));
        return customers;
    }
}
