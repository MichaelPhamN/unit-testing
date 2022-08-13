package com.example.unittesting.scenarioThree;

public class Calculator {
    CalculatorService calculatorService;
    public double add(double num1, double num2) {
        return calculatorService.add(num1, num2);
    }

    public double subtract(double num1, double num2) {
        return calculatorService.subtract(num1, num2);
    }

    public double multiply(double num1, double num2) {
        return calculatorService.multiply(num1, num2);
    }

    public double divide(double num1, double num2) {
        return calculatorService.divide(num1, num2);
    }
}
