import org.junit.Test;
import org.openqa.selenium.By;
import ru.yandex.market.Main;
import ru.yandex.market.catalog.MobilePhones;

public class SearchProduct extends BaseTest {

    @Test
    public void firstOption() {
        new Main(driver)
                .writeSearchRequest("Samsung Nokia")
                .clickSearchButton();
        new MobilePhones(driver)
                .writePriceFrom("20000")
                .writePriceUp("30000");
        System.out.println(driver.findElement(
                By.xpath("//h1[@class='title title_size_32 i-bem title_changeable_yes title_js_inited']")).getText());
    }

    @Test
    public void secondOption() {
        new Main(driver)
                .clickAllCategoriesButton()
                .clickMobilePhonesButton();
        new MobilePhones(driver)
                .selectManufacturer("Nokia")
                .selectManufacturer("Samsung")
                .writePriceFrom("20000")
                .writePriceUp("30000");
        System.out.println(driver.findElement(
                By.xpath("//h1[@class='title title_size_32 i-bem title_changeable_yes title_js_inited']")).getText());
    }

}
