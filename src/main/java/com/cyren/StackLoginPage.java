package com.cyren;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by amiro on 12/7/2017.
 */
public class StackLoginPage {

    private static final Logger log = Logger.getLogger(StackLoginPage.class);

    private WebDriver viewDriver;
    private int waitTime = 10;
    private By usernameInputField = By.id("email");
    private By passwordInputField = By.id("password");
    private By loginButton = By.id("submit-button");

    public StackLoginPage(WebDriver driver ){
        this.viewDriver = driver;
    }


    public void login(String username, String password){
        try{
            WebElement user = new WebDriverWait(viewDriver, (long)waitTime).until(ExpectedConditions.presenceOfElementLocated(usernameInputField));
            user.click();
            user.clear();
            user.sendKeys(username);
            WebElement pass = new WebDriverWait(viewDriver, (long)waitTime).until(ExpectedConditions.presenceOfElementLocated(passwordInputField));
            pass.click();
            pass.clear();
            pass.sendKeys(password);
            new WebDriverWait(viewDriver, (long)waitTime).until(ExpectedConditions.presenceOfElementLocated(loginButton)).click();
        }catch (Exception e){
            log.error("login failed");
        }
    }
}
