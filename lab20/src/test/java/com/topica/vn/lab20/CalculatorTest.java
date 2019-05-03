package com.topica.vn.lab20;

import com.topica.vn.lab20.services.Calculate;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {
    @Test
    public void sumCommonTest(){
        Double expectedResult = 15.4;
        Calculate cal = new Calculate();
        assertEquals(expectedResult, cal.sum(10.0,5.4));
    }

    @Test
    public void sumNegativeTest(){
        double expectedResult = 15.4;
        Calculate cal = new Calculate();
        assertEquals(expectedResult, cal.sum(-9.0,24.4), 0.000000000001);
    }

    @Test
    public void sumZeroTest(){
        Double expectedResult = 0.0;
        Calculate cal = new Calculate();
        assertEquals(expectedResult, cal.sum(14.7,-14.7));
    }


    @Test
    public void multiplyCommonTest(){
        Double expectedResult = 5.0;
        Calculate cal = new Calculate();
        assertEquals(expectedResult, cal.multiply(2.5,2.0));
    }

    @Test
    public void multiplyIrrationalNumberTest1(){
        double expectedResult = 10.0;
        Calculate cal = new Calculate();
        assertEquals(expectedResult, cal.multiply( Math.sqrt(5),2*Math.sqrt(5)), 0.000000000001);
    }

    @Test
    public void multiplyIrrationalNumberTest2(){
        Double expectedResult = 3*Math.sqrt(7);
        Calculate cal = new Calculate();
        assertEquals(expectedResult, cal.multiply(Math.sqrt(7),3.0));
    }


    @Test
    public void devideCommonTest(){
        Double expectedResult = 5.0;
        Calculate cal = new Calculate();
        assertEquals(expectedResult, cal.devide(10.0,2.0));
    }

    @Test
    public void devide0Test(){
        Calculate cal = new Calculate();
        assertNull(cal.devide(2.0,0.0));
    }

    @Test
    public void aAndBBothEqual0Test(){
        Calculate cal = new Calculate();
        assertNull(cal.devide(0.0,0.0));
    }

    @Test
    public void devideNegativeTest(){
        Double expectedResult = -2.0;
        Calculate cal = new Calculate();
        assertEquals(expectedResult, cal.devide(-4.0,2.0));
    }

    @Test
    public void devideIrrationalTest(){
        Double expectedResult = -6.0/17;
        Calculate cal = new Calculate();
        assertEquals(expectedResult, cal.devide(-6.0,17.0));
    }

    @Test
    public void result0Test(){
        Double expectedResult = 0.0;
        Calculate cal = new Calculate();
        assertEquals(expectedResult, new Double(Math.abs(cal.devide(0.0,-1.98884))));
    }

}
