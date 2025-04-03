package org.vstu.it.methods;

import org.it.funcion.Function;
import org.it.funcion.ValidationService;

public class Gradienth{
    public Double minimum(double currentPoint,
                          double iterationSize,
                          double accuracy,
                          Function func) throws Exception {
        double previous;
        boolean end = false;
        while(!end){
            previous = currentPoint;
            currentPoint = currentPoint - iterationSize * ValidationService.validate(func.dif(1)).insert(currentPoint);
            if(Math.abs(previous-currentPoint)<accuracy){
                return currentPoint;
            }
        }
        return null;
    }
}
