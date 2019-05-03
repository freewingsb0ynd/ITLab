package com.topica.vn.lab20;

import com.topica.vn.lab20.services.Calculate;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {
    @Test
    public void commonTest(){
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
        assertEquals(expectedResult, new Double(Math.abs(cal.devide(0.0,-6.0))));
    }


}
