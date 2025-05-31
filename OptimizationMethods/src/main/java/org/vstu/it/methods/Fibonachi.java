package org.vstu.it.methods;

import org.it.funcion.Function;

import java.util.*;

public class Fibonachi {

    public Map<Map<Double, Double>, Map<Double, Double>> minimum(double firstLimit, double secondLimit, Integer accuracy, Function func) {
        var list = this.fibonachiSequence(accuracy);
        Map<Double, Double> minimum = new LinkedHashMap();
        var graph = Grapher.grapher.graph(firstLimit, secondLimit, func);
        while(accuracy > 2) {
            accuracy = accuracy - 1;
            double x1 = firstLimit + list.get(accuracy - 2) / list.get(accuracy) * (secondLimit - firstLimit);
            double x2 = firstLimit + list.get(accuracy - 1) / list.get(accuracy) * (secondLimit - firstLimit);
            double f1 = func.insert(x1);
            double f2 = func.insert(x2);
            if (f1 > f2) {
                firstLimit = x1;
                minimum.put(firstLimit, f2);
            }

            if (f1 < f2) {
                secondLimit = x2;
                minimum.put(secondLimit, f1);
            }
        }

        Map<Map<Double, Double>, Map<Double, Double>> finalyMap = new HashMap<>();
        finalyMap.put(minimum, graph);
        return finalyMap;
    }

    public List<Double> fibonachiSequence(int value) {
        List<Double> list = new ArrayList<>();
        list.add((double)0.0F);
        list.add((double)1.0F);

        for(int i = 2; i < value; ++i) {
            Double el = list.get(i - 1) + list.get(i - 2);
            list.add(el);
        }

        return list;
    }
}