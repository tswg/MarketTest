import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import ru.yandex.market.MainPage;
import ru.yandex.market.catalog.MobilePhonesPage;

import java.util.List;

public class SearchProduct extends BaseTest {

    @Before
    public void setUp() {
        //1. Зайти на сайт Яндекс Маркет
        driver.navigate().to("https://market.yandex.ru/");
    }

    @Test
    public void firstOption() throws InterruptedException {
        //2. Найти мобильные телефоны марки Nokia, Samsung
        new MainPage(driver)
                .writeSearchRequest("Samsung Nokia")
                .clickSearchButton();
        // ценовой категории от 20 до 30 тыс руб
        MobilePhonesPage mpp = new MobilePhonesPage(driver);
                mpp
                .writePriceFrom("20000")
                .writePriceUp("30000");
        //3. Проверить с помощью ассертов Junit результаты поиска.
        Thread.sleep(5000);
        List<WebElement> phoneList = mpp.getPhoneList();
        List<WebElement> priceList = mpp.getPriceList();
        for (int i = 0; i < phoneList.size(); i++) {
            String pr = priceList.get(i).getText();
            String prParse = pr.replaceAll("[^0-9]", "");
            int phonePrice = Integer.parseInt(prParse);
            //сверяю что список телефонов на странице NOKIA и SAMSUNG
            Assert.assertTrue(phoneList.get(i).getText().equals("NOKIA")||phoneList.get(i).getText().equals("SAMSUNG"));
            //Сверяю что цены телефонов на странице в диапазоне 20000 - 30000
            Assert.assertTrue(phonePrice >= 20000 && phonePrice <= 30000);
        }
    }
}
