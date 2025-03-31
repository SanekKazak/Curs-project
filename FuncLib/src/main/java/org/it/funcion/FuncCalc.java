package org.it.funcion;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.it.exception.NullFuncException;

public class FuncCalc {
    private Function function;

    public FuncCalc(String function) throws NullFuncException {
        this.function = new Function(function);
    }

    public void setFunction(Function function){
        this.function = function;
    }

    public double insert(Double value){
        return new ExpressionBuilder(function.func)
                .variable(function.value)
                .build()
                .setVariable(function.value, value)
                .evaluate();
    }
}
