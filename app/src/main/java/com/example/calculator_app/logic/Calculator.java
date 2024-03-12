package com.example.calculator_app.logic;

import java.util.ArrayList;

public class Calculator {
    public final PostfixConverter converter;
    public final SequentialConverter seqConverter;
    public final PostfixEvaluator evaluator;

    public Calculator() {
        converter = new PostfixConverter();
        seqConverter = new SequentialConverter();
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

        // add decimal only if necessary
        if (result - Math.floor(result) > 0)
            return Double.toString(result);
        return Integer.toString((int) result);
    }

    public String calculateSequentially(String mathExpression) {
        ArrayList<String> postfixExpression = seqConverter.convertSequentially(mathExpression);
        double result;

        try {
            result = evaluator.evaluate(postfixExpression);
        } catch (ArithmeticException ae) {
            return "Invalid Division";
        } catch (IllegalArgumentException ae) {
            return "Math Error";
        }

        // add decimal only if necessary
        if (result - Math.floor(result) > 0)
            return Double.toString(result);
        return Integer.toString((int) result);
    }
}
