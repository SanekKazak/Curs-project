package org.it.funcion;

public class m {
    public static void main(String[] args) {
        Function fe = null;
        try {
            fe = ValidationService.validate("ln(x) +log( x)");
            System.out.println(fe.dif(fe));
            System.out.println(fe.insert(1.0));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
