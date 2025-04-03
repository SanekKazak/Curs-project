package org.it.funcion;

import org.matheclipse.core.eval.ExprEvaluator;

public class Function {
    String func;
    String variable;

    public Function(String func, String value){
        this.func = func;
        this.variable = value;
    }

    public Double insert(Double value){
        return new ExprEvaluator()
                .evaluate("N(Evaluate((" + this.func + ") /. " + this.variable + " -> " + value + "))")
                .toDoubleDefault();
    }

    public String dif(Function func){
        ExprEvaluator evaluator = new ExprEvaluator(false, (short) 20);
        return evaluator.evaluate("D("+func.func+" ,"+func.variable +")")
                .toString();
    }

    @Override
    public String toString() {
        return "Function{" +
                "func=" + this.func + "}";
    }
}
