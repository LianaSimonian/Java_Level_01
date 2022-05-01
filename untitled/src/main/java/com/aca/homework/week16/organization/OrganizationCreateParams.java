package com.aca.homework.week16.organization;

import org.springframework.util.Assert;

public class OrganizationCreateParams {

    private final String name;
    private final String fullAddress;

    public OrganizationCreateParams(String name, String fullAddress) {
        Assert.hasText(name, "The name should not be null or empty");
        Assert.hasText(fullAddress, "The fullAddress should not be null or empty");
        this.name = name;
        this.fullAddress = fullAddress;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "OrganizationCreateParams{" +
                "name='" + name + '\'' +
                ", fullAddress='" + fullAddress + '\'' +
                '}';
    }
}