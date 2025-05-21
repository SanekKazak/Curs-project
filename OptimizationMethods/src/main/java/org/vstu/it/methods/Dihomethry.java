package org.vstu.it.methods;

import org.it.funcion.Function;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Dihomethry {

    public Map<Double, Double> minimum(double firstLimit, double secondLimit, double accuracy, Function func){
        Double middle;
        Double y;
        Map<Double, Double> minimum = new LinkedHashMap();

        while(Math.abs(secondLimit - firstLimit) > accuracy) {
            middle = (firstLimit + secondLimit) / (double)2.0F;
            double min = middle - accuracy * 0.1;
            double max = middle + accuracy * 0.1;
            double p = func.insert(min);
            double p1 = func.insert(max);
            if (p > p1) {
                firstLimit = middle;
                y = func.insert(middle);
                minimum.put(y, middle);
            } else if (p < p1) {
                secondLimit = middle;
                y = func.insert(middle);
                minimum.put(y, middle);
            }
        }

        return minimum;
    }
}
