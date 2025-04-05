package org.it.funcion;

public class m {
    public static void main(String[] args) {
        Function fe;
        try {
            fe = ValidationService.validate("sin(x)");
            System.out.println(fe);
            System.out.println(fe.dif(1));
            System.out.println(fe.dif(2));
            System.out.println(fe.dif(3));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
