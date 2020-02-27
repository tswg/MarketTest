package ru.yandex.market.catalog;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MobilePhonesPage {

    private WebDriver driver;

    public MobilePhonesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@name='Цена от']")
    private WebElement priceFrom;

    @FindBy(xpath = "//input[@name='Цена до']")
    private WebElement priceUp;

    //вернуть список производителей телефонов на странице
    public List<WebElement> getPhoneList() {
        List<WebElement> phoneList = driver.findElements(By.xpath("//div[@class='n-snippet-cell2__brand-name']"));
        return phoneList;
    }

    //вернуть список цен телефонов на странице
    public List<WebElement> getPriceList() {
        List<WebElement> priceList = driver.findElements(By.xpath("//div[@class='price']"));
        return priceList;
    }

    //установить нижнюю цену товара
    public MobilePhonesPage writePriceFrom(String price) {
        priceFrom.click();
        priceFrom.clear();
        priceFrom.sendKeys(price);
        return this;
    }

    //установить верхнюю цену товара
    public MobilePhonesPage writePriceUp(String price) {
        priceUp.click();
        priceUp.clear();
        priceUp.sendKeys(price);
        priceUp.sendKeys(Keys.ENTER);
        return this;
    }
}
