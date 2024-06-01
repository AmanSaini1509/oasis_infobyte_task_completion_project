package com.example.calculator;


import com.ezylang.evalex.EvaluationException;
import com.ezylang.evalex.Expression;
import com.ezylang.evalex.parser.ParseException;

import java.math.BigDecimal;

public class CalculatorModel {

    public String evaluateExpression(String expressionText) {
        try {
            Expression expression = new Expression(expressionText);
            BigDecimal result = expression.evaluate().getNumberValue();
            return result.toString();
        } catch (EvaluationException | ParseException e) {
            throw new RuntimeException(e);
        }
    }


}
