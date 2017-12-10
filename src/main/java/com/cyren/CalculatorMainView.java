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
public class CalculatorMainView {

    private static final Logger log = Logger.getLogger(CalculatorMainView.class);

    private WebDriver viewDriver;
    private int waitTime = 10;
    private String calcElement = "%s";
    private By result = By.className("android.widget.EditText");

    public CalculatorMainView(WebDriver driver){
        this.viewDriver = driver;
    }

    public enum calcActions{
        DELETE("DEL"),
        PLUS("+"),
        MUL("*"),
        ODD("/"),
        RESULT("/");

        private String action;
        calcActions(String action){this.action=action;}
        public String getAction(){
            return action;
        }
    }

    public String  calcAction(calcActions action ,int num1, int num2){
        try{
            WebElement del = new WebDriverWait(viewDriver, (long)waitTime).until(ExpectedConditions.presenceOfElementLocated(By.name(String.format(calcElement, calcActions.DELETE.getAction()))));
            del.click();
            WebElement fnum = new WebDriverWait(viewDriver, (long)waitTime).until(ExpectedConditions.presenceOfElementLocated(By.name(String.format(calcElement, String.valueOf(num1)))));
            fnum.click();
            WebElement ac = new WebDriverWait(viewDriver, (long)waitTime).until(ExpectedConditions.presenceOfElementLocated(By.name(String.format(calcElement, action.getAction()))));
            ac.click();
            WebElement lnum = new WebDriverWait(viewDriver, (long)waitTime).until(ExpectedConditions.presenceOfElementLocated(By.name(String.format(calcElement, String.valueOf(num2)))));
            lnum.click();
            WebElement res = new WebDriverWait(viewDriver, (long)waitTime).until(ExpectedConditions.presenceOfElementLocated(By.name(String.format(calcElement, calcActions.RESULT.getAction()))));
            res.click();
            return new WebDriverWait(viewDriver, (long)waitTime).until(ExpectedConditions.presenceOfElementLocated(result)).getText();
        }catch (Exception e){
            log.error("calc action failed");
            return null;
        }
    }
}
