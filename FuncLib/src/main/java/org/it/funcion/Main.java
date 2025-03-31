package org.it.funcion;

public class Main {
    public static void main(String[] args) {
        FuncCalc calc = new FuncCalc();
        try {
            calc.setFunction("exp(x)+9");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(calc.insert(2.0));
    }
}
