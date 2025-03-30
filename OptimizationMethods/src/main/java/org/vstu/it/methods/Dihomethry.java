package org.vstu.it.methods;

import org.it.funcion.FuncCalc;
import org.vstu.it.interfaces.Minimum;

public class Dihomethry implements Minimum {
    public static void main(String[] args) {
        Dihomethry dihomethry = new Dihomethry();
        System.out.println(        dihomethry.minimum(-1, 89, 0.001, "sin(x) + pi + exp(x)")
);
    }
    @Override
    public double minimum(double firstLLimit, double secondLimit, double accuracy, String func) {
        FuncCalc calc = new FuncCalc(func);
        double min, max, middle=(firstLLimit+secondLimit)/2;
        while(Math.abs(secondLimit - firstLLimit) > accuracy){
            middle = (firstLLimit+secondLimit)/2;
            min = middle - accuracy*0.1;
            max = middle + accuracy*0.1;
            double p = calc.insert(min);
            double p1 = calc.insert(max);
            if(p > p1){
                firstLLimit = middle;
            } else if(p < p1){
                secondLimit = middle;
            }
        }
        return middle;
    }

}
