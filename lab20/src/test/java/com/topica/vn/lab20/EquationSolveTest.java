package com.topica.vn.lab20;

import com.topica.vn.lab20.services.Calculate;
import com.topica.vn.lab20.services.EquationSolve;
import org.junit.Test;

import static org.junit.Assert.*;

public class EquationSolveTest {
    @Test
    public void commonTest(){
        Double expectedRoots[] = new Double[]{1.0, 3.0};
        EquationSolve solve = new EquationSolve();
        assertArrayEquals(expectedRoots, solve.roots(1.0,-4.0, 3.0));

    }

    @Test
    public void duplicateRootTest(){
        Double expectedRoot[] = new Double[]{1.0};
        EquationSolve solve = new EquationSolve();
        assertArrayEquals(expectedRoot, solve.roots(1.0,-2.0, 1.0));

    }

    @Test
    public void firstDegreeEquationTest(){
        Double expectedRoot[] = new Double[]{0.2};
        EquationSolve solve = new EquationSolve();
        assertArrayEquals(expectedRoot, solve.roots(0.0,-10.0, 2.0));

    }

    @Test
    public void impossibleEquationTest(){
        EquationSolve solve = new EquationSolve();
        assertEquals(0, solve.roots(1.0,0.0, 1.0).length);

    }

    @Test
    public void aAndBBothEqual0Test(){
        Double expectedRoot[] = new Double[0];
        EquationSolve solve = new EquationSolve();
        assertArrayEquals(expectedRoot, solve.roots(0.0,0.0, -2.0));
    }

    @Test
    public void bAndCBothEqual0Test(){
        double expectedRoot = 0.0;
        EquationSolve solve = new EquationSolve();
        assertEquals(expectedRoot, Math.abs(solve.roots(5.0,0.0, 0.0)[0]), 0.00001);
    }

    @Test
    public void aAndCBothEqual0Test(){
        Double expectedRoot = 0.0;
        EquationSolve solve = new EquationSolve();
        assertEquals(expectedRoot, new Double(Math.abs(solve.roots(0.0,37.0, 0.0)[0])));
    }

    @Test
    public void countlessRootsTest(){
        Double expectedRoot[] = new Double[0];
        EquationSolve solve = new EquationSolve();
        assertArrayEquals(expectedRoot, solve.roots(0.0,0.0, -2.0));
    }

    @Test
    public void irrationalRootsTest(){
        Double expectedRoots[] = new Double[]{(-5-Math.sqrt(33.0))/2, (-5+Math.sqrt(33.0))/2};
        EquationSolve solve = new EquationSolve();
        assertArrayEquals(expectedRoots, solve.roots(1.0,5.0, -2.0));
    }

    @Test
    public void bEquals0Test(){
        Double expectedRoots[] = new Double[]{-3.0, 3.0};
        EquationSolve solve = new EquationSolve();
        assertArrayEquals(expectedRoots, solve.roots(2.0,0.0, -18.0));
    }

    @Test
    public void cEquals0Test(){
        Double expectedRoots[] = new Double[]{-3.0, 0.0};
        EquationSolve solve = new EquationSolve();
        assertArrayEquals(expectedRoots, solve.roots(2.0,6.0, 0.0));
    }

}
