package org.it.funcion;

public class Main {
    public static void main(String[] args) {
        FuncCalc calc = new FuncCalc("sin(x) + pi + exp(x)");
        System.out.println(calc.insert(1.0));
    }
}
