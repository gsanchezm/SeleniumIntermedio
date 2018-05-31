package org.titanium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage {
    WebDriver driver;

    By lnkRegister = By.linkText("REGISTER");

    public WelcomePage(WebDriver driver){
        this.driver = driver;
    }

    public void clickRegisterLink(){
        driver.findElement(lnkRegister).click();
    }

    public String getWelcomeTitle(){
        return driver.getTitle();
    }
}
