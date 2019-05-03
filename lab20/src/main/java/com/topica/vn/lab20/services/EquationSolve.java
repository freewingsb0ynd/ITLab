package com.topica.vn.lab20.services;

import com.topica.vn.lab20.utils.EquationSolveUtils;

public class EquationSolve implements EquationSolveUtils {
    @Override
    public Double[] roots(Double a, Double b, Double c) {
        Double results[];
        if(a==0 && b==0 && c==0) return null;       //countless roots
        else if(a == 0){
            if(b == 0){
                return new Double[0];               //impossible equation
            } else {                                //first degree equation
                results = new Double[1];
                results[0] = -c/b;
                return results;
            }
        }

        else {                                      //a differ 0
            Double delta = b*b - 4*a*c;
            if(delta<0) return new Double[0];       //impossible equation
            else {
                if(delta ==0){                      //duplicate root equation
                    results = new Double[1];
                    results[0] = -b/(2.0*a);
                }
                else {                              //common case
                    results = new Double[2];
                    results[0] = (-b - Math.sqrt(delta))/ (2.0*a);
                    results[1] = (-b + Math.sqrt(delta))/ (2.0*a);
                }
                return results;
            }
        }

    }
}
