package org.titanium.intermedio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class CrossBrowserExample {
    String baseURL = "http://newtours.demoaut.com/index.php";
    WebDriver driver;
    String expectedResult = "";
    String actualResult = "";

    public void setProperties(String prop, String driverName){
        System.setProperty("webdriver." + prop + ".driver", System.getProperty("user.dir")+"/drivers/" + driverName + ".exe");
    }

    @BeforeTest
    @Parameters("browser")
    public void launchBrowser(String browser) throws Exception {

        switch (browser.toLowerCase()){
            case "chrome":
                setProperties("chrome", "chromedriver");
                driver = new ChromeDriver();
                break;
             case "firefox":
                 setProperties("gecko", "geckodriver");
                 driver = new FirefoxDriver();
                 break;
            case "ie":
                setProperties("ie", "IEDriverServer");
                driver = new InternetExplorerDriver();
                break;
            case "edge":
                setProperties("edge", "MicrosoftWebDriver");
                driver = new EdgeDriver();
                break;
            default:
                throw new Exception("Incorrect Browser");

        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseURL);
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }

    @AfterMethod
    public void goBackToHomePage(){
        driver.findElement(By.linkText("Home")).click();
    }

    @Test(priority = 0, description = "Visit Mercury Tours")
    public void registerPage() throws InterruptedException {
        driver.findElement(By.linkText("REGISTER")).click();
        expectedResult = "Register: Mercury Tours";
        Thread.sleep(2000);
        actualResult = driver.getTitle();
        Assert.assertEquals(actualResult,expectedResult, "Title is not equals!");
    }

    @Test(priority = 1)
    public void supportPage() throws InterruptedException {
        driver.findElement(By.linkText("SUPPORT")).click();
        expectedResult = "Under Construction: Mercury Tours";
        Thread.sleep(2000);
        actualResult = driver.getTitle();
        Assert.assertEquals(actualResult,expectedResult, "Title is not equals!");
    }
}
