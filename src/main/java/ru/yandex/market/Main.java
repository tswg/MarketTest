package ru.yandex.market;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Main {

    private WebDriver driver;

    public Main(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@id='header-search']")
    private WebElement searchLine;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='_3Lwc_UVFq4']")
    private WebElement allCategoriesButton;

    @FindBy(xpath = "//a[contains(text(), 'Мобильные телефоны')]")
    private WebElement mobilePhonesButton;

    public Main writeSearchRequest(String request) {
        searchLine.click();
        searchLine.clear();
        searchLine.sendKeys(request);
        return this;
    }

    public Main clickSearchButton() {
        searchButton.click();
        return this;
    }

    public Main clickAllCategoriesButton() {
        allCategoriesButton.click();
        return this;
    }

    public Main clickMobilePhonesButton() {
        mobilePhonesButton.click();
        return this;
    }
}
