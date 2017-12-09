package com.cyren;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Created by amiro on 12/7/2017.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Testq3 extends TestBase{

    StackHomePage homePage = new StackHomePage(myDriver);

    @Test
    public void a_login(){
        myDriver.get("https://stackoverflow.com");
        Assert.assertTrue(homePage.isPageLoaded());
        Assert.assertTrue(homePage.login("yaspccc@gmail.com", "pdw8bhy2"));
    }

    @Test
    public void b_serach(){
        Assert.assertTrue(homePage.search("python"));
        Assert.assertTrue(homePage.selectResult(1));
    }
}
