import DataObject.LoginData;
import DataObject.RegistrationData;
import StepObject.FoodStep;
import StepObject.LoginStep;
import StepObject.RegistrationStep;
import StepObject.RestStep;
import com.codeborne.selenide.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static DataObject.LoginData.randomEmail;
import static DataObject.LoginData.randomPassword;
import static DataObject.RegistrationData.*;
import static DataObject.SearchData.maxPriceValue;
import static DataObject.SearchData.minPriceValue;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
public class MainTest implements LoginData {


    @Test(priority = 1)
    @Description ("აღნიშნული ტესტი ახორციელებს სისტემაში დალოგინებას მცდარი მონაცემებით")
    @Severity(SeverityLevel.MINOR)
    public void loginWithRandomData (){
        LoginStep step=new LoginStep();

//        შესვლა ღილაკზე დაკლიკება
        step.clickLoginButton();
        step.emailInput(randomEmail);
        step.passwordInput(randomPassword);
        step.clickEnterButton();

        $(By.xpath("//*[@id=\"input-error-Password\"]")).shouldHave(exactText("მომხმარებელი ან პაროლი არასწორია"));
        $(By.xpath("//*[@id=\"LoginForm\"]/div[2]/a")).shouldBe(Condition.enabled);
    }


    @Test(priority = 2)
    @Description("რეგისტრაციის ფუნქციონალის ტესტირება მობილურის ნომრის და sms კოდის გარეშე")
    @Severity(SeverityLevel.CRITICAL)
    public void registrationNewUser(){
        RegistrationStep step=new RegistrationStep();

        step.clickLoginButton();
        step.clickCreateButton();
        $("body").shouldHave(text("ანგარიშის შექმნა"));

//        მონაცემების შევსება
        step.emailInputField(email);
        step.passwordInputField(password);
        step.repeatPassword(repeatPassword);
        step.genderSelect();
        step.firstNameInput(firstName);
        step.lastNameInput(lastName);
        step.yearFieldClick();
        step.yearFieldClick();
        step.acceptTerms();
        step.acceptConfidential();
        step.confirmButtonClick();

        $("body").shouldHave(text("ჩაწერე ტელეფონის ნომერი"));
        $("body").shouldHave(text("ჩაწერე SMS კოდი"));
    }



    @Test (priority = 3, dependsOnMethods = "registrationNewUser")
    @Description("სასტუმროების სორტირება კონკრეტული ფასის დიაპაზონში")
    @Severity(SeverityLevel.NORMAL)
    public void restInRange(){
        RestStep step=new RestStep();

        open("https://www.swoop.ge/");
        step.clickOnRestButton();
        sleep(5000);
        step.minPriceInput(minPriceValue);
        step.maxPriceInput(maxPriceValue);
        step.clickSearchButton();


        sleep(3000);
        $$(".discounted-prices").shouldHave(CollectionCondition.sizeGreaterThan(0)).forEach(result -> {
            System.out.println(result.$(".deal-voucher-price").getText());
            Double numericValue=Double.parseDouble(result.$(".deal-voucher-price").text().replaceAll("[^\\d]",""));
//            System.out.println(numericValue);
            Assert.assertTrue(numericValue.intValue()>Integer.parseInt(minPriceValue)&&numericValue.intValue()<Integer.parseInt(maxPriceValue));
        });



    }

    @Test(priority = 4)
    @Description("კვების ობიექტების სორტირება და შეკვეთის გაკეთების მცდელობა")
    @Severity(SeverityLevel.NORMAL)
    public void foodPageTest(){

        FoodStep step=new FoodStep();

        step.clickFoodButton();

        step.clickPlaceButton();
        step.chooseTbilisi();
        step.clickClearButton();

        $("body").shouldHave(text("ყველა მდებარეობა"));


//        click on first option
        $$(".special-offer").first().click();

        step.clickAddVoucher();

        step.clickAddToBasket();

        step.clickGoToBasket();

        $(By.xpath("/html/body/div[8]/div[1]/div[2]/div/div[2]/div[1]/p/a")).shouldHave(text(("პოტატო ორბელიანზე | Potato Orbeliani")));
        $("#basket_item_price").shouldHave(text("10.00"));
        $("#basket_item_count").shouldHave((text("2")));


        sleep(5000);
    }


    @BeforeMethod
    @Description("ბრაუზერის გახსნა და swoop-ის გვერდზე გადასვლა")
    @Severity(SeverityLevel.CRITICAL)
    public void beforeTest(){
        WebDriverManager.chromedriver().setup();
        Selenide.open("https://www.swoop.ge/");
        Configuration.timeout=8000;
    }
    @AfterMethod
    @Description("ბრაუზერის დახურვა")
    public void closeBrowser(){
        WebDriverRunner.closeWebDriver();
    }
}
