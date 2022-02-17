package com.mycompany.tdd.Operations;

import com.mycompany.tdd.Calculation;
import com.mycompany.tdd.CalculationValidator;

public class Multiply implements Calculation {

    private final CalculationValidator calculationValidator;

    public Multiply(CalculationValidator calculationValidator) {
        this.calculationValidator = calculationValidator;
    }

    @Override
    public int calculate(int input1, int input2) {
        int result = input1 * input2;

        try {
            if(!calculationValidator.verify()) {
                return 0;
            }
        } catch (Exception e) {
            return 0;
        }

        if (result > 100) {
            return 0;
        }

        return result;
    }
}
