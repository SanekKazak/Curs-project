package org.vstu.it.methods;

import org.it.funcion.Function;

import java.util.*;

public class Fibonachi {

    public Map<Double, Double> minimum(double firstLimit, double secondLimit, Integer accuracy, Function func) {
        List<Double> list = this.fibonachiSequence(accuracy);
        Double y;
        Map<Double, Double> minimum = new LinkedHashMap();

        while(accuracy > 2) {
            accuracy = accuracy - 1;
            double x1 = firstLimit + list.get(accuracy - 2) / list.get(accuracy) * (secondLimit - firstLimit);
            double x2 = firstLimit + list.get(accuracy - 1) / list.get(accuracy) * (secondLimit - firstLimit);
            double f1 = func.insert(x1);
            double f2 = func.insert(x2);
            if (f1 > f2) {
                firstLimit = x1;
                y = func.insert(firstLimit);
                minimum.put(y, firstLimit);
            }

            if (f1 < f2) {
                secondLimit = x2;
                y = func.insert(secondLimit);
                minimum.put(y, secondLimit);
            }
        }

        return minimum;
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