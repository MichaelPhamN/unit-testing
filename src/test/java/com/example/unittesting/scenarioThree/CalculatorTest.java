package com.example.unittesting.scenarioThree;

import com.example.unittesting.scenarioTwo.Calculator;
import com.example.unittesting.scenarioTwo.CalculatorService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorTest {
    @InjectMocks
    private Calculator calculator;
    @Mock
    private CalculatorService calculatorService;
    @Test
    public void add() {
        when(calculatorService.add(10.0,5.0)).thenReturn(15.0);
        //verify the first input must be 10.0 and the second input must be 5.0
        verify(calculatorService).add(10.0,5.0);
        double exceptedResult = 15.0;
        Assert.assertEquals(exceptedResult, calculator.add(5.0, 10.0),0.0001);
    }
    @Test
    public void subtract() {
        when(calculatorService.subtract(10.0,5.0)).thenReturn(5.0);
        //verify the first input must be 10.0 and the second input must be 5.0
        verify(calculatorService).add(10.0,5.0);
        double exceptedResult = 5.0;
        Assert.assertEquals(exceptedResult, calculator.subtract(10.0, 5.0),0.0001);
    }
    @Test
    public void multiply() {
        when(calculatorService.multiply(10.0,5.0)).thenReturn(50.0);
        //verify the first input must be 10.0 and the second input must be 5.0
        verify(calculatorService).add(10.0,5.0);
        double exceptedResult = 50.0;
        Assert.assertEquals(exceptedResult, calculator.multiply(10.0, 5.0),0.0001);
    }

    @Test
    public void divide() {
        when(calculatorService.divide(10.0,5.0)).thenReturn(2.0);
        //verify the first input must be 10.0 and the second input must be 5.0
        verify(calculatorService).add(10.0,5.0);
        double exceptedResult = 2.0;
        Assert.assertEquals(exceptedResult, calculator.divide(10.0, 5.0),0.0001);
    }
}