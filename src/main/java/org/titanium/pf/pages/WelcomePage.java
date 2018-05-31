package org.titanium.pf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {
    WebDriver driver;

    @FindBy(linkText = "REGISTER")
    WebElement lnkRegister;

    public WelcomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickRegisterLink(){
        lnkRegister.click();
    }

    public String getWelcomeTitle(){
        return driver.getTitle();
    }
}
