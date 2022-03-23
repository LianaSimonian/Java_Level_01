package com.aca.homework.week11.jackson.address;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {
    @JsonProperty("jsonFieldCountry")
    private String country;
    @JsonProperty("jsonFieldCity")
    private String city;
    @JsonProperty("jsonFieldStreet")
    private String street;

    public Address(String country, String city, String street) {
        this.country = country;
        this.city = city;
        this.street = street;
    }
}