package org.titanium.pf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {
    WebDriver driver;

    @FindBy(name = "firstName")
    WebElement txtFirstName;

    @FindBy(name = "country")
    WebElement ddlCountry;

    @FindBy(id = "email")
    WebElement txtUserName;

    @FindBy(name = "password")
    WebElement txtPassword;

    @FindBy(name = "confirmPassword")
    WebElement txtConfrimPass;

    @FindBy(name = "register")
    WebElement btnSubmit;

    public RegisterPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setFirstName(String firstName){
        txtFirstName.sendKeys(firstName);
    }

    public void selectCountry(String country){
        new Select(ddlCountry).selectByVisibleText(country);
    }

    public void setUserName(String userName){
        txtUserName.sendKeys(userName);
    }

    public void setPassword(String password){
        txtPassword.sendKeys(password);
    }

    public void setConfirmPassword(String confirmPass){
        txtConfrimPass.sendKeys(confirmPass);
    }

    public void clickOnSubmit(){
        btnSubmit.click();
    }

    public void submitUserInformation(String userName, String password){
        this.setUserName(userName);
        this.setPassword(password);
        this.setConfirmPassword(password);
        this.clickOnSubmit();
    }
}
