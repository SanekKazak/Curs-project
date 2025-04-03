package org.vstu.it.methods;

import org.it.funcion.Function;
import org.it.funcion.ValidationService;

public class Main {
    public static void main(String[] args) {
        Fibonachi f = new Fibonachi();
        Dihomethry d = new Dihomethry();
        Goldenpath g = new Goldenpath();
        try {
            System.out.println(f.minimum(-90, 19, 20, ValidationService.validate("x^6-x")));
            System.out.println(d.minimum(-90, 19, 0.1, ValidationService.validate("x^6-x")));
            System.out.println(g.minimum(-90, 19, 0.1, ValidationService.validate("x^6-x")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
