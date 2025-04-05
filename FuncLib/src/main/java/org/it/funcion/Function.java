package org.it.funcion;

import org.matheclipse.core.eval.ExprEvaluator;

public class Function {
    String func;
    String variable;

    public Function(String func, String value){
        this.func = func;
        this.variable = value;
    }

    /*
    Подстановка значения value в функцию привязанную
    к экземпляру, который вызвал метод.
     */
    public Double insert(Double value){
        return new ExprEvaluator()
                .evaluate("N(Evaluate((" +
                        this.func +
                        ") /. " +
                        this.variable +
                        " -> " +
                        value + "))")
                .toDoubleDefault();
    }
    public void dif(){
        this.func = (difCalc() != null) ? difCalc().func : this.func;
    }

    public String dif(int iterations) throws Exception {
        Function func = ValidationService.validate(this.func);
        while(iterations>0){
            func.dif();
            iterations--;
        }
        return func.func;
    }


    /*
    Метод dif вычисляет производную математической функции,
    хранящейся в экземпляре функции, по вложенной переменной.
    Если в параметре передан: FALSE вернет получившийся дифференциал,
    TRUE изменит тот экземпляр на котором был вызван метод.
    */
    private Function difCalc(){
        ExprEvaluator evaluator = new ExprEvaluator(false, (short) 20);
        Function result;
        try {
            result = ValidationService
                    .validate(evaluator.evaluate("D("+
                                    this.func+
                                    " ,"+
                                    this.variable +
                                    ")")
                            .toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public String toString() {
        return this.func;
    }
}
