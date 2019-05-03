package com.topica.vn.lab20.services;

import com.topica.vn.lab20.utils.CalculateUtils;

public class Calculate implements CalculateUtils {
    @Override
    public Double devide(Double a, Double b) {
        if (b == 0.0) return null;
        else return a/b;
    }
}
