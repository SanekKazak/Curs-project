package org.vstu.it.methods;

import org.it.funcion.Function;

public class Dihomethry {
    public double minimum(double firstLLimit,
                          double secondLimit,
                          double accuracy,
                          Function func) throws Exception {
        double min, max, middle = (firstLLimit + secondLimit) / 2;
        while (Math.abs(secondLimit - firstLLimit) > accuracy) {
            middle = (firstLLimit + secondLimit) / 2;
            min = middle - accuracy * 0.1;
            max = middle + accuracy * 0.1;
            double p = func.insert(min);
            double p1 = func.insert(max);
            if (p > p1) {
                firstLLimit = middle;
            } else if (p < p1) {
                secondLimit = middle;
            }
        }
        return firstLLimit;
    }
}
