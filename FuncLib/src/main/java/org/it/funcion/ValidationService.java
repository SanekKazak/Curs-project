package org.it.funcion;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationService {
    public ValidationService() {
    }

    public static Function validate(String func) throws Exception {
        String variable = "";
        func = func.replaceAll(" ", "");
        if (func.contains("()")) {
            throw new Exception("Function without include");
        } else if (!func.isEmpty() && func.matches(".*[a-zA-Z0-9].*")) {
            List<String> list = List.of(
                    "sinh", "coth", "tanh", "cosh", "asin", "atan",
                    "acos", "sin", "cos", "cot", "tan", "ln", "log",
                    "exp", "pi", "sech", "csch", "sec", "csc", "Sinh",
                    "Coth", "Tanh", "Cosh", "Asin", "Atan", "Acos",
                    "Sin", "Cos", "Cot", "Tan", "Ln", "Log", "Exp",
                    "Pi", "Sech", "Csch", "Sec", "Csc"
            );
            String matcher = func;

            for(String extra : list) {
                matcher = matcher.replaceAll(extra, "");
            }

            Matcher notRegularValues = Pattern.compile("[a-z]").matcher(matcher);
            if (notRegularValues.find()) {
                variable = notRegularValues.group();

                while(notRegularValues.find()) {
                    if (!notRegularValues.group().equals(variable)) {
                        throw new Exception("Extra variable");
                    }
                }

                if (func.matches(".*[^a-zA-Z0-9/*+\\-^()].*")) {
                    throw new Exception("Extra symbols");
                }
            }
        } else {
            throw new Exception("Function is empty");
        }
        return new Function(func, variable);
    }
}
