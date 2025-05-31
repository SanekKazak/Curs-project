package org.vstu.it.methods;

import org.it.funcion.Function;

import java.awt.geom.Ellipse2D;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Dihomethry {

    public Map<Map<Double, Double>, Map<Double, Double>> minimum(double firstLimit, double secondLimit, double accuracy, Function func) {
        double min, max, middle;
        var graph = Grapher.grapher.graph(firstLimit, secondLimit, func);
        var minimum = new LinkedHashMap<Double, Double>();
        while (Math.abs(secondLimit - firstLimit) > accuracy) {
            middle = (firstLimit + secondLimit) / 2;
            min = middle - accuracy * 0.1;
            max = middle + accuracy * 0.1;
            double p = func.insert(min);
            double p1 = func.insert(max);
            if (p > p1) {
                minimum.put(middle, p1);
                firstLimit = middle;
            } else if (p < p1) {
                minimum.put(middle, p);
                secondLimit = middle;
            }
        }
        Map<Map<Double, Double>, Map<Double, Double>> finalyMap = new HashMap<>();
        finalyMap.put(minimum, graph);
        return finalyMap;
    }

}
