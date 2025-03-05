package com.example.StardewPlannerWebApp;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.HomePage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePageTests {

    public static WebDriver driver;
    public static WebDriverWait wait;
    HomePage homePage;

    @BeforeAll
    public static void globalBefore(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @BeforeEach
    public void before(){
        homePage = new HomePage(driver,wait);
        homePage.getPage();
    }

    @Test
    public void homeNavBtnShouldOpenHomePage(){
        homePage.clickHomeNavBtn();
        assertEquals("A guide for farming", homePage.getPageHeading());
    }

    @AfterAll
    public static void globalAfter(){
        driver.quit();
    }

}
