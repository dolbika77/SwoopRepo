package StepObject;

import PageObject.FoodObject;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class FoodStep extends FoodObject {
    @Step("'კვება' დაკლიკება")
    public void clickFoodButton(){
        $(foodButton).click();
    }
    @Step("Choose ‘თბილისი’ from ‘მდებარეობა’ dropdown")
    public void chooseTbilisi(){
        $(tbilisiCity).click();
    }
    public void clickPlaceButton(){$(placeButton).click();}
    @Step("Click on delete icon (next to ‘ძებნა’) and validate that filter ‘თბილისი’ is deleted in dropdown and ‘ყველა მდებარეობა’ is visible")
    public void clickClearButton(){
        $(deleteButton).click();
    }
    @Step("Click on first option from ‘კვება’")
    public void clickAddVoucher(){
        $(addVoucher).click();
    }
    @Step("Choose 2 vouchers ")
    public void clickAddToBasket(){
        $(addToBasket).click();
    }
    @Step("add in the basket ")
    public void clickGoToBasket(){
        $(goToBasket).click();
    }
}
