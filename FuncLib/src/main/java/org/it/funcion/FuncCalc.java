package org.it.funcion;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class FuncCalc {
    private Function function;

    public FuncCalc(String function) {
        this.function = new Function(function);
    }

    public double insert(Double value){
        String insert = function
                .func
                .replaceAll("\\b" + value + "\\b|(?<=\\W)" + value + "(?=\\W)|^" + value + "(?=\\W)|(?<=\\W)" + value + "$", function.value.toUpperCase());
        insert = insert.replace(function.value, value.toString()).replaceAll(function.value.toUpperCase(), function.value);
        return new ExpressionBuilder(insert)
                .build()
                .evaluate();
    }
}
