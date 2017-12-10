package com.cyren;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.List;

/**
 * Created by amiro on 12/7/2017.
 */
public class HtmlScanner {

    private static final Logger log = Logger.getLogger(HtmlScanner.class);

    private WebDriver viewDriver;
    private int waitTime = 10;
    private String tag = "//%s";

    public HtmlScanner(WebDriver driver){
        this.viewDriver = driver;
        File folder = new File("Resources/results");
        if (!(folder.listFiles() == null)) {
            for (File file : folder.listFiles()) {
                file.delete();
            }
        }
    }


    public enum htmlElement{
        IMAGE("img"),
        LINK("a");

        private String element;
        htmlElement(String element){this.element=element;}
        public String getElement(){
            return element;
        }
    }

    /**
     *
     * @param htmlElement
     * @return
     */
    public Boolean scanPage(htmlElement htmlElement){
        try{
            List<WebElement> list = new WebDriverWait(viewDriver, (long)waitTime).until(ExpectedConditions.presenceOfAllElementsLocatedBy((By.xpath(String.format(tag,htmlElement.getElement())))));
            if (list == null) {
                return false;
            }
            int index=1;
            for (WebElement element: list) {
                switch (htmlElement) {
                    case IMAGE: {
                        FileUtils.writeStringToFile(new File("Resources/results/" + htmlElement.getElement() + index + ".txt"), element.getAttribute("src"));
                        break;
                    }
                    case LINK: {
                        FileUtils.writeStringToFile(new File("Resources/results/" + htmlElement.getElement() + index + ".txt"), element.getAttribute("href"));
                        break;
                    }
                }
                index++;
            }
            if (new File("Resources/results/").listFiles() == null){
                return false;
            }
            return true;
        }catch (Exception e){
            log.error("failed");
            return null;
        }
    }
}
