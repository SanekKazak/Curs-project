package org.vstu.it.methods;

import org.it.funcion.Function;
import org.it.funcion.ValidationService;

public class Gradienth {
    private int iterations = 1000;

    public Gradienth() {
    }

    public Gradienth(int iterations) {
        if (iterations > 0) {
            this.setIterations(iterations);
        }

    }

    public Double minimum(double currentPoint, double iterationSize, double accuracy, Function func) throws Exception {
        for(int i = 0; i < this.iterations; ++i) {
            double previous = currentPoint;
            currentPoint -= iterationSize * ValidationService.validate(func.dif(1)).insert(currentPoint);
            if (Math.abs(previous - currentPoint) < accuracy) {
                return currentPoint;
            }
        }

        return null;
    }

    private void setIterations(int iterations) {
        this.iterations = iterations;
    }
}
