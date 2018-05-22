package org.titanium.intermedio;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JavaScriptExample {
    String baseURL = "http://newtours.demoaut.com/index.php";
    WebDriver driver;
    String expectedResult = "";
    String actualResult = "";
    String chromePath = System.getProperty("user.dir") + "/drivers/chromedriver.exe";
    JavascriptExecutor js;
    String pageLoadStatus = "";

    private boolean highLight(WebElement element){
        js = (JavascriptExecutor)driver;
        for(int iCnt = 0; iCnt < 3; iCnt ++){
            try{
                js.executeScript("arguments[0].setAttribute('style', 'background:red')", element);
                Thread.sleep(1000);
                js.executeScript("arguments[0].setAttribute('style', 'background:')", element);
            }catch(JavascriptException jse){
                System.err.println("Class: JavaScriptExample | Method: highLight | Exception desc: " + jse.getMessage());
                return false;
            } catch (InterruptedException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    private boolean scrollWindow(){
        try{
            js = (JavascriptExecutor)driver;
            //Scroll up(0,-250)/down(0,250)
            js.executeScript("window.scrollBy(0,250)");
        }catch (JavascriptException jse){
            System.err.println("Class: JavaScriptExample | Method: scrollWindow | Exception desc: " + jse.getMessage());
            return false;
        }
        return true;
    }

    private boolean waitForPageToLoad(){
        try {
            js = (JavascriptExecutor)driver;
            do{
                pageLoadStatus = (String)js.executeScript("return document.readyState");
            }while (!pageLoadStatus.equals("complete"));
        }catch (JavascriptException jse){
            System.err.println("Class: JavaScriptExample | Method: waitForPageToLoad | Exception desc: " + jse.getMessage());
            return false;
        }
        return true;
    }

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

    @Test(priority = 0)
    public void goToRegisterPage(){

    }

    @Test(priority = 1)
    public void registerAnUser(){

    }
}
