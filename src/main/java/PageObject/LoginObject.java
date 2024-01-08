package PageObject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class LoginObject {
    protected SelenideElement
            loginButton= Selenide.$(By.xpath("//*[@id=\"body\"]/header/div[1]/div[4]/div[3]/p")),
            emailInputField=Selenide.$(By.id("Email")),
            passwordInputField=Selenide.$(By.id("Password")),
            enterButton=Selenide.$(By.xpath("//*[@id=\"LoginForm\"]/div[3]/button"));
}
