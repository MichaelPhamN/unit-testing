package com.example.unittesting.scenarioOne;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
class CalculatorAlgorithm implements CalculatorService {
    @Override
    public double add(double num1, double num2) { return num1 + num2;}

    @Override
    public double subtract(double num1, double num2) {return num1 - num2;}

    @Override
    public double multiply(double num1, double num2) {return num1 * num2;}

    @Override
    public double divide(double num1, double num2) {return num1 / num2;}
}
public class CalculatorTest {
    private Calculator calculator;
    @Before
    public void setUp() {
        calculator = new Calculator();
        calculator.setCalculatorService(new CalculatorAlgorithm());
    }
    @Test
    public void add() {
        double expectedResult = 15.0;
        Assert.assertEquals(expectedResult, calculator.add(10.0,5.0),0.00001);
    }
    @Test
    public void subtract() {
        double expectedResult = 5.0;
        Assert.assertEquals(expectedResult, calculator.subtract(10.0,5.0),0.00001);
    }
    @Test
    public void multiply() {
        double expectedResult = 50.0;
        Assert.assertEquals(expectedResult, calculator.multiply(10.0,5.0),0.00001);
    }
    @Test
    public void divide() {
        double expectedResult = 2.0;
        Assert.assertEquals(expectedResult, calculator.divide(10.0,5.0),0.00001);
    }
}