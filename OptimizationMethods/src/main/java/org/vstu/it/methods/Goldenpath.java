package org.vstu.it.methods;

import org.it.funcion.Function;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Goldenpath {

    public Map<Double, Double> minimum(double firstLimit, double secondLimit, double accuracy, Function func){
        double f = 1.61803;
        Double y;
        Map<Double, Double> minimum = new LinkedHashMap();

        while(Math.abs(secondLimit - firstLimit) > accuracy) {
            double x1 = secondLimit - (secondLimit - firstLimit) / f;
            double x2 = firstLimit + (secondLimit - firstLimit) / f;
            if (func.insert(x1) < func.insert(x2)) {
                secondLimit = x2;
                y = func.insert(secondLimit);
                minimum.put(y, secondLimit);
            }

            if (func.insert(x1) > func.insert(x2)) {
                firstLimit = x1;
                y = func.insert(firstLimit);
                minimum.put(y, firstLimit);
            }
        }

        return minimum;
    }
}
