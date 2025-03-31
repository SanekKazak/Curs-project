package org.it.funcion;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class FuncCalc {
    private Function function;

    public FuncCalc(){
        this.function = new Function();
    }

    public void setFunction(String func) throws Exception {
        this.function.setFunction(func);
    }

    public double insert(Double value){
        return new ExpressionBuilder(function.func)
                .variable(function.value)
                .build()
                .setVariable(function.value, value)
                .evaluate();
    }
}
