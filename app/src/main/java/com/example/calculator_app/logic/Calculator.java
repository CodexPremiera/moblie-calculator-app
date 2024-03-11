package com.example.calculator_app.logic;

import java.util.ArrayList;

public class Calculator {
    public final InfixToPostfixConverter converter;
    public final PostfixEvaluator evaluator;

    public Calculator() {
        converter = new InfixToPostfixConverter();
        evaluator = new PostfixEvaluator();
    }

    public String calculate(String mathExpression) {
        ArrayList<String> postfixExpression = converter.convertToPostfix(mathExpression);
        double result;

        try {
            result = evaluator.evaluate(postfixExpression);
        } catch (ArithmeticException ae) {
            return "Invalid Division";
        } catch (IllegalArgumentException ae) {
            return "Math Error";
        }

        return Double.toString(result);
    }
}
