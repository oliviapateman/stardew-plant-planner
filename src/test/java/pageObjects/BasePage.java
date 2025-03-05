package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract class BasePage {

    public static final By HEADING = By.cssSelector("header>h1");

    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void findAndClick(By selector){
        wait.until(ExpectedConditions.elementToBeClickable(selector)).click();
    }

    public void findAndHover(By selector){
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(selector);
        action.moveToElement(element).perform();
    }

    public abstract void getPage();

    public String getPageHeading(){
        return driver.findElement(HEADING).getText();
    }
}
