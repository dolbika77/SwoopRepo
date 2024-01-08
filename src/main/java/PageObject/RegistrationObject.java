package PageObject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class RegistrationObject {
    protected SelenideElement
        loginButton= Selenide.$(By.xpath("//*[@id=\"body\"]/header/div[1]/div[4]/div[3]/p")),
        createAccount=Selenide.$(By.xpath("//*[@id=\"LoginForm\"]/div[5]/div/a")),
        emailField=Selenide.$(By.id("email")),
        passwordField=Selenide.$(By.id("password")),
        repeatPasswordField=Selenide.$(By.id("PasswordRetype")),
        gender=Selenide.$(By.id("Gender1")),
        firstNameField=Selenide.$(By.name("firstname")),
        lastNameField=Selenide.$(By.id("surname")),

        yearOfBirthField=Selenide.$(By.xpath("/html/body/div[1]/div/div/div[1]/div[2]/div/div[1]/div/div/form/div[1]/div[6]/div/div/select/option[35]")),

        termsCheckbox=Selenide.$(By.xpath("/html/body/div[1]/div/div/div[1]/div[2]/div/div[1]/div/div/form/div[2]/div/label/span[1]")),
        confidentialCheckbox=Selenide.$(By.xpath("/html/body/div[1]/div/div/div[1]/div[2]/div/div[1]/div/div/form/div[2]/label/span[1]")),
        confirmButton=Selenide.$(By.id("registrationBtn"));


}
