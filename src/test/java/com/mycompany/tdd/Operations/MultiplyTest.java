package com.mycompany.tdd.Operations;

import com.mycompany.tdd.CalculationValidator;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class MultiplyTest extends TestCase {

    @Mock
    private CalculationValidator calculationValidator;

    private final Multiply multiply;

    public MultiplyTest() {
        MockitoAnnotations.initMocks(this);
        this.multiply = new Multiply(calculationValidator);
    }

    @Test
    public void testCalculate_IfLessThan100_IfMorning() {
        //Given
        int num1 = 2;
        int num2 = 7;

        //When
        Mockito.when(calculationValidator.verify()).thenReturn(true);

        int output = multiply.calculate(num1, num2);

        //Then
        Assert.assertEquals(14, output);
    }

    @Test
    public void testCalculate_IfGreaterThan100_IfMorning() {
        //Given
        int num1 = 200;
        int num2 = 7;

        //When
        Mockito.when(calculationValidator.verify()).thenReturn(true);

        int output = multiply.calculate(num1, num2);

        //Then
        Assert.assertEquals(0, output);
    }

    @Test
    public void testCalculate_IfNight() {
        //Given
        int num1 = 19;
        int num2 = 4;

        //When
        Mockito.when(calculationValidator.verify()).thenReturn(false);

        int output = multiply.calculate(num1, num2);

        //Then
        Assert.assertEquals(0, output);
    }

    @Test
    public void testCalculate_IfTimeUnknown() {
        //Given
        int num1 = 19;
        int num2 = 4;

        //When
        Mockito.when(calculationValidator.verify()).thenThrow(new RuntimeException());

        int output = multiply.calculate(num1, num2);

        //Then
        Assert.assertEquals(0, output);
    }
}