package com.example.calculator;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CalculatorViewModel extends ViewModel {
    private final MutableLiveData<String> expression = new MutableLiveData<>("");
    private final MutableLiveData<String> result = new MutableLiveData<>("");
    private final CalculatorModel model;

    public CalculatorViewModel() {
        model = new CalculatorModel();
    }

    public LiveData<String> getExpression(){
        return expression;
    }

    public LiveData<String> getResult(){
        return result;
    }

    public void appendToExpression(String value){
        expression.setValue(expression.getValue() + value);
    }

    public void clearExpression(){
        expression.setValue("");
        result.setValue("");
    }

    public void deleteLastDigit(){
        String exp = expression.getValue();
        if (exp != null && !exp.isEmpty()){
            expression.setValue(exp.substring(0, exp.length() - 1));
        }
    }

    public void evaluateExpression(){
        String res = model.evaluateExpression(expression.getValue());
        result.setValue(res);
    }
}

