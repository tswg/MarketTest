package ru.yandex.market.catalog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MobilePhones {

    private WebDriver driver;

    public MobilePhones(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@name='Цена от']")
    private WebElement priceFrom;

    @FindBy(xpath = "//input[@name='Цена до']")
    private WebElement priceUp;

    public MobilePhones selectManufacturer(String manufacturer) {
        WebElement checkBox = driver.findElement(By.xpath("//input[@name='Производитель "+ manufacturer +"']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(checkBox).click().perform();
        return this;
    }

    public MobilePhones writePriceFrom(String price) {
        priceFrom.click();
        priceFrom.clear();
        priceFrom.sendKeys(price);
        return this;
    }

    public MobilePhones writePriceUp(String price) {
        priceUp.click();
        priceUp.clear();
        priceUp.sendKeys(price);
        return this;
    }
}
