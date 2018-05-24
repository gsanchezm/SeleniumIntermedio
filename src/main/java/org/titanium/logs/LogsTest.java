package org.titanium.logs;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LogsTest {
    WebDriver driver;
    String baseUrl = "http://healthunify.com/bmicalculator/";
    Logger log = Logger.getLogger(LogsTest.class);

    @BeforeClass
    public void initializeComponent(){
        PropertyConfigurator.configure(System.getProperty("user.dir")+"/resources/log4j.properties");
    }

    @Test
    public void launchBrowser(){
        try{
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(baseUrl);
            log.info("Opening webseite: " + baseUrl);
        }catch (WebDriverException we){
            log.error("Webdriver Falló: " + we.getMessage());
        } catch (Exception ex){
            log.error(ex.getMessage());
        }
    }

    @Test(dependsOnMethods = {"BMICalculator"})
    public void tearDown(){
        driver.quit();
        log.info("Navegador Cerrado!");
    }

    @Test(dependsOnMethods = {"launchBrowser"})
    public void BMICalculator(){
        try{
            log.info("Ingresando peso");
            driver.findElement(By.name("wg")).sendKeys("89");

            log.info("Seleccionando Kilogramos");
            new Select(driver.findElement(By.name("opt1"))).selectByVisibleText("kilograms");

            log.info("Seleccionando altura");
            new Select(driver.findElement(By.name("opt2"))).selectByValue("5");
            new Select(driver.findElement(By.name("opt3"))).selectByValue("10");

            log.info("Clic en el botón calcular");
            driver.findElement(By.name("cc")).click();

            String SIUnits = driver.findElement(By.name("si")).getAttribute("value");
            String USUnits = driver.findElement(By.name("us")).getAttribute("value");
            String UKUnits = driver.findElement(By.name("uk")).getAttribute("value");
            String note = driver.findElement(By.name("desc")).getAttribute("value");

            log.info("SI Unit = " + SIUnits);
            log.info("US Unit = " + USUnits);
            log.info("UK Unit = " + UKUnits);
            log.info("Descripción  = " + note);

        }catch (NoSuchElementException ne){
            log.error("No se encontró el elemento web: " + ne.getMessage());
        }catch (WebDriverException we){
            log.error("Webdriver Falló: " + we.getMessage());
        } catch (Exception ex){
            log.error(ex.getMessage());
        }
    }
}
