package org.it.funcion;

import org.it.exception.NullFuncException;

public class Main {
    public static void main(String[] args) {
        FuncCalc calc = null;
        try {
            calc = new FuncCalc("exp(x)+9");
            System.out.println(calc.insert(2.0));
        } catch (NullFuncException e) {
            System.out.println(e.getMessage());
        }
    }
}
