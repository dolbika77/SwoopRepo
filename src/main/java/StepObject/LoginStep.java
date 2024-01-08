package StepObject;

import PageObject.LoginObject;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

public class LoginStep extends LoginObject {
    Selenide selenide;
    @Step("Click on ‘შესვლა’ button")
    public void clickLoginButton(){
        Selenide.$(loginButton).click();
    }
    @Step("Fill 'ელ.ფოსტა' with random mail, with correct format")
    public void emailInput(String email){
        Selenide.$(emailInputField).setValue(email);
    }
    @Step("Fill 'პაროლი' with random 8 symbols")
    public void passwordInput(String password){
        Selenide.$(passwordInputField).setValue(password);
    }
    @Step("click on 'შესვლა'")
    public void clickEnterButton(){
        Selenide.$(enterButton).click();
    }

}
