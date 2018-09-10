package com.inweo.rpn;

import com.inweo.rpn.calculate.Calculator;
import com.inweo.rpn.calculate.RPNCalculator;
import com.inweo.rpn.handler.ResponseHandler;
import com.inweo.rpn.model.RPNResult;
import com.inweo.rpn.provider.DataProvider;


import java.util.List;

public class ReversePolishNotationService {

    private Calculator calculator = new RPNCalculator();

    private DataProvider dataProvider;

    private ResponseHandler responseHandler;

    public ReversePolishNotationService(DataProvider dataProvider, ResponseHandler responseHandler) {

        if (dataProvider == null || responseHandler == null) {
            throw new IllegalArgumentException("Unable to initialize ReversePolishNotationService");
        }

        this.dataProvider = dataProvider;
        this.responseHandler = responseHandler;
    }

    public void handleExpression(String inputExpression) {

        List<String> expressions = dataProvider.provide(inputExpression);

        expressions.stream().forEach(expression -> {
            RPNResult result = new RPNResult(expression);

            try {
                double calculatedResult = calculator.calculate(expression);

                result.setResult(calculatedResult);
            } catch (IllegalArgumentException e) {
                result.setException(e);
            } catch (UnsupportedOperationException e) {
                result.setException(e);
            }

            responseHandler.handle(result);
        });
    }
}
