package com.inweo.rpn.calculate;

public interface Calculator {
    double calculate(String expresion) throws IllegalArgumentException, UnsupportedOperationException;
}
