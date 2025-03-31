package org.vstu.it.methods;

import org.it.funcion.FuncCalc;
import org.it.funcion.Function;
import org.vstu.it.interfaces.Minimum;

public class Fibonachi implements Minimum {
    @Override
    public double minimum(double firstLLimit,
                          double secondLimit,
                          double accuracy,
                          String func) throws Exception {
        Function function = new Function(func);
        FuncCalc calc = new FuncCalc(function);
        double min, max, middle = (firstLLimit + secondLimit) / 2;
        while (Math.abs(secondLimit - firstLLimit) > accuracy) {
            middle = (firstLLimit + secondLimit) / 2;
            min = middle - accuracy * 0.1;
            max = middle + accuracy * 0.1;
            double p = calc.insert(min);
            double p1 = calc.insert(max);
            if (p > p1) {
                firstLLimit = middle;
            } else if (p < p1) {
                secondLimit = middle;
            }
        }
        return middle;
    }
}
