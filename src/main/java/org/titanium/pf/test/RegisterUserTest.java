package org.titanium.pf.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.titanium.pom.pages.RegisterPage;
import org.titanium.pom.pages.WelcomePage;

public class RegisterUserTest {
    WebDriver driver;
    String expectedResult = "";
    String actualResult = "";
    WelcomePage welcomePage;
    RegisterPage registerPage;

    @BeforeTest
    public void launchBrowser(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://newtours.demoaut.com");
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }

    @Test(priority = 0)
    public void goToRegisterPage(){
        welcomePage = new WelcomePage(driver);
        welcomePage.clickRegisterLink();

        expectedResult = "Register: Mercury Tours";
        actualResult = welcomePage.getWelcomeTitle();
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test(priority = 1)
    public void registerAnUser(){
        registerPage = new RegisterPage(driver);

        registerPage.setFirstName("Gilberto");
        registerPage.selectCountry("AUSTRIA");

        registerPage.submitUserInformation("gilberto@mail.com", "123");

        String textSuccess = driver.findElement(By.xpath("//*[contains(text(),'Note:')]")).getText();
        System.out.println("Test passed! " + textSuccess);
    }
}
