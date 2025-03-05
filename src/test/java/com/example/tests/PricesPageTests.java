package com.example.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.HomePage;
import pageObjects.PricesPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PricesPageTests {

    public static WebDriver driver;
    public static WebDriverWait wait;
    HomePage homePage;
    PricesPage pricesPage;

    @BeforeAll
    public static void globalBefore(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @BeforeEach
    public void before(){
        homePage = new HomePage(driver,wait);
        pricesPage = new PricesPage(driver, wait);
        homePage.getPage();
    }

    @Test
    public void pricesNavBtnShouldOpenPricesPage(){
        pricesPage.clickPricesNavBtn();
        assertEquals("Crop Selling Prices", pricesPage.getPageHeading());
    }

    @Test
    public void rowShouldTurnYellowOnHover() throws InterruptedException {
        pricesPage.getPage();
        pricesPage.hoverTableRow();
        String kaleBG = driver.findElement(pricesPage.getKaleRowSelector()).getCssValue("background-color");
        String kaleBGHex = Color.fromString(kaleBG).asHex();
        assertEquals("#f5eea6", kaleBGHex);
    }

    @AfterAll
    public static void globalAfter(){
        driver.quit();
    }
}
