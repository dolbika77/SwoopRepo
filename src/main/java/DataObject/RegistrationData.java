package DataObject;

import com.github.javafaker.Faker;

public interface RegistrationData {
    Faker faker =new Faker();

    String
            email=String.valueOf(faker.internet().emailAddress()),
//            password=faker.bothify("????##??"),
            password=faker.regexify("[A-Za-z0-9]{8}"),
            repeatPassword=password,
            firstName=String.valueOf(faker.name().firstName()),
            lastName=String.valueOf(faker.name().lastName()),
            yearOfBirth="1991",
            x=faker.regexify("[A-Za-z0-9]{8}");

}
