package org.vstu.it.methods;

import org.it.funcion.Function;

public class Goldenpath {

    public double minimum(double firstLimit, double secondLimit, double accuracy, Function func){
        double f = 1.61803;

        while(Math.abs(secondLimit - firstLimit) > accuracy) {
            double x1 = secondLimit - (secondLimit - firstLimit) / f;
            double x2 = firstLimit + (secondLimit - firstLimit) / f;
            if (func.insert(x1) < func.insert(x2)) {
                secondLimit = x2;
            }

            if (func.insert(x1) > func.insert(x2)) {
                firstLimit = x1;
            }
        }

        return firstLimit;
    }
}
