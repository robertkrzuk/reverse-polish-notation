package com.inweo.rpn.handler;

import com.inweo.rpn.model.RPNResult;

public class SystemPrintResponseHandler implements ResponseHandler {

    public static final String SUCCESS_RESPONSE = "Result for expression: %s is %s";

    public static final String ERROR_RESPONSE = "Error. For expression: %s, error message: %s";

    @Override
    public void handle(RPNResult result) {
        if (result.getException() != null) {
            System.out.printf(ERROR_RESPONSE, result.getInputExpression(), result.getException().getMessage());
        } else {
            System.out.printf(SUCCESS_RESPONSE, result.getInputExpression(), result.getResult());
        }
    }
}
