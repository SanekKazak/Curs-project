package org.vstu.it.methods;

import org.it.funcion.Function;
import org.it.funcion.ValidationService;

public class Gradienth{
    public Double minimum(double currentPoint,
                          double iterationSize,
                          double accuracy,
                          Function func) throws Exception {
        double previous;
        int end = 1000;
        while(end>0){
            previous = currentPoint;
            currentPoint = currentPoint - iterationSize * ValidationService.validate(func.dif(1)).insert(currentPoint);
            if(Math.abs(previous-currentPoint)<accuracy){
                return currentPoint;
            }
            end--;
        }
        return null;
    }
}
