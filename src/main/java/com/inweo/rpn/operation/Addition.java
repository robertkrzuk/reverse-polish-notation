package com.inweo.rpn.operation;

import static com.inweo.rpn.utils.AppConstant.ADDITION;

public class Addition implements Operation {

    public boolean applies(String input) {
        return ADDITION.equals(input);
    }

    public double result(double a, double b) {
        return a + b;
    }
}
