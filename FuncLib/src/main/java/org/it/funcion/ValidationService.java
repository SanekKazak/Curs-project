package org.it.funcion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationService {
    public static Function validate(String func) throws Exception {
        String variable = "";
        if(!func.isEmpty() && func.matches(".*[a-zA-Z0-9].*")){
            String matcher = func.toLowerCase()
                    .replace("sin", "")
                    .replace("cos", "")
                    .replace("tan", "")
                    .replace("ctan", "")
                    .replace("exp", "")
                    .replace("pi", "");
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
        return new Function(func.toLowerCase(), variable);
    }
}
