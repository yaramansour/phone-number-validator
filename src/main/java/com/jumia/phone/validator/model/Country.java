package com.jumia.phone.validator.model;

import lombok.Getter;

import java.util.Optional;
import java.util.stream.Stream;

public enum Country {

    CAMEROON("237", "\\(237\\)\\ ?[2368]\\d{7,8}$"),

    ETHIOPIA("251", "\\(251\\)\\ ?[1-59]\\d{8}$"),

    MOROCCO("212", "\\(212\\)\\ ?[5-9]\\d{8}$"),

    MOZAMBIQUE("258", "\\(258\\)\\ ?[28]\\d{7,8}$"),

    UGANDA("256", "\\(256\\)\\ ?\\d{9}$");


    @Getter
    private final String countryCode;

    @Getter
    private final String validationRegex;

    Country(String countryCode, String validationRegex) {
        this.countryCode = countryCode;
        this.validationRegex = validationRegex;
    }

    public static Country valueByCountryCode(final String countryCode) {
        Optional<Country> event = Stream.of(values()).filter(country -> country.getCountryCode().equals(countryCode)).findFirst();
        return event.orElse(null);
    }
}
