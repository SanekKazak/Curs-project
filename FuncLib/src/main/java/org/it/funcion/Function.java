package org.it.funcion;

import org.it.exception.NullFuncException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Function {
    String func;
    String value;

    public Function(String func) throws NullFuncException {
        List<String> matchers = new ArrayList<>();
        if(!func.isEmpty() && func.matches(".*[a-zA-Z0-9].*")){
            this.func = func.toLowerCase();
            String matcher = func.toLowerCase()
                    .replace("sin", "")
                    .replace("cos", "")
                    .replace("tan", "")
                    .replace("ctan", "")
                    .replace("exp", "")
                    .replace("pi", "");
            Matcher notRegularValues = Pattern.compile("[a-z]")
                    .matcher(matcher);
            if(notRegularValues.find()){
                value = notRegularValues.group();
            }
            while(notRegularValues.find()){
                matchers.add(notRegularValues.group());
            }
            if(!matchers.isEmpty()){
                if(matchers.stream()
                        .anyMatch(x -> !x.equals(value))
                ){
                    throw new NullFuncException("extra variable");
                }
            }
            if(func.matches(".*[^a-zA-Z0-9/*+\\-^()].*")){
                throw new NullFuncException("extra symbols");
            }
        } else {
            throw new NullFuncException("function is empty");
        }
    }
}
