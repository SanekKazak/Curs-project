package org.it.funcion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Function {
    private String func;
    private Map<String, Double> values = new HashMap<>();

    public Function(String func) {
        this.func = func;
        Matcher notRegularValues = Pattern.compile("[a-z]").matcher(func);
        while (notRegularValues.find()) {
            values.put(notRegularValues.group(), null);
        }
    }

    public void Insert(){

    }
}
