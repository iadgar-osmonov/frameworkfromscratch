package com.openmrs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class LoginPage {
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@placeholder='Enter your username']")
    WebElement name;
    @FindBy(xpath = "//input[@placeholder='Enter your password']")
    WebElement password;
    @FindBy(xpath = "//li[.='Inpatient Ward']")
    WebElement inpatientWard;
    @FindBy(css = "input[id='loginButton']")
    WebElement loginBtn;
    @FindBy(css = "#error-message")
    WebElement errorMessage;

    public void sendAllKeys(String name,String password){
        this.name.sendKeys(name);
        this.password.sendKeys(password);
        this.inpatientWard.click();
        this.loginBtn.click();
    }

    public  String getErrorMessage(){
        return BrowserUtils.getText(this.errorMessage);
    }


}
