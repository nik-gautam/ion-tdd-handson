package com.mycompany.tdd.Operations;

import com.mycompany.tdd.Calculation;
import com.mycompany.tdd.CalculationValidator;

public class Divide implements Calculation {

    private final CalculationValidator calculationValidator;

    public Divide(CalculationValidator calculationValidator) {
        this.calculationValidator = calculationValidator;
    }

    @Override
    public int calculate(int input1, int input2) {
        try {
            if(!calculationValidator.verify()) {
                return 0;
            }

            if(input2 == 0) {
                throw new ArithmeticException();
            }
        } catch (Exception e) {
            return 0;
        }

        int res = input1 / input2;

        if(res > 100) {
            return 0;
        }

        return input1 / input2;
    }
}
