package org.vstu.it.methods;

import org.it.funcion.Function;
import org.it.funcion.ValidationService;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Gradienth {
    private int iterations = 1000;

    public Gradienth() {
    }

    public Gradienth(int iterations) {
        if (iterations > 0) {
            this.setIterations(iterations);
        }

    }

    public Map<Double, Double> minimum(double currentPoint, double iterationSize, double accuracy, Function func) throws Exception {

        Double y;
        Map<Double, Double> minimum = new LinkedHashMap();

        for(int i = 0; i < this.iterations; ++i) {
            double previous = currentPoint;
            currentPoint -= iterationSize * ValidationService.validate(func.dif(1)).insert(currentPoint);
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
