package org.vstu.it.methods;

import org.it.funcion.Function;

public class Goldenpath{
    public double minimum(double firstLLimit,
                          double secondLimit,
                          double accuracy,
                          Function func) throws Exception {
        double x1, x2, f = 1.61803;
        while(Math.abs(secondLimit-firstLLimit) > accuracy){
            x1 = secondLimit - (secondLimit - firstLLimit)/f;
            x2 = firstLLimit + (secondLimit - firstLLimit)/f;
            if(func.insert(x1) < func.insert(x2)){
                secondLimit = x2;
            }
            if(func.insert(x1) > func.insert(x2)){
                firstLLimit = x1;
            }
        }
        return firstLLimit;
    }
}
