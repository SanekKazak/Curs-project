package org.vstu.it.methods;

import org.it.funcion.Function;
import java.util.ArrayList;
import java.util.List;

public class Fibonachi {
    public double minimum(double firstLLimit,
                          double secondLimit,
                          Integer accuracy,
                          Function func) {
        List<Double> list = fibonachiSequence(accuracy);
        double x1, x2, f1, f2;
        while (accuracy > 2) {
            accuracy--;
            x1 = firstLLimit+list.get(accuracy-2)/list.get(accuracy)*(secondLimit-firstLLimit);
            x2 = firstLLimit+list.get(accuracy-1)/list.get(accuracy)*(secondLimit-firstLLimit);
            f1 = func.insert(x1);
            f2 = func.insert(x2);
            if(f1>f2){
                firstLLimit = x1;
            }
            if(f1<f2){
                secondLimit = x2;
            }
        }
        return firstLLimit;
    }

    public List<Double> fibonachiSequence(int value){
        List<Double> list = new ArrayList<>();
        list.add(0.0);
        list.add(1.0);
        for(int i =2; i<value; i++){
            Double el = list.get(i-1)+list.get(i-2);
            list.add(el);
        }
        return list;
    }

}
