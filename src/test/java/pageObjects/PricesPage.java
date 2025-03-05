package pageObjects;

import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PricesPage extends BasePage {

    public PricesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private static final String PRICES_PAGE_URL = "http://localhost:8080/crops";
    private static final By PRICES_NAV_BTN = By.cssSelector("a[href=\"/crops\"]");
    private static final By KALE_ROW = By.cssSelector("tr:nth-child(5)");

    @Override
    public void getPage() {
        driver.get(PRICES_PAGE_URL);
    }

    public void clickPricesNavBtn(){
        findAndClick(PRICES_NAV_BTN);
    }

    public void hoverTableRow() throws InterruptedException {
        findAndHover(KALE_ROW);
    }

    public By getKaleRowSelector(){
        return KALE_ROW;
    }

}
