package org.vstu.it.methods;

import org.vstu.it.interfaces.Minimum;

public class Dihomethry implements Minimum {
    private double firstLLimit;
    private double secondLimit;
    private double accuracy;

    @Override
    public void minimum() {
        double x1 = (firstLLimit+secondLimit)/2 - accuracy*0.01;
        double x2 = (firstLLimit+secondLimit)/2 + accuracy*0.01;

    }



}
