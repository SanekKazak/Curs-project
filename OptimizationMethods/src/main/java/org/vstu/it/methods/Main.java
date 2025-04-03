package org.vstu.it.methods;

import org.it.funcion.Function;
import org.it.funcion.ValidationService;

public class Main {
    public static void main(String[] args) {
        Fibonachi f = new Fibonachi();
        Dihomethry d = new Dihomethry();
        Goldenpath g = new Goldenpath();
        Gradienth gr = new Gradienth();
        Niuthon n = new Niuthon();
        try {
            System.out.println(gr.minimum(1.0, 0.001, 0.00001, ValidationService.validate("x^6-x")));
            System.out.println(f.minimum(-90.0, 19.0, 20, ValidationService.validate("x^6-x")));
            System.out.println(d.minimum(-90.0, 19.0, 0.1, ValidationService.validate("x^6-x")));
            System.out.println(g.minimum(-90.0, 19.0, 0.1, ValidationService.validate("x^6-x")));
            System.out.println(n.minimum(1.0, 0.00001, ValidationService.validate("x^6-x")));
            for(int i = 0; i<10; i++){
                System.out.println(n.minimum(1.0, 0.00001, ValidationService.validate("x^6-x")));

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
