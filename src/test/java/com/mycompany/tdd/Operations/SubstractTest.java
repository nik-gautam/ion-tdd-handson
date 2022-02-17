package com.mycompany.tdd.Operations;

import com.mycompany.tdd.CalculationValidator;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class SubstractTest extends TestCase {

    @Mock
    private CalculationValidator calculationValidator;

    private final Substract substract;

    public SubstractTest() {
        MockitoAnnotations.initMocks(this);
        this.substract = new Substract(calculationValidator);
    }

    @Test
    public void testCalculate_IfLessThan100_IfMorning() {
        //Given
        int num1 = 7;
        int num2 = 2;

        //When
        Mockito.when(calculationValidator.verify()).thenReturn(true);

        int output = substract.calculate(num1, num2);

        //Then
        Assert.assertEquals(5, output);
    }

    @Test
    public void testCalculate_IfGreaterThan100_IfMorning() {
        //Given
        int num1 = 200;
        int num2 = 7;

        //When
        Mockito.when(calculationValidator.verify()).thenReturn(true);

        int output = substract.calculate(num1, num2);

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

        int output = substract.calculate(num1, num2);

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

        int output = substract.calculate(num1, num2);

        //Then
        Assert.assertEquals(0, output);
    }
}