package org.it.funcion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationService {
    public static Function validate(String func) throws Exception {
        String variable = "";
        func=func.replaceAll(" ", "");
        if(!func.isEmpty() && func.matches(".*[a-zA-Z0-9].*")){
            String matcher = func
                    .replace("sinh", "")
                    .replace("coth", "")
                    .replace("tanh", "")
                    .replace("cosh", "")
                    .replace("asin", "")
                    .replace("atan", "")
                    .replace("acos", "")
                    .replace("sin", "")
                    .replace("cos", "")
                    .replace("cot", "")
                    .replace("tan", "")
                    .replace("ln", "")
                    .replace("log", "")
                    .replace("exp", "")
                    .replace("pi", "")
                    .replace("sech", "")
                    .replace("csch", "")
                    .replace("sec", "")
                    .replace("csc", "")
                    .replace("e", "");
            Matcher notRegularValues = Pattern.compile("[a-z]")
                    .matcher(matcher);
            if (notRegularValues.find()) {
                variable = notRegularValues.group();
            }
            while (notRegularValues.find()) {
                if(!notRegularValues.group().equals(variable)){
                    throw new Exception("extra variable");
                }
            }
            if (func.matches(".*[^a-zA-Z0-9/*+\\-^()].*")) {
                throw new Exception("extra symbols");
            }
        }else {
            throw new Exception("function is empty");
        }
        return new Function(func.replaceAll(" ", ""), variable);
    }
}
