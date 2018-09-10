package com.inweo.rpn.calculate;

import com.inweo.rpn.operation.Addition;
import com.inweo.rpn.operation.Operation;
import com.inweo.rpn.operation.Subtraction;
import com.inweo.rpn.utils.StringDoubleUtils;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class RPNCalculator implements Calculator {

    private List<Operation> operations = new ArrayList<Operation>();

    public RPNCalculator() {
        operations.add(new Addition());
        operations.add(new Subtraction());
    }

    public double calculate(String expression) throws IllegalArgumentException, UnsupportedOperationException {

        if (expression == null) {
            throw new IllegalArgumentException("Provided Reverse Polish Notation expression is wrong");
        }

        String[] expressionParts = expression.split(" ");

        Stack<Double> stack = new Stack<Double>();

        for (int i = 0; i < expressionParts.length; i++) {
            if (isDouble(expressionParts[i])) {
                stack.push(StringDoubleUtils.convert(expressionParts[i]));
            } else {
                try {
                    double b = stack.pop();
                    double a = stack.pop();

                    double subResult = calculateSubresult(a, b, expressionParts[i]);

                    stack.push(subResult);
                } catch (EmptyStackException emptyStackException) {
                    throw new IllegalArgumentException("Provided Reverse Polish Notation expression is wrong");
                }
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Provided Reverse Polish Notation expression is wrong");
        }

        return stack.pop();
    }

    private boolean isDouble(String input) {
        return StringDoubleUtils.isProperDouble(input);
    }

    private double calculateSubresult(double a, double b, String operationExpression) {
        Operation operation = findProperOperationExecutor(operationExpression);

        return operation.result(a, b);
    }

    private Operation findProperOperationExecutor(String operationExpression) {
        return operations.stream().filter(operation -> operation.applies(operationExpression)).findFirst().orElseThrow(() -> new UnsupportedOperationException("Unable to find proper Operation Executor"));
    }
}
