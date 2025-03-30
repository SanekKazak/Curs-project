package org.it.funcion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Function {
    String func;
    String value;

    public Function(String func) {
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
    }
}
