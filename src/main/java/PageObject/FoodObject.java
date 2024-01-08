package PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FoodObject {
    protected SelenideElement
        foodButton=$(By.xpath("//*[@id=\"body\"]/header/div[2]/div/div[1]/ul/li[4]/a")),
        placeButton=$(By.xpath("//*[@id=\"sidebar\"]/div/div/div/section/div/div[2]/button/span")),
        tbilisiCity=$(By.xpath("//*[@id=\"sidebar\"]/div/div/div/section/div/div[2]/div/ul/li[19]/label/input")),
        deleteButton=$(By.xpath("//*[@id=\"sidebar\"]/div/div/div/section/div/div[5]/div[2]/i")),
        addVoucher=$(By.className("amount-box-add")),
        addToBasket=$(By.className("addBasket")),
        goToBasket=$(By.xpath("//*[@id=\"body\"]/header/div[1]/div[4]/div[2]/a/img"));


}
