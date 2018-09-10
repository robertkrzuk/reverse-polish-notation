package com.inweo.rpn.model;

public class RPNResult {

    public RPNResult(String inputExpression) {
        this.inputExpression = inputExpression;
    }

    private String inputExpression;

    private double result;

    private Exception exception;

    public String getInputExpression() {
        return inputExpression;
    }

    public void setInputExpression(String inputExpression) {
        this.inputExpression = inputExpression;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
}
