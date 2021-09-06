package com.jumia.phone.validator;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Spring boot application launcher class
 * @author Yara Mansour
 */
@SpringBootApplication
public class PhoneNumberValidator {

    public static void main(final String[] args) {
        SpringApplication.run(PhoneNumberValidator.class, args);
    }
}
