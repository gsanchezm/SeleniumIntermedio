package org.titanium.intermedio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ParameterByMethod {
    WebDriver driver;
    String chromePath = System.getProperty("user.dir") + "/drivers/chromedriver.exe";
    String baseURL = "https://google.com";

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

    @DataProvider(name = "SearchProvider")
    public Object[][] getDataFromDataProvider(Method m){
        if(m.getName().equals("testMethodA")){
            return new Object[][]{
                    {"Hugo", "Google"},
                    {"David", "Yahoo"},
                    {"Wilmer", "Gmail"},
                    {"Fernando", "Amazon"}
            };
        }else if(m.getName().equals("testMethodB")){
            return new Object[][]{
                    {"Mexico"},
                    {"China"},
                    {"Rusia"}
            };
        }
        return null;
    }

    @Test(dataProvider = "SearchProvider")
    public void testMethodA(String tester, String searchKey) throws InterruptedException {
        WebElement txtSearch = driver.findElement(By.name("q"));
        txtSearch.sendKeys(searchKey);
        System.out.println("Bienvenido -> " + tester + " Tu palabra a buscar es " + searchKey);
        Thread.sleep(2000);

        String testValue = txtSearch.getAttribute("value");
        System.out.println("El valor de prueba es " + testValue + " y es igual a " + searchKey);
        txtSearch.clear();

        Assert.assertTrue(testValue.equals(searchKey));

    }

    @Test(dataProvider = "SearchProvider")
    public void testMethodB(String searchKey) throws InterruptedException {
        WebElement txtSearch = driver.findElement(By.name("q"));
        txtSearch.sendKeys(searchKey);
        Thread.sleep(2000);

        String testValue = txtSearch.getAttribute("value");
        System.out.println("El valor de prueba es " + testValue + " y es igual a " + searchKey);
        txtSearch.clear();

        Assert.assertTrue(testValue.equals(searchKey));
    }
}
