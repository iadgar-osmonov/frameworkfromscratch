package com.openmrs.steps;

import com.openmrs.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class stepDefinitions {
    WebDriver driver= DriverHelper.getDriver();
    LoginPage loginPage=new LoginPage(driver);
    @Given("user is open mrs user provides their credentials")
    public void user_is_open_mrs_user_provides_their_credentials() {
        loginPage.sendAllKeys(ConfigReader.readProperty("userName"),ConfigReader.readProperty("password"));


    }
    @Then("user validates title as {string} and {string}")
    public void user_validates_title_as_and(String title, String url) {
        Assert.assertEquals(title,driver.getTitle());
        Assert.assertEquals(url,driver.getCurrentUrl());


    }
    @Given("user is on open mrs login page and user provides invalid credentials as userName as'test' and {string}")
    public void user_is_on_open_mrs_login_page_and_user_provides_invalid_credentials_as_user_name_as_test_and(String userName,String password) {
       loginPage.sendAllKeys(userName,password);


    }
    @Then("user validates an error message as {string}")
    public void user_validates_an_error_message_as(String errorMessage) {
        Assert.assertEquals(errorMessage,loginPage.getErrorMessage());

    }

}
