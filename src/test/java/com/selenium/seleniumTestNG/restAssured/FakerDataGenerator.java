package com.selenium.seleniumTestNG.restAssured;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class FakerDataGenerator {

    @Test
    public void testGenerateDummyData() {
        Faker faker = new Faker();

        String fullName = faker.name().fullName();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();

        String username = faker.name().username();
        String password = faker.internet().password();

        String cellPhone = faker.phoneNumber().cellPhone();

        String emailAddress = faker.internet().emailAddress();
        String safeEmailAddress = faker.internet().safeEmailAddress();

        System.out.println("fullName = " + fullName);
        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);

        System.out.println("username = " + username);
        System.out.println("password = " + password);

        System.out.println("cellPhone = " + cellPhone);

        System.out.println("emailAddress = " + emailAddress);
        System.out.println("safeEmailAddress = " + safeEmailAddress);

    }
}
