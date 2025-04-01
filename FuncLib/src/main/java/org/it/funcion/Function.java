package org.it.funcion;

import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Function {
    String func;
    String value;

    public Function(String func, String value){
        this.func = func;
        this.value = value;
    }

    public String differential(String func) throws Exception {
        Function function = ValidationService.validate(func);
        Matcher matcher = Pattern.compile("\\b[" + this.value + "]\\^(\\d+)\\b")
                .matcher(function.func);
        while(matcher.find()){
            function.func = function.func
                    .replace(matcher.group(),
                            Integer.parseInt(matcher.group(1)) +
                                    function.value +
                                    "^" +
                                    (Integer.parseInt(matcher.group(1))-1));
        }
        matcher = Pattern.compile("exp\\(([^)]+)\\)")
                .matcher(function.func);
        while(matcher.find()){
            function.func = function.func
                    .replace(matcher.group(), differential(matcher.group(1)) + "*"+ matcher.group());
        }
        return function.func;
    }

    public double insert(Double value){
        return new ExpressionBuilder(this.func)
                .variable(this.value)
                .build()
                .setVariable(this.value, value)
                .evaluate();
    }

    @Override
    public String toString() {
        return "Function{" +
                "func=" + this.func + "}";
    }
}
