package StepObject;

import PageObject.RegistrationObject;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Severity;
import io.qameta.allure.Step;

public class RegistrationStep extends RegistrationObject {
    @Step("click on 'შესვლა'")
    public void clickLoginButton(){
        Selenide.$(loginButton).click();
    }
    @Step("Click on ‘შექმენი’ button")
    public void clickCreateButton(){
        Selenide.$(createAccount).click();
    }
    @Step("Fill email")
    public void emailInputField(String email){
        Selenide.$(emailField).setValue(email);
    }
    @Step("Fill password")
    public void passwordInputField(String password){
        Selenide.$(passwordField).setValue(password);
    }
    @Step("Repeat password")
    public void repeatPassword(String password){
        Selenide.$(repeatPasswordField).setValue(password);
    }
    @Step("Select Gender")
    public void genderSelect(){
        Selenide.$(gender).click();
    }
    @Step("Fill first name")
    public void firstNameInput(String firstName){
        Selenide.$(firstNameField).setValue(firstName);
    }
    @Step("Fill last name")
    public void lastNameInput(String lastName){
        Selenide.$(lastNameField).setValue(lastName);
    }
    public void yearFieldClick(){
        SelenideElement el=Selenide.$(yearOfBirthField);
        el.click();
    }
//    public void yearSendKey(){
//        Selenide.$(yearOfBirth).setValue("1991");
//    }
    public void yearOfBirth(){
        Selenide.$(yearOfBirthField);
    }
    @Step("Accept Terms")
    public void acceptTerms(){
        Selenide.$(termsCheckbox).click();
    }
    @Step("Accept confidential policy")
    public void acceptConfidential(){
        Selenide.$(confidentialCheckbox).click();
    }
    @Step("Confirm button click")
    public void confirmButtonClick(){Selenide.$(confirmButton).click();}

}
