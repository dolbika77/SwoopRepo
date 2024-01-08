package PageObject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class RestObject {
    protected SelenideElement
        restButton= Selenide.$(By.xpath("//*[@id=\"body\"]/header/div[2]/div/div[1]/ul/li[3]/a")),
        minPrice=$(By.xpath("/html/body/div[8]/div[4]/div[1]/div/div/div/section/div/div[5]/div/input[1]")),
        maxPrice=$(By.xpath("/html/body/div[8]/div[4]/div[1]/div/div/div/section/div/div[5]/div/input[2]")),
        searchButton=$(By.xpath("/html/body/div[8]/div[4]/div[1]/div/div/div/section/div/div[6]/div[1]"));
}
