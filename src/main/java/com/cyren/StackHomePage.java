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

public class StackHomePage {

    private static final Logger log = Logger.getLogger(StackHomePage.class);
    private WebDriver viewDriver;
    private int waitTime = 10;
    private By userAvatar = By.cssSelector(".-avatar.js-avatar-me");
    private By loginLink = By.cssSelector(".login-link.btn-clear");
    private By serachInputField = By.cssSelector(".f-input.js-search-field");
    private By serachButton = By.cssSelector(".btn-topbar-primary.js-search-submit");
    private By firstAnswerLink = By.xpath("//div[@class='content-padding']//a[@class='question-hyperlink']");

    public StackHomePage(WebDriver driver ){
        this.viewDriver = driver;
    }

    public Boolean login(String userName, String password){
        try{
            new WebDriverWait(viewDriver, (long)waitTime).until(ExpectedConditions.presenceOfElementLocated(loginLink)).click();
            StackLoginPage loginPage = new StackLoginPage(viewDriver);
            loginPage.login(userName, password);
            return isLoginSuccess();
        }catch (Exception e){
            log.error("login failed");
             return false;
        }
    }
    public Boolean isPageLoaded(){
        try{
            return new WebDriverWait(viewDriver, (long)waitTime).until(ExpectedConditions.presenceOfElementLocated(serachInputField)) != null;
        }catch (Exception e){
            log.error("is page loaded failed");
             return null;
        }
    }

    public Boolean isLoginSuccess(){
        try{
            return new WebDriverWait(viewDriver, (long)waitTime).until(ExpectedConditions.presenceOfElementLocated(userAvatar)) != null;
        }catch (Exception e){
            log.error("is login success failed");
            return false;
        }
    }

    public Boolean search(String text){
        try{
            WebElement search = new WebDriverWait(viewDriver, (long)waitTime).until(ExpectedConditions.presenceOfElementLocated(serachInputField));
            search.click();
            search.clear();
            search.sendKeys(text);
            new WebDriverWait(viewDriver, (long)waitTime).until(ExpectedConditions.presenceOfElementLocated(serachButton)).click();
            return new WebDriverWait(viewDriver, (long)waitTime).until(ExpectedConditions.invisibilityOfElementLocated(serachButton));
        }catch (Exception e){
            log.error("search failed");
            return false;
        }
    }

    /**
     *
     * @param index    - result row number 1..15
     * @return
     */
    public Boolean selectResult(int index){
        try{
            if (index < 1 && index > 15){
                log.error("please enter number between 1..15");
                return false;
            }
            WebElement result = new WebDriverWait(viewDriver, (long)waitTime).until(ExpectedConditions.presenceOfAllElementsLocatedBy(firstAnswerLink)).get(index-1);
            result.click();
            return true;
        }catch (Exception e){
            log.error("result not found");
             return null;
        }
    }
}
