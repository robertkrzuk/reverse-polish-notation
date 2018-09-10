package com.inweo.rpn.operation;

import static com.inweo.rpn.utils.AppConstant.SUBTRACTION;

public class Subtraction implements Operation {

    public boolean applies(String input) {
        return SUBTRACTION.equals(input);
    }

    public double result(double a, double b) {
        return a - b;
    }
}
