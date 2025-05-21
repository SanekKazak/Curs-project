package org.vstu.it.methods;

import org.it.funcion.Function;
import org.it.funcion.ValidationService;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Niuthon {
    private int iterations = 1000;

    public Niuthon() {
    }

    public Niuthon(int iterations) {
        if (iterations > 0) {
            this.setIterations(iterations);
        }

    }

    public Map<Double, Double> minimum(double currentPoint, double accuracy, Function func) throws Exception {

        Double y;
        Map<Double, Double> minimum = new LinkedHashMap();

        for(int i = 0; i < this.iterations; ++i) {
            double previous = currentPoint;
            Function d_1 = ValidationService.validate(func.dif(1));
            Function d_2 = ValidationService.validate(func.dif(2));
            currentPoint -= d_1.insert(currentPoint) / d_2.insert(currentPoint);
            y = func.insert(currentPoint);
            minimum.put(y, currentPoint);
            if (Math.abs(previous - currentPoint) < accuracy) {
                return minimum;
            }
        }

        return null;
    }

    private void setIterations(int iterations) {
        this.iterations = iterations;
    }
}
