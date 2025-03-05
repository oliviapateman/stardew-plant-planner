package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorPage extends BasePage {

    public CalculatorPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private static final String CALC_PAGE_URL = "http://localhost:8080/calculator";
    private static final By CALC_NAV_BTN = By.cssSelector("a[href=\"/calculator\"]");
    private static final By CARROT_QUANTITY = By.cssSelector("input[name=\"dataList[1].quantity\"]");
    private static final By CALC_SUBMIT_BTN = By.cssSelector("button#calcSubmit");
    private static final By CARROT_KEG_BOX = By.cssSelector("input[name=\"dataList[1].keg\"]");

    @Override
    public void getPage() {
        driver.get(CALC_PAGE_URL);
    }

    public void clickCalcNavBtn(){
        findAndClick(CALC_NAV_BTN);
    }

    public void makeCarrotQuantity3(){
        findAndClick(CARROT_QUANTITY);
        WebElement blueJazzQuantity = driver.findElement(CARROT_QUANTITY);
        blueJazzQuantity.clear();
        blueJazzQuantity.sendKeys("3");
    }

    public void clickSubmitBtn(){
        findAndClick(CALC_SUBMIT_BTN);
    }

    public void clickCarrotKegCheckBox(){
        findAndClick(CARROT_KEG_BOX);
    }

    public void clickAllTiller(){
        findAndClick(By.cssSelector("input#selectAllTiller"));
    }

    public void clickAllArtisan(){
        findAndClick(By.cssSelector("input#selectAllArtisan"));
    }

}
