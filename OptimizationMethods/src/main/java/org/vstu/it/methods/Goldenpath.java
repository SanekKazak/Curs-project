package org.vstu.it.methods;

import org.it.funcion.Function;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Goldenpath {

    public Map<Map<Double, Double>, Map<Double, Double>> minimum(double firstLimit, double secondLimit, double accuracy, Function func){
        double f = 1.61803;
        Map<Double, Double> minimum = new LinkedHashMap();
        var graph = Grapher.grapher.graph(firstLimit, secondLimit, func);
        while(Math.abs(secondLimit - firstLimit) > accuracy) {
            double x1 = secondLimit - (secondLimit - firstLimit) / f;
            double x2 = firstLimit + (secondLimit - firstLimit) / f;
            double f1 = func.insert(x1);
            double f2 = func.insert(x2);
            if (f1 < f2) {
                secondLimit = x2;
                minimum.put(secondLimit, f1);
            }

            if (f1 > f2) {
                firstLimit = x1;
                minimum.put(firstLimit, f2);
            }
        }

        Map<Map<Double, Double>, Map<Double, Double>> finalyMap = new HashMap<>();
        finalyMap.put(minimum, graph);
        return finalyMap;
    }
}
