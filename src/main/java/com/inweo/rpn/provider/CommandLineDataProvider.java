package com.inweo.rpn.provider;

import java.util.Arrays;
import java.util.List;

public class CommandLineDataProvider implements DataProvider {

    private static final String DELIMITER = ";";

    @Override
    public List<String> provide(String inputExpression) {
        if (inputExpression == null) {
            throw new IllegalArgumentException("Invalid Reverse Polish Notation input expression");
        }

        return Arrays.asList(inputExpression.split(DELIMITER));
    }
}
