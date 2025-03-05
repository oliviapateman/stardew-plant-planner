package com.example.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.CalculatorPage;
import pageObjects.HomePage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculatorPageTests {

    public static WebDriver driver;
    public static WebDriverWait wait;
    HomePage homePage;
    CalculatorPage calcPage;

    @BeforeAll
    public static void globalBefore() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @BeforeEach
    public void before() {
        homePage = new HomePage(driver, wait);
        calcPage = new CalculatorPage(driver, wait);
        calcPage.getPage();
    }

    @Test
    public void calculatorNavBtnShouldOpenCalculatorPage() {
        calcPage.clickCalcNavBtn();
        assertEquals("Profit Calculator", calcPage.getPageHeading());
    }

    @Test
    public void plainCalculatorShouldReturnCorrect() {
        calcPage.makeCarrotQuantity3();
        calcPage.clickSubmitBtn();
        WebElement cropResultTotal = driver.findElement(By.cssSelector("table:first-child>tbody>tr>td"));
        assertEquals("122", cropResultTotal.getText());
    }

    @Test
    public void resultsShouldClearAfterEach() {
        calcPage.clickSubmitBtn();
        WebElement cropResultTotal = driver.findElement(By.cssSelector("table:first-child>tbody>tr>td"));
        assertEquals("N/A", cropResultTotal.getText());
    }

    @Test
    public void carrotsInKegResultShouldBeCorrect() {
        calcPage.makeCarrotQuantity3();
        calcPage.clickCarrotKegCheckBox();
        calcPage.clickSubmitBtn();
        WebElement regKegTotal = driver.findElement(By.cssSelector("div:nth-child(4)>table>tbody>tr:nth-child(1)>td"));
        WebElement silverKegTotal = driver.findElement(By.cssSelector("div:nth-child(4)>table>tbody>tr:nth-child(2)>td"));
        WebElement goldKegTotal = driver.findElement(By.cssSelector("div:nth-child(4)>table>tbody>tr:nth-child(3)>td"));
        assertEquals("234", regKegTotal.getText());
        assertEquals("288", silverKegTotal.getText());
        assertEquals("351", goldKegTotal.getText());
    }

    @Test
    public void tillerBoxChecksAllBoxes(){
        calcPage.clickAllTiller();
        WebElement carrotTillerBox = driver.findElement(By.cssSelector("input[name=\"dataList[1].tiller\"]"));
        assertTrue(carrotTillerBox.isSelected());
    }

    @Test
    public void artisanBoxChecksAllBoxes(){
        calcPage.clickAllArtisan();
        WebElement carrotArtisanBox = driver.findElement(By.cssSelector("input[name=\"dataList[1].artisan\"]"));
        assertTrue(carrotArtisanBox.isSelected());
    }

    @AfterAll
    public static void globalAfter() {
        driver.quit();
    }
}