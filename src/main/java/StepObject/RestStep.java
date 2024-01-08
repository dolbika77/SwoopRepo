package StepObject;
import java.util.*;
import PageObject.RestObject;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;


import static com.codeborne.selenide.Selenide.$;

public class RestStep extends RestObject {
    


    @Step ("Click on 'დასვენება'")
    public void clickOnRestButton(){
        Selenide.$(restButton).click();

    }
    @Step("Fill minimum price")
    public void minPriceInput(String minPriceValue){
        $(minPrice).click();
        $(minPrice).setValue(minPriceValue);
    }
    @Step("Fill maximum price")
    public void maxPriceInput(String maxPriceValue){
        $(maxPrice).setValue(maxPriceValue);
    }

    @Step("Click on 'ძებნა'")
    public void clickSearchButton(){
        $(searchButton).click();
//        utils.waitForElement(loginLocator);

    }

}
