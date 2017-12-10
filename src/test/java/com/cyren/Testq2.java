package com.cyren;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Created by amiro on 12/7/2017.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Testq2 extends TestBase{

    @Test
    public void a_calc(){
        HtmlScanner htmlScanner = new HtmlScanner(myDriver);
        myDriver.get("https://walla.co.il");
        Assert.assertTrue(htmlScanner.scanPage(HtmlScanner.htmlElement.IMAGE));
        Assert.assertTrue(htmlScanner.scanPage(HtmlScanner.htmlElement.LINK));
    }

}
