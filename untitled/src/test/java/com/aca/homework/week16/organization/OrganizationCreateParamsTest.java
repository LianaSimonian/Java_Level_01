package com.aca.homework.week16.organization;


import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

class OrganizationCreateParamsTest {

    @Test
    public void testWhenNameIsNull() {
        Assertions.assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
            @Override
            public void call() throws Throwable {
                new OrganizationCreateParams(null, "address");
            }
        }).isExactlyInstanceOf(IllegalArgumentException.class).hasMessage("The name should not be null or empty");
    }

    @Test
    public void testWhenFullAddressIsNull() {
        Assertions.assertThatThrownBy(() -> new OrganizationCreateParams("name", null)).isExactlyInstanceOf(IllegalArgumentException.class).hasMessage("The fullAddress should not be null or empty");
    }

    @Test
    public void test() {
        OrganizationCreateParams testSubject = new OrganizationCreateParams("name", "address");
        Assertions.assertThat("name").isEqualTo(testSubject.getName());
        Assertions.assertThat("address").isEqualTo(testSubject.getFullAddress());
    }
}