package com.mycompany.tdd.Operations;

import com.mycompany.tdd.CalculationValidator;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class DivideTest extends TestCase {

    @Mock
    private CalculationValidator calculationValidator;

    private final Divide divide;

    public DivideTest() {
        MockitoAnnotations.initMocks(this);
        this.divide = new Divide(calculationValidator);
    }

    @Test
    public void testCalculate_IfLessThan100_IfMorning() {
        //Given
        int num1 = 100;
        int num2 = 2;

        //When
        Mockito.when(calculationValidator.verify()).thenReturn(true);

        int output = divide.calculate(num1, num2);

        //Then
        Assert.assertEquals(50, output);
    }

    @Test
    public void testCalculate_IfGreaterThan100_IfMorning() {
        //Given
        int num1 = 250;
        int num2 = 2;

        //When
        Mockito.when(calculationValidator.verify()).thenReturn(true);

        int output = divide.calculate(num1, num2);

        //Then
        Assert.assertEquals(0, output);
    }

    @Test
    public void testCalculate_IfDivisorIsZero_IfMorning() {
        //Given
        int num1 = 2;
        int num2 = 0;

        //When
        Mockito.when(calculationValidator.verify()).thenReturn(true);

        int output = divide.calculate(num1, num2);

        //Then
        Assert.assertEquals(0, output);
    }

    @Test
    public void testCalculate_IfNight() {
        //Given
        int num1 = 40;
        int num2 = 4;

        //When
        Mockito.when(calculationValidator.verify()).thenReturn(false);

        int output = divide.calculate(num1, num2);

        //Then
        Assert.assertEquals(0, output);
    }

    @Test
    public void testCalculate_IfTimeUnknown() {
        //Given
        int num1 = 40;
        int num2 = 4;

        //When
        Mockito.when(calculationValidator.verify()).thenThrow(new RuntimeException());

        int output = divide.calculate(num1, num2);

        //Then
        Assert.assertEquals(0, output);
    }
}