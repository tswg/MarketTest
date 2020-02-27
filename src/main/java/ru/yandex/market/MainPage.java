package ru.yandex.market;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@id='header-search']")
    private WebElement searchLine;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;

    //ввод поискового запроса
    public MainPage writeSearchRequest(String request) {
        searchLine.click();
        searchLine.clear();
        searchLine.sendKeys(request);
        return this;
    }

    //кликнуть кнопку "найти"
    public MainPage clickSearchButton() {
        searchButton.click();
        return this;
    }
}
