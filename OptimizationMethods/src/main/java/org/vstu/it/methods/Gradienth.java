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

    public Map<Map<Double, Double>, Map<Double, Double>> minimum(double currentPoint, double iterationSize, double accuracy, Function func) throws Exception {

        Map<Double, Double> minimum = new LinkedHashMap();
        var graph = Grapher.grapher.graph(-1000.0, 1000.0, func);
        for(int i = 0; i < this.iterations; ++i) {
            double previous = currentPoint;
            currentPoint -= iterationSize * ValidationService.validate(func.dif(1)).insert(currentPoint);
            minimum.put(currentPoint, func.insert(currentPoint));
            if (Math.abs(previous - currentPoint) < accuracy) {
                Map<Map<Double, Double>, Map<Double, Double>> finalyMap = new HashMap<>();
                finalyMap.put(minimum, graph);
                return finalyMap;
            }
        }

        return null;
    }

    private void setIterations(int iterations) {
        this.iterations = iterations;
    }
}
