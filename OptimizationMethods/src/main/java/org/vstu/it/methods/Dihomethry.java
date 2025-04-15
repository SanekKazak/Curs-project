package org.vstu.it.methods;

import org.it.funcion.Function;

public class Dihomethry {

    public double minimum(double firstLimit, double secondLimit, double accuracy, Function func){
        double middle;

        while(Math.abs(secondLimit - firstLimit) > accuracy) {
            middle = (firstLimit + secondLimit) / (double)2.0F;
            double min = middle - accuracy * 0.1;
            double max = middle + accuracy * 0.1;
            double p = func.insert(min);
            double p1 = func.insert(max);
            if (p > p1) {
                firstLimit = middle;
            } else if (p < p1) {
                secondLimit = middle;
            }
        }

        return firstLimit;
    }
}
