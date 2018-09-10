package com.inweo.rpn.operation;

public interface Operation {

    boolean applies(String input);

    double result(double a, double b);
}
