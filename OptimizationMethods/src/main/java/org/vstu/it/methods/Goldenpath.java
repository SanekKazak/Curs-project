package org.vstu.it.methods;

import org.it.funcion.FuncCalc;
import org.it.funcion.Function;
import org.vstu.it.interfaces.Minimum;

public class Goldenpath implements Minimum {
    @Override
    public double minimum(double firstLLimit,
                          double secondLimit,
                          double accuracy,
                          String func) throws Exception {
        Function function = new Function(func);
        FuncCalc calc = new FuncCalc(function);
        double x1, x2, f = 1.61803;
        while(Math.abs(secondLimit-firstLLimit) > accuracy){
            x1 = secondLimit - (secondLimit - firstLLimit)/f;
            x2 = firstLLimit + (secondLimit - firstLLimit)/f;
            if(calc.insert(x1) < calc.insert(x2)){
                secondLimit = x2;
            }
            if(calc.insert(x1) > calc.insert(x2)){
                firstLLimit = x1;
            }
        }
        return firstLLimit;
    }
}
