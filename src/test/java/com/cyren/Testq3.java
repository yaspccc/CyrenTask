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

    @Test
    public void a_calc(){
        CalculatorMainView calc = new CalculatorMainView(myDriver);
        Assert.assertTrue(calc.calcAction(CalculatorMainView.calcActions.PLUS, 2, 2).equals("4"));
        Assert.assertTrue(calc.calcAction(CalculatorMainView.calcActions.MUL, 2, 2).equals("4"));
        Assert.assertTrue(calc.calcAction(CalculatorMainView.calcActions.ODD, 2, 2).equals("1"));
    }

}
