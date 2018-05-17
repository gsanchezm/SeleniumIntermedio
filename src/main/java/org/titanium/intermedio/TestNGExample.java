package org.titanium.intermedio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGExample {
    String baseURL = "http://newtours.demoaut.com/index.php";
    WebDriver driver;
    String expectedResult = "";
    String actualResult = "";
    String chromePath = System.getProperty("user.dir") + "/drivers/chromedriver.exe";

    @BeforeTest
    public void launchBrowser(){
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }

    @AfterMethod
    public void goBackToHomePEage(){
        driver.findElement(By.linkText("Home")).click();
    }

    @Test(priority = 0, description = "Visit MErcury Tours")
    public void registerPage(){
        driver.findElement(By.linkText("REGISTER")).click();
        expectedResult = "Register: Mercury Tours";
        actualResult = driver.getTitle();
        Assert.assertEquals(actualResult,expectedResult, "Title is not equals!");
    }

    @Test(priority = 0, enabled = false)
    public void supportPage(){
        driver.findElement(By.linkText("SUPPORT")).click();
        expectedResult = "Under Construction: Mercury Tours";
        actualResult = driver.getTitle();
        Assert.assertEquals(actualResult,expectedResult, "Title is not equals!");

    }
}
