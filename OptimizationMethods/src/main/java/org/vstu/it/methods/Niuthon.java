package org.vstu.it.methods;

import org.it.funcion.Function;
import org.it.funcion.ValidationService;

public class Niuthon{
    public Double minimum(double currentPoint,
                          double accuracy,
                          Function func) throws Exception {
        double previous;
        int end = 1000;
        while(end>0){
            previous = currentPoint;
            currentPoint = currentPoint -
                    ValidationService.validate(func.dif(1)).insert(currentPoint) /
                            ValidationService.validate(func.dif(2)).insert(currentPoint);
            if(Math.abs(previous-currentPoint)<accuracy){
                return currentPoint;
            }
            end--;
        }
        return null;
    }
}
