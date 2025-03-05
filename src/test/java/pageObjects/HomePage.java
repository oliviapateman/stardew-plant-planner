package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }

    private static final String HOMEPAGE_URL = "http://localhost:8080/";
    private static final By HOME_NAV_BTN = By.cssSelector("a.active");

    @Override
    public void getPage() {
        driver.get(HOMEPAGE_URL);
    }

    public void clickHomeNavBtn(){
        findAndClick(HOME_NAV_BTN);
    }

}
